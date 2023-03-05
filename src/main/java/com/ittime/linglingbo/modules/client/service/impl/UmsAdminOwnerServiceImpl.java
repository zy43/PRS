package com.ittime.linglingbo.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.ittime.linglingbo.common.constant.WithdrawStatusEnum;
import com.ittime.linglingbo.modules.client.convert.OwnerConvert;
import com.ittime.linglingbo.modules.client.model.param.AddOwnerParam;
import com.ittime.linglingbo.modules.client.model.param.OwnerCertificateParam;
import com.ittime.linglingbo.modules.client.model.vo.OwnerListVO;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminOwnerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.client.service.UmsAdminOwnerService;
import com.ittime.linglingbo.modules.goods.mapper.TblCateGoodsRelationMapper;
import com.ittime.linglingbo.modules.goods.mapper.TblCategoryGoodsMapper;
import com.ittime.linglingbo.modules.goods.model.TblCateGoodsRelation;
import com.ittime.linglingbo.modules.task.mapper.TblClientWithdrawCashMapper;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;
import com.ittime.linglingbo.modules.ums.dto.UmsIncomeVO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawDTO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawRecordVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 品牌商/政府机构表 服务实现类
 * </p>
 *
 * @author lxw
 */
@Service
public class UmsAdminOwnerServiceImpl extends ServiceImpl<UmsAdminOwnerMapper, UmsAdminOwner> implements UmsAdminOwnerService {

    @Autowired
    private OwnerConvert ownerConvert;

    @Autowired
    private TblCateGoodsRelationMapper tblCateGoodsRelationMapper;

    @Autowired
    private UmsAdminOwnerMapper umsAdminOwnerMapper;

    @Autowired
    private TblClientWithdrawCashMapper tblClientWithdrawCashMapper;

    @Override
    public IPage<OwnerListVO> list(Integer pageSize, Integer pageNum) {
        //分页对象
        Page<UmsAdminOwner> page = new Page<>(pageNum, pageSize);
        //条件查询
        LambdaQueryWrapper<UmsAdminOwner> queryWrapper = new LambdaQueryWrapper<>();

        IPage<UmsAdminOwner> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(umsAdminOwner -> {
            OwnerListVO ownerListVO = ownerConvert.toOwnerListVO(umsAdminOwner);
            return ownerListVO;
        });

    }

    @Override
    public List<OwnerListVO> listAll() {
        List<UmsAdminOwner> list = baseMapper.selectList(new QueryWrapper<>());
        List<OwnerListVO> vos = new ArrayList<>();
        list.forEach(umsAdminOwner -> {
            OwnerListVO ownerListVO = ownerConvert.toOwnerListVO(umsAdminOwner);
            vos.add(ownerListVO);
        });
        return vos;
    }

    @Override
    public boolean addOwner(AddOwnerParam param) {
        UmsAdminOwner owner = new UmsAdminOwner();
        BeanUtils.copyProperties(param, owner);
        try {
            // 得到品牌商id
            baseMapper.insert(owner);
            Long ownerId = owner.getId();
            // 插入品牌商的商品分类到中间表
            Long[] ids = param.getGoodsCategoryIds();
            for (int i = 0; i < ids.length; i++) {
                TblCateGoodsRelation cateGoodsRelation = new TblCateGoodsRelation(ownerId, ids[i], "owner");
                tblCateGoodsRelationMapper.insert(cateGoodsRelation);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean certificate(OwnerCertificateParam param, Long ownerId) {
        // 预留逻辑：判断身份证号和姓名对的上
        {
            String idCard = param.getIdCard();
            String realName = param.getRealName();
            System.out.println("调用身份验证接口...");
        }
        // 身份符合 提交审核
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.eq("id", ownerId);
        updateWrapper.set("certification", "审核中");
        baseMapper.update(null, updateWrapper);
        return true;
    }

    @Override
    public boolean deposit(String username, BigDecimal amount) {

        return umsAdminOwnerMapper.deposit(username,amount);
    }

    @Override
    public List<UmsIncomeVO> incomeListAll() {
        return umsAdminOwnerMapper.incomeListAll();
    }

    @Override
    public List<UmsIncomeVO> incomeList(Integer pageSize, Integer pageNum, String ownerName) {
        Integer offSet = (pageNum - 1) * pageSize;
        return umsAdminOwnerMapper.incomeList(pageSize, offSet, ownerName);
    }

    @Override
    public Long incomeTotalCount(String ownerName) {
        return umsAdminOwnerMapper.incomeTotalCount(ownerName);
    }

    @Override
    public List<UmsWithdrawRecordVO> withdrawRecordOwner(Integer pageSize, Integer pageNum, String personName) {
        Integer offSet = (pageNum - 1) * pageSize;
        return umsAdminOwnerMapper.withdrawRecordOwner(pageSize, offSet, personName);
    }

    @Override
    public List<UmsWithdrawRecordVO> withdrawRecordStreamer(Integer pageSize,Integer pageNum,String personName) {
        Integer offSet = (pageNum - 1) * pageSize;
        return umsAdminOwnerMapper.withdrawRecordStreamer(pageSize, offSet, personName);
    }

    @Override
    public int withdraw(TblClientWithdrawCash dto, Long clientId, Long roleId) {

        //设置状态为待审核
        dto.setWithdrawStatus(WithdrawStatusEnum.AUDIT.getValue());
        //设置clientId
        dto.setClientId(clientId);
        //设置roleId
        dto.setRoleId(roleId);

        return tblClientWithdrawCashMapper.insert(dto);
    }

    @Override
    public Long withdrawOwnerTotalCount(String personName) {
        return umsAdminOwnerMapper.withdrawOwnerTotalCount(personName);
    }

    @Override
    public Long withdrawStreamerTotalCount(String personName) {
        return umsAdminOwnerMapper.withdrawStreamerTotalCount(personName);
    }
}
