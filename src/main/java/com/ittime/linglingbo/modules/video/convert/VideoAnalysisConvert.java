package com.ittime.linglingbo.modules.video.convert;

import com.ittime.linglingbo.modules.video.model.*;
import com.ittime.linglingbo.modules.video.model.vo.*;
import org.mapstruct.Mapper;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Mapper(componentModel = "spring")
public interface VideoAnalysisConvert {

    VideoAnalysisVo toVideoAnalysisVo(TblVideoInfo tblVideoInfo);

    VideoReviewVo toVideoReviewVo(TblVideoReview tblVideoReview);

    VideoViewersSexVo toVideoViewersSexVo(TblVideoViewersSex tblVideoViewersSex);

    VideoViewersAgeVo toVideoViewersAgeVo(TblVideoViewersAge tblVideoViewersAge);

    VideoViewersRegionVo toVideoViewersRegionVo(TblVideoViewersRegion tblVideoViewersRegion);
}
