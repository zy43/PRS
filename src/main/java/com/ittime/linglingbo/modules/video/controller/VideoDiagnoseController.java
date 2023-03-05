package com.ittime.linglingbo.modules.video.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.minio.mapper.TblImageMapper;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.video.convert.VideoAnalysisConvert;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.modules.video.model.TblVideoViewersAge;
import com.ittime.linglingbo.modules.video.model.TblVideoViewersRegion;
import com.ittime.linglingbo.modules.video.model.TblVideoViewersSex;
import com.ittime.linglingbo.modules.video.model.param.VideoAnalysisParam;
import com.ittime.linglingbo.modules.video.model.param.VideoAudienceParam;
import com.ittime.linglingbo.modules.video.model.param.VideoReviewParam;
import com.ittime.linglingbo.modules.video.model.vo.*;
import com.ittime.linglingbo.modules.video.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@RestController
@Api(tags = "VideoDiagnoseController")
@Tag(name = "VideoDiagnoseController", description = "带货能力诊断")
@RequestMapping("/monitor/saleCheck/VideoAnalysis")
public class VideoDiagnoseController {

    @Autowired
    private TblVideoReviewService videoReviewService;

    @Autowired
    private TblVideoInfoService videoInfoService;

    @Autowired
    private VideoAnalysisConvert videoAnalysisConvert;

    @Autowired
    private TblVideoViewersSexService videoViewersSexService;

    @Autowired
    private TblVideoViewersAgeService videoViewersAgeService;

    @Autowired
    private TblVideoViewersRegionService videoViewersRegionService;

    @Autowired
    private UmsAdminStreamerMapper streamerMapper;

    @Autowired
    private TblImageMapper imageMapper;

    @Autowired
    private TblStreamerAppendMapper tblStreamerAppendMapper;




    @ApiOperation("获取视频相关信息")
    @PostMapping("/info")
    public CommonResult<VideoAnalysisVo> list(@RequestBody VideoAnalysisParam param) {
        VideoAnalysisVo videoAnalysisVo = videoAnalysisConvert.toVideoAnalysisVo(videoInfoService
                .getOne(new LambdaQueryWrapper<TblVideoInfo>().eq(TblVideoInfo::getVideoUrl, param.getVideoUrl())));
        // 获取当前诊断时间并注入
        Date date = new Date();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(date);
//        System.out.println(sdf.format(date));
        videoAnalysisVo.setDiagnoseTime(sdf.format(date));
        // 获取主播名称并注入
        String name = tblStreamerAppendMapper.selectById(videoAnalysisVo.getStreamerId()).getStreamerName();
        videoAnalysisVo.setName(name);
        // 获取主播头像地址并注入
        Long imageId = streamerMapper.getImageId(videoAnalysisVo.getStreamerId());
        String imageUrlById = imageMapper.getImageUrlById(imageId);
        videoAnalysisVo.setImageUrl(imageUrlById);
        return CommonResult.success(videoAnalysisVo);
    }

    @ApiOperation("获取评论")
    @PostMapping("/reviewList")
    public CommonResult<CommonPage<VideoReviewVo>> list(
            @RequestBody VideoReviewParam param,
            @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<VideoReviewVo> VideoReviewVoList = videoReviewService.searchList(pageSize, pageNum, param);
        return CommonResult.success(CommonPage.restPage(VideoReviewVoList));
    }

    @ApiOperation("获取观众分析")
    @PostMapping("/audienceInfo")
    public CommonResult<Map<String,Object>> list(@RequestBody VideoAudienceParam param) {
        HashMap<String, Object> map = new HashMap<>();
        VideoViewersSexVo viewersSexVo = videoAnalysisConvert.toVideoViewersSexVo(videoViewersSexService
                .getOne(new LambdaQueryWrapper<TblVideoViewersSex>().eq(TblVideoViewersSex::getVideoId, param.getVideoId())));
        VideoViewersAgeVo viewersAgeVo = videoAnalysisConvert.toVideoViewersAgeVo(videoViewersAgeService
                .getOne(new LambdaQueryWrapper<TblVideoViewersAge>().eq(TblVideoViewersAge::getVideoId, param.getVideoId())));
        VideoViewersRegionVo viewersRegionVo = videoAnalysisConvert.toVideoViewersRegionVo(videoViewersRegionService
                .getOne(new LambdaQueryWrapper<TblVideoViewersRegion>().eq(TblVideoViewersRegion::getVideoId, param.getVideoId())));

        map.put("sex", viewersSexVo);
        map.put("age", viewersAgeVo);
        map.put("region", viewersRegionVo);
        return CommonResult.success(map);
    }

}
