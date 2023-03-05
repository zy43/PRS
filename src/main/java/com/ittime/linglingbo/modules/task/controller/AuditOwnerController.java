package com.ittime.linglingbo.modules.task.controller;


import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author dujianghui
 */
@RestController
@Api(tags = "AuditOwnerController")
@Tag(name = "AuditOwnerController", description = "审核管理-品牌方")
@RequestMapping("/audit/owner")
public class AuditOwnerController {

    @Autowired
    private TblTaskService taskService;


    @ApiOperation("任务承接审核")
    @PostMapping("/undertake")
    public CommonResult auditUndertake(@RequestParam(value = "taskId") Long taskId, @RequestParam(value = "pass") Boolean pass) {
        return CommonResult.buildResult(taskService.auditUndertake(taskId, pass));
    }

    @ApiOperation("任务结算审核")
    @PostMapping("/settle")
    public CommonResult auditSettle(@RequestParam(value = "taskId") Long taskId, @RequestParam(value = "pass") Boolean pass) {
        return CommonResult.buildResult(taskService.auditSettle(taskId, pass));
    }
}

