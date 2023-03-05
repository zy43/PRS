package com.ittime.linglingbo.modules.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.modules.goods.convert.CateGoodsConvert;
import com.ittime.linglingbo.modules.goods.mapper.TblCategoryGoodsMapper;
import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.vo.CateGoodsListVo;
import com.ittime.linglingbo.modules.goods.service.TblCategoryGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 带货商品分类表 服务实现类
 * </p>
 *
 * @author Zhl
 * @since 2022-10-24
 */
@Service
public class TblCategoryGoodsServiceImpl extends ServiceImpl<TblCategoryGoodsMapper, TblCategoryGoods> implements TblCategoryGoodsService {

    @Autowired
    private CateGoodsConvert cateGoodsConvert;

    @Override
    public IPage<CateGoodsListVo> list(String cateGoodsName, Integer pageSize, Integer pageNum) {
        //分页对象
        Page<TblCategoryGoods> page = new Page<>(pageNum, pageSize);
        //条件查询
        LambdaQueryWrapper<TblCategoryGoods> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotEmpty(cateGoodsName), TblCategoryGoods::getCategoryName, cateGoodsName);
        //categoryGoods对象
        IPage<TblCategoryGoods> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(categoryGoods -> {
            CateGoodsListVo cateGoodsListVo = cateGoodsConvert.toCateGoodsListVo(categoryGoods);
            return cateGoodsListVo;
        });
    }

    @Override
    public List<CateGoodsListVo> listAll() {
        List<TblCategoryGoods> categoryGoodsList = baseMapper.selectList(null);

        List<CateGoodsListVo> cateGoodsListVoList = categoryGoodsList.stream().map((categoryGoods) -> {
            CateGoodsListVo cateGoodsListVo = cateGoodsConvert.toCateGoodsListVo(categoryGoods);
            return cateGoodsListVo;
        }).collect(Collectors.toList());

        return cateGoodsListVoList;
    }

}
