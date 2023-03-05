package com.ittime.linglingbo.modules.task.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.task.model.param.TaskOwnerAddParam;
import com.ittime.linglingbo.modules.task.model.vo.TaskListOwnerVo;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
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
@Api(tags = "TaskOwnerController")
@Tag(name = "TaskOwnerController", description = "任务模块-品牌商")
@RequestMapping("/task/owner")
public class TaskOwnerController {
    @Autowired
    private TblTaskService taskService;

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation("根据任务名分页获取任务列表")
    @GetMapping("/list")
    public CommonResult<CommonPage<TaskListOwnerVo>> list(
            @RequestParam(value = "taskName", required = false) String taskName,
            @RequestParam(value = "goodsCategory", required = false) String goodsCategory,
            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<TaskListOwnerVo> taskList = taskService.listForOwner(pageSize, pageNum, taskName, goodsCategory, brand);
        return CommonResult.success(CommonPage.restPage(taskList));
    }

    @ApiOperation("根据任务名获取全部任务列表")
    @GetMapping("/listAll")
    public CommonResult<List<TaskListOwnerVo>> list(@RequestParam(value = "taskName", required = false) String taskName,
                                                    @RequestParam(value = "goodsCategory", required = false) String goodsCategory,
                                                    @RequestParam(value = "brand", required = false) String brand) {
        return CommonResult.success(taskService.listAllForOwner(taskName, goodsCategory, brand));
    }

    @ApiOperation("删除任务")
    @DeleteMapping("/{id}")
    public CommonResult delete(Principal principal, @PathVariable Long id) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        return CommonResult.buildResult(taskService.delete(admin.getClientId(), id));
    }

    @ApiOperation("查询任务")
    @GetMapping("/{id}")
    public CommonResult detail(Principal principal, @PathVariable Long id) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        return CommonResult.success(taskService.detailForOwner(admin.getClientId(), id));
    }

    @ApiOperation("修改任务")
    @PutMapping("/{id}")
    public CommonResult update(Principal principal,
                               @PathVariable Long id,
                               @RequestBody TaskOwnerAddParam taskOwnerAddParam) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        taskOwnerAddParam.setTaskId(id);
        return CommonResult.buildResult(taskService.updateTask(admin.getClientId(), taskOwnerAddParam));
    }

    @ApiOperation("新增任务")
    @PostMapping
    public CommonResult create(Principal principal, @RequestBody TaskOwnerAddParam taskOwnerAddParam) {
        UmsAdmin admin = adminService.getAdminByUsername(principal.getName());
        return CommonResult.buildResult(taskService.create(admin.getClientId(), taskOwnerAddParam));
    }
}

