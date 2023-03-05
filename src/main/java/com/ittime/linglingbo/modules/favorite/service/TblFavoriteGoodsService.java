package com.ittime.linglingbo.modules.favorite.service;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteGoods;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品收藏表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
public interface TblFavoriteGoodsService extends IService<TblFavoriteGoods> {

    /**
     * 添加商品收藏
     * @param xxId
     * @param id
     * @return
     */
    boolean create(Long xxId, Long id);
}
