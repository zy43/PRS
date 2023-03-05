package com.ittime.linglingbo.modules.favorite.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.streamer.model.param.StreamerSearchParam;
import com.ittime.linglingbo.modules.streamer.model.vo.StreamerAppendVo;
import com.ittime.linglingbo.modules.streamer.service.TblStreamerAppendService;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 * 主播收藏表 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@RestController
@Api(tags = "TblFavoriteStreamerController")
@Tag(name = "TblFavoriteStreamerController", description = "主播收藏")
@RequestMapping("/monitor/collection/tblFavoriteStreamer")
public class TblFavoriteStreamerController {


    @Autowired
    private TblStreamerAppendService streamerAppendService;

    @Autowired
    private UmsAdminService adminService;




    @ApiOperation("收藏主播关键词搜索(主播名称、标签)")
    @PostMapping("/list")
    public CommonResult<CommonPage<StreamerAppendVo>> list(
            @RequestBody StreamerSearchParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            Principal principal) {
        //用户id
        Long userId = adminService.getAdminByUsername(principal.getName()).getId();
        IPage<StreamerAppendVo> StreamerAppendList = streamerAppendService.list(pageSize, pageNum, param, userId);
        return CommonResult.success(CommonPage.restPage(StreamerAppendList));
    }
}

