package com.ittime.linglingbo.modules.favorite.service.impl;

import com.ittime.linglingbo.modules.favorite.model.TblFavoriteVideo;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteVideoMapper;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 视频收藏表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@Service
public class TblFavoriteVideoServiceImpl extends ServiceImpl<TblFavoriteVideoMapper, TblFavoriteVideo> implements TblFavoriteVideoService {

    @Override
    public boolean create(Long xxId, Long id) {
        TblFavoriteVideo favoriteVideo = new TblFavoriteVideo();
        favoriteVideo.setVideoId(xxId);
        favoriteVideo.setAdminId(id);
        return save(favoriteVideo);
    }
}
