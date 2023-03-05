package com.ittime.linglingbo.modules.favorite.service.impl;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteGoods;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteGoodsMapper;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品收藏表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@Service
public class TblFavoriteGoodsServiceImpl extends ServiceImpl<TblFavoriteGoodsMapper, TblFavoriteGoods> implements TblFavoriteGoodsService {




    @Override
    public boolean create(Long xxId, Long id) {
        TblFavoriteGoods favoriteGoods = new TblFavoriteGoods();
        favoriteGoods.setGoodsId(xxId);
        favoriteGoods.setAdminId(id);
        return save(favoriteGoods);
    }
}
