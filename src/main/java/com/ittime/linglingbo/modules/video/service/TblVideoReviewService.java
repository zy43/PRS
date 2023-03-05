package com.ittime.linglingbo.modules.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.modules.video.model.TblVideoReview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.video.model.param.VideoReviewParam;
import com.ittime.linglingbo.modules.video.model.vo.VideoReviewVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblVideoReviewService extends IService<TblVideoReview> {

    /**
     * 评论检索
     * @param pageSize
     * @param pageNum
     * @param param
     * @return
     */
    IPage<VideoReviewVo> searchList(Integer pageSize, Integer pageNum, VideoReviewParam param);
}
