package com.ittime.linglingbo.modules.monitor.controller;

import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.client.service.UmsAdminStreamerService;
import com.ittime.linglingbo.modules.monitor.service.MonitorService;
import com.ittime.linglingbo.modules.monitor.vo.AuthorizeVo;
import com.ittime.linglingbo.modules.monitor.vo.MyAccountVo;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.ums.dto.StreamerCompareSearchVo;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author zhl129
 * @date 2022/12/29 17:26
 * @email 1293384775@qq.com
 */
@RestController
@RequestMapping("/monitor")
@Api(tags = "MonitorController")
@Tag(name = "MonitorController", description = "数据监测")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private UmsAdminStreamerService umsAdminStreamerService;


    @ApiOperation("我的抖音号")
    @GetMapping("accountList")
    public CommonResult<List<MyAccountVo>> getMyAccount(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        List<MyAccountVo> myAccountVoList = monitorService.getMyAccount(admin);
        return CommonResult.success(myAccountVoList);
    }

    @ApiOperation("搜索授权抖音信息")
    @GetMapping("/authorize/search")
    public CommonResult<List<StreamerCompareSearchVo>> getStreamerCompareSearch(@RequestParam(name = "key") String key){
        List<StreamerCompareSearchVo> streamerCompareSearchVoList = umsAdminStreamerService.getStreamerCompareSearch(key);
        if(!streamerCompareSearchVoList.isEmpty()){
            return CommonResult.success(streamerCompareSearchVoList);
        }
        return CommonResult.failed("没有查到抖音号信息");
    }

    @ApiOperation("添加授权")
    @PostMapping("/authorize/add")
    public CommonResult<String> authorize(@RequestBody TblStreamerAppend streamerAppend){
        boolean res = monitorService.authorize(streamerAppend.getStreamerId());
        if (res){
            return CommonResult.success("授权成功");
        }
        return CommonResult.failed("已授权过，无法授权");
    }

    @ApiOperation("已授权列表")
    @GetMapping("/authorize/list")
    public CommonResult<List<AuthorizeVo>> authorizedList(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        List<AuthorizeVo> authorizeVoList = monitorService.authorizeList(admin);
        return CommonResult.success(authorizeVoList);
    }

}
