package com.ittime.linglingbo.modules.video.convert;

import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.modules.video.model.vo.HotVideoVO;
import com.ittime.linglingbo.modules.video.model.vo.VideoAnalysisVo;
import com.ittime.linglingbo.modules.video.model.vo.VideoInfoVo;
import com.ittime.linglingbo.modules.video.model.vo.VideoRankVO;
import org.mapstruct.Mapper;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Mapper(componentModel = "spring")
public interface VideoInfoConvert {

    VideoInfoVo toVideoInfoListVo(TblVideoInfo tblVideoInfo);

    HotVideoVO tohotVideoVO(TblVideoInfo tblVideoInfo);

    VideoRankVO toVideoRankVO(TblVideoInfo tblVideoInfo);

}
