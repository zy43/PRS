package com.ittime.linglingbo.modules.favorite.service.impl;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteGoods;
import com.ittime.linglingbo.modules.favorite.model.TblFavoriteStreamer;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteStreamerMapper;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteStreamerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 主播收藏表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@Service
public class TblFavoriteStreamerServiceImpl extends ServiceImpl<TblFavoriteStreamerMapper, TblFavoriteStreamer> implements TblFavoriteStreamerService {

    @Override
    public boolean create(Long xxId, Long id) {
        TblFavoriteStreamer favoriteStreamer = new TblFavoriteStreamer();
        favoriteStreamer.setStreamerId(xxId);
        favoriteStreamer.setAdminId(id);
        return save(favoriteStreamer);
    }
}
