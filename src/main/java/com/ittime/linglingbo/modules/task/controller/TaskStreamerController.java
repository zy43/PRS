package com.ittime.linglingbo.modules.task.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.task.model.TblTaskSettle;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerSettleParam;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerUndertakeParam;
import com.ittime.linglingbo.modules.task.model.vo.TaskListStreamerVo;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
import com.ittime.linglingbo.modules.task.service.TblTaskStreamerService;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


/**
 * @author dujianghui
 */
@RestController
@Api(tags = "TaskStreamerController")
@Tag(name = "TaskStreamerController", description = "任务模块-播主")
@RequestMapping("/task/streamer")
public class TaskStreamerController {
    @Autowired
    private TblTaskService taskService;

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private TblTaskStreamerService taskStreamerService;


    @ApiOperation("根据任务名分页获取任务列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<TaskListStreamerVo>> list(
            @RequestParam(value = "taskName", required = false) String taskName,
            @RequestParam(value = "goodsCategory", required = false) String goodsCategory,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<TaskListStreamerVo> taskList = taskService.listForStreamer(pageSize, pageNum, taskName, goodsCategory, brand);
        return CommonResult.success(CommonPage.restPage(taskList));
    }

    @ApiOperation("根据任务名获取全部任务列表")
    @GetMapping("/listAll")
    public CommonResult<List<TaskListStreamerVo>> list(@RequestParam(value = "taskName", required = false) String taskName) {
        return CommonResult.success(taskService.listAllForStreamer(taskName));
    }

    @ApiOperation("查询任务")
    @GetMapping("/{id}")
    public CommonResult detail(@PathVariable Long id) {
        return CommonResult.success(taskService.detailForStreamer(id));
    }

    @ApiOperation("承接任务")
    @PostMapping("/undertake")
    public CommonResult undertake(Principal principal, @RequestBody TaskStreamerUndertakeParam param) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        param.setStreamerId(admin.getClientId());
        param.setStreamerName(admin.getUsername());
        param.setAuditorOwnerId(taskService.getById(param.getTaskId()).getOwnerId());
        return CommonResult.buildResult(taskStreamerService.undertakeTask(param));
    }

    @ApiOperation("结算任务")
    @PostMapping("/settle")
    public CommonResult settle(Principal principal, @RequestBody TaskStreamerSettleParam param) {
        final TblTaskStreamer taskStreamer = taskStreamerService.lambdaQuery().eq(TblTaskStreamer::getTaskId, param.getTaskId()).one();
        if (!principal.getName().equals(taskStreamer.getStreamerName())) {
            return CommonResult.failed("结算失败，不是你的任务！");
        }
        Long streamerId = adminService.getAdminByUsername(principal.getName()).getClientId();
        for (TblTaskSettle goodsSettle : param.getGoodsSettles()) {
            goodsSettle.setTaskId(param.getTaskId());
            goodsSettle.setStreamerId(streamerId);
        }
        return CommonResult.buildResult(taskStreamerService.settleTask(param));
    }


}

