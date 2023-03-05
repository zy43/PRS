package com.ittime.linglingbo.modules.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteGoodsMapper;
import com.ittime.linglingbo.modules.favorite.model.TblFavoriteGoods;
import com.ittime.linglingbo.modules.goods.convert.GoodsAppendConvert;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsAppendMapper;
import com.ittime.linglingbo.modules.goods.model.TblGoodsAppend;
import com.ittime.linglingbo.modules.goods.model.param.GoodsAppendSearchParam;
import com.ittime.linglingbo.modules.goods.model.param.GoodsSearchParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsAppendVo;
import com.ittime.linglingbo.modules.goods.service.TblGoodsAppendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Service
public class TblGoodsAppendServiceImpl extends ServiceImpl<TblGoodsAppendMapper, TblGoodsAppend> implements TblGoodsAppendService {

    @Autowired
    private GoodsAppendConvert goodsAppendConvert;

    @Autowired
    private TblFavoriteGoodsMapper favoriteGoodsMapper;




    @Override
    public IPage<TblGoodsAppend> list(Integer pageSize, Integer pageNum, GoodsSearchParam param) {
        if (param == null) {
            return baseMapper.selectPage(new Page<>(pageNum, pageSize), null);
        }
        //todo 最近几天的逻辑 param.day字段
        LambdaQueryWrapper<TblGoodsAppend> lambdaQueryWrapper = new LambdaQueryWrapper<TblGoodsAppend>()
                // 商品分类
                .eq(StrUtil.isNotEmpty(param.getGoodsTag()), TblGoodsAppend::getGoodsTag, param.getGoodsTag())
                // 售价
                .between(param.getPriceTo() != null, TblGoodsAppend::getPrice, param.getPriceFrom(), param.getPriceTo())
                // 销量
                .between(param.getGoodsSalesTo() != null, TblGoodsAppend::getGoodsSales, param.getGoodsSalesFrom(), param.getGoodsSalesTo())
                // 关联博主数
                .between(param.getRelatedStreamerTo() != null, TblGoodsAppend::getRelatedStreamer, param.getRelatedStreamerFrom(), param.getRelatedStreamerTo())
                // 关联视频数
                .between(param.getRelatedVideoTo() != null, TblGoodsAppend::getRelatedVideo, param.getRelatedVideoFrom(), param.getRelatedVideoTo());

        return baseMapper.selectPage(new Page<>(pageNum, pageSize), lambdaQueryWrapper);
    }

    @Override
    public IPage<GoodsAppendVo> searchList(Integer pageSize, Integer pageNum, GoodsAppendSearchParam param, Long userId) {
        //分页对象
        Page<TblGoodsAppend> page = new Page<>(pageNum, pageSize);
        //查找我的收藏商品ids
        List<Long> goodsIds = favoriteGoodsMapper.selectList(new LambdaQueryWrapper<TblFavoriteGoods>()
                .eq(TblFavoriteGoods::getAdminId, userId)).stream().map(TblFavoriteGoods::getGoodsId).collect(Collectors.toList());
        //条件查询--商品名称
        LambdaQueryWrapper<TblGoodsAppend> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotEmpty(param.getKeyword()), TblGoodsAppend::getGoodsName, param.getKeyword())
                .in(TblGoodsAppend::getGoodsId, goodsIds);

        //分页查询
        IPage<TblGoodsAppend> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(goodsAppend -> goodsAppendConvert.toGoodsAppendListVo(goodsAppend));

    }
}
