package com.ittime.linglingbo.modules.task.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.task.model.vo.TaskListOwnerVo;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author dujianghui
 */
@RestController
@Api(tags = "TaskOperatorController")
@Tag(name = "TaskOperatorController", description = "任务模块-运营人员")
@RequestMapping("/task/operator")
public class TaskOperatorController {

    @Autowired
    private TblTaskService taskService;


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
    public CommonResult<List<TaskListOwnerVo>> list(
            @RequestParam(value = "taskName", required = false) String taskName,
            @RequestParam(value = "goodsCategory", required = false) String goodsCategory,
            @RequestParam(value = "brand", required = false) String brand) {
        return CommonResult.success(taskService.listAllForOwner(taskName, goodsCategory, brand));
    }

    @ApiOperation("查询任务")
    @GetMapping("/{id}")
    public CommonResult detail(@PathVariable Long id) {
        return CommonResult.success(taskService.detailForStreamer(id));
    }


}

