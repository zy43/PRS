package com.ittime.linglingbo.modules.workbench.controller;

import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.workbench.service.StreamerWorkbenchService;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerSettleDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author zhl129
 * @date 2022/12/2 15:21
 * @email 1293384775@qq.com
 */
@RestController
@RequestMapping("/workbench/streamer")
@Api(tags = "StreamerWorkbenchController")
@Tag(name = "StreamerWorkbenchController", description = "首页工作台-主播")
public class StreamerWorkbenchController {

    @Autowired
    private StreamerWorkbenchService streamerWorkbenchService;

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("获取账户信息")
    @GetMapping("/accountInfo")
    public CommonResult<StreamerAccountVo> getAccountInfo(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        StreamerAccountVo streamerAccountVo = streamerWorkbenchService.getAccountInfo(admin);

        return CommonResult.success(streamerAccountVo);

    }

    @ApiOperation("任务数据动态")
    @GetMapping("/taskDynamicData")
    public CommonResult<StreamerDynamicDataVo> getTaskDynamicData(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        StreamerDynamicDataVo streamerDynamicDataVo = streamerWorkbenchService.getTaskDynamicData(admin);
        return CommonResult.success(streamerDynamicDataVo);
    }

    @ApiOperation("任务结算动态")
    @GetMapping("/taskSettleData")
    public CommonResult<StreamerSettleDataVo> getTaskSettleData(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        StreamerSettleDataVo streamerSettleDataVo = streamerWorkbenchService.getTaskSettleData(admin);
        return CommonResult.success(streamerSettleDataVo);
    }
}
