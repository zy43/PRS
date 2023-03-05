package com.ittime.linglingbo.modules.favorite.service;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 视频收藏表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
public interface TblFavoriteVideoService extends IService<TblFavoriteVideo> {

    /**
     * 收藏视频
     * @param xxId
     * @param id
     * @return
     */
    boolean create(Long xxId, Long id);
}
