package com.ittime.linglingbo.modules.client.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.client.model.param.AddOwnerParam;
import com.ittime.linglingbo.modules.client.model.param.OwnerCertificateParam;
import com.ittime.linglingbo.modules.client.model.vo.OwnerListVO;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;
import com.ittime.linglingbo.modules.ums.dto.UmsIncomeVO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawDTO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawRecordVO;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 品牌商/政府机构表 服务类
 * </p>
 *
 * @author lxw
 * @since 2022-09-28
 */
public interface UmsAdminOwnerService extends IService<UmsAdminOwner> {

    /**
     * 分页查询
     * @param pageSize 分页大小
     * @param pageNum 第几页
     * @return
     */
    IPage<OwnerListVO> list(Integer pageSize, Integer pageNum);


    /**
     * 查询全部品牌商
     */
    List<OwnerListVO> listAll();

    /**
     * 添加品牌商
     */
    boolean addOwner(AddOwnerParam param);

    /**
     * 提交实名认证
     */
    boolean certificate(OwnerCertificateParam param, Long ownerId);
    /**
     * 给品牌商充值保证金
     */
    boolean deposit(String username, BigDecimal amount);

    /**
     * 列出所有收入
     *
     * @return {@link List}<{@link UmsIncomeVO}>
     */
    List<UmsIncomeVO> incomeListAll();

    /**
     * 收入列表
     *
     * @param pageSize  页面大小
     * @param pageNum   页面num
     * @param ownerName 品牌商
     * @return {@link List}<{@link UmsIncomeVO}>
     */
    List<UmsIncomeVO> incomeList(Integer pageSize, Integer pageNum, String ownerName);

    Long incomeTotalCount(String ownerName);

    /**
     * 提取记录品牌商
     *
     * @param personName 人名字
     * @return {@link List}<{@link UmsWithdrawRecordVO}>
     */
    List<UmsWithdrawRecordVO> withdrawRecordOwner(Integer pageSize,Integer pageNum,String personName);

    /**
     * 提取记录播主
     *
     * @param personName 人名字
     * @return {@link List}<{@link UmsWithdrawRecordVO}>
     */
    List<UmsWithdrawRecordVO> withdrawRecordStreamer(Integer pageSize,Integer pageNum,String personName);

    int withdraw(TblClientWithdrawCash dto, Long clientId, Long roleId);

    Long withdrawOwnerTotalCount(String personName);

    Long withdrawStreamerTotalCount(String personName);
}
