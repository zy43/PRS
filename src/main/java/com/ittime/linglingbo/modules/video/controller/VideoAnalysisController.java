package com.ittime.linglingbo.modules.video.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.video.model.vo.*;
import com.ittime.linglingbo.modules.video.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@RestController
@Api(tags = "VideoAnalysisController")
@Tag(name = "VideoAnalysisController", description = "视频模块")
@RequestMapping("/video/VideoAnalysis")
public class VideoAnalysisController {

    @Autowired
    private TblVideoInfoService videoInfoService;



    @ApiOperation("热门带货视频")
    @PostMapping("/searchHotVideo")
    public CommonResult<CommonPage<HotVideoVO>> searchHotVideo(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<HotVideoVO> vos = videoInfoService.searchList(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(vos));
    }


    @ApiOperation("电商视频排行")
    @PostMapping("/videoRank")
    public CommonResult<CommonPage<VideoRankVO>> videoRank(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "type", defaultValue = "1") Integer type
                                                           ) {
        // 视频行业排行
        if(type == 2){
            IPage<VideoRankVO> vos = videoInfoService.videoIndustryRank(pageSize, pageNum);
            return CommonResult.success(CommonPage.restPage(vos));
        }
        // 热门视频排行
        else if(type == 3){
            IPage<VideoRankVO> vos = videoInfoService.hotVideoRank(pageSize, pageNum);
            return CommonResult.success(CommonPage.restPage(vos));
        }
        // 默认是品类排行
        else{
            IPage<VideoRankVO> vos = videoInfoService.videoBrandRank(pageSize, pageNum);
            return CommonResult.success(CommonPage.restPage(vos));
        }


    }





}
