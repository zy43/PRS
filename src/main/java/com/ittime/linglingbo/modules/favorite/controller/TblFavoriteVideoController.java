package com.ittime.linglingbo.modules.favorite.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.video.model.param.VideoSearchParam;
import com.ittime.linglingbo.modules.video.model.vo.VideoInfoVo;
import com.ittime.linglingbo.modules.video.service.TblVideoInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 * 视频收藏表 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@RestController
@Api(tags = "TblFavoriteVideoController")
@Tag(name = "TblFavoriteVideoController", description = "视频收藏")
@RequestMapping("/monitor/collection/tblFavoriteVideo")
public class TblFavoriteVideoController {

    @Autowired
    private TblVideoInfoService videoInfoService;

    @Autowired
    private UmsAdminService adminService;



    @ApiOperation("收藏视频关键词搜索(视频名称、热词)")
    @PostMapping("/list")
    public CommonResult<CommonPage<VideoInfoVo>> list(
            @RequestBody VideoSearchParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            Principal principal) {
        //用户id
        Long userId = adminService.getAdminByUsername(principal.getName()).getId();
        IPage<VideoInfoVo> VideoInfoVoList = videoInfoService.list(pageSize, pageNum, param, userId);
        return CommonResult.success(CommonPage.restPage(VideoInfoVoList));
    }
}

