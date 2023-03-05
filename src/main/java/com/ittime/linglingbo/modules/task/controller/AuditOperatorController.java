package com.ittime.linglingbo.modules.task.controller;


import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.task.service.TblClientWithdrawCashService;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * @author dujianghui
 */
@RestController
@Api(tags = "AuditOperatorController")
@Tag(name = "AuditOperatorController", description = "审核管理-运营人员")
@RequestMapping("/audit/operator")
public class AuditOperatorController {

    @Autowired
    private TblTaskService taskService;

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private TblClientWithdrawCashService withdrawCashService;


    @ApiOperation("任务发布审核")
    @PostMapping("/create")
    public CommonResult auditCreate(@RequestParam(value = "taskId") Long taskId, @RequestParam(value = "pass") Boolean pass) {
        return CommonResult.buildResult(taskService.auditCreate(taskId, pass));
    }
    @ApiOperation("提现审核")
    @PostMapping("/withdraw")
    public CommonResult auditWithdraw(Principal principal, @RequestParam(value = "withdraw_id") Long withdrawId, @RequestParam(value = "pass") Boolean pass) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        return CommonResult.buildResult(withdrawCashService.auditWithdraw(withdrawId, pass,admin.getId()));
    }
}

