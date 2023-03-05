package com.ittime.linglingbo.modules.workbench.controller;

import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.workbench.service.OwnerWorkbenchService;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerSettleDataVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author zhl129
 * @date 2022/12/2 15:18
 * @email 1293384775@qq.com
 */
@RestController
@RequestMapping("/workbench/owner")
@Api(tags = "OwnerWorkbenchController")
@Tag(name = "OwnerWorkbenchController", description = "首页工作台-品牌商")
public class OwnerWorkbenchController {

    @Autowired
    private OwnerWorkbenchService ownerWorkbenchService;

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("获取账户信息")
    @GetMapping("/accountInfo")
    public CommonResult<OwnerAccountVo> getAccountInfo(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        OwnerAccountVo ownerAccountVo = ownerWorkbenchService.getAccountInfo(admin);

        return CommonResult.success(ownerAccountVo);

    }

    @ApiOperation("任务数据动态")
    @GetMapping("/taskDynamicData")
    public CommonResult<OwnerDynamicDataVo> getTaskDynamicData(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        OwnerDynamicDataVo ownerDynamicDataVo = ownerWorkbenchService.getTaskDynamicData(admin);
        return CommonResult.success(ownerDynamicDataVo);
    }

    @ApiOperation("任务结算动态")
    @GetMapping("/taskSettleData")
    public CommonResult<OwnerSettleDataVo> getTaskSettleData(Principal principal){
        String name = principal.getName();
        UmsAdmin admin = umsAdminService.getAdminByUsername(name);
        OwnerSettleDataVo ownerSettleDataVo = ownerWorkbenchService.getTaskSettleData(admin);
        return CommonResult.success(ownerSettleDataVo);
    }
}
