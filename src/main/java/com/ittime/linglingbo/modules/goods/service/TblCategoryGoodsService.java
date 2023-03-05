package com.ittime.linglingbo.modules.goods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.vo.CateGoodsListVo;

import java.util.List;

/**
 * <p>
 * 带货商品分类表 服务类
 * </p>
 *
 * @author Zhl
 * @since 2022-10-24
 */
public interface TblCategoryGoodsService extends IService<TblCategoryGoods> {

    /**
     * 根据商品分类名称进行分页查询
     *
     * @param cateGoodsName 商品分类名称
     * @param pageSize      分页大小
     * @param pageNum       第几页
     * @return
     */
    IPage<CateGoodsListVo> list(String cateGoodsName, Integer pageSize, Integer pageNum);

    /**
     * 获取所有商品分类
     */
    List<CateGoodsListVo> listAll();
}
