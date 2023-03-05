package com.ittime.linglingbo.modules.favorite.service;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteStreamer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 主播收藏表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
public interface TblFavoriteStreamerService extends IService<TblFavoriteStreamer> {

    /**
     * 收藏主播
     * @param xxId
     * @param id
     * @return
     */
    boolean create(Long xxId, Long id);
}
