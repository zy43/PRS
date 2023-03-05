package com.ittime.linglingbo.modules.owner.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.modules.goods.model.TblGoodsAppend;
import com.ittime.linglingbo.modules.owner.model.TblOwnerAppend;
import com.ittime.linglingbo.modules.owner.mapper.TblOwnerAppendMapper;
import com.ittime.linglingbo.modules.owner.model.params.OwnerAppendParam;
import com.ittime.linglingbo.modules.owner.service.TblOwnerAppendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@Service
public class TblOwnerAppendServiceImpl extends ServiceImpl<TblOwnerAppendMapper, TblOwnerAppend> implements TblOwnerAppendService {

    @Override
    public IPage<TblOwnerAppend> list(Integer pageSize, Integer pageNum, OwnerAppendParam param) {
        if (param == null) {
            return baseMapper.selectPage(new Page<>(pageNum, pageSize), null);
        }
        LambdaQueryWrapper<TblOwnerAppend> lambdaQueryWrapper = new LambdaQueryWrapper<TblOwnerAppend>()
                // 品牌分类
                .like(StrUtil.isNotEmpty(param.getIndustry()), TblOwnerAppend::getIndustry, param.getIndustry())
                // 商品来源
                .like(StrUtil.isNotEmpty(param.getComeFrom()), TblOwnerAppend::getComeFrom, param.getComeFrom())
                // 品牌商名字
                .like(StrUtil.isNotEmpty(param.getOwnerName()), TblOwnerAppend::getOwnerName, param.getOwnerName());
        //todo 近几天数据的筛选 1、7、30
        return baseMapper.selectPage(new Page<>(pageNum, pageSize), lambdaQueryWrapper);
    }
}
