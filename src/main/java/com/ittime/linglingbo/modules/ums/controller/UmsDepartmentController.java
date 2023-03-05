package com.ittime.linglingbo.modules.ums.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.model.UmsDepartment;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.ums.service.UmsDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 组织机构 表 前端控制器
 *
 * @author zhl129
 * @date 2022/10/16 10:56
 * @email 1293384775@qq.com
 */
@RestController
@Api(tags = "UmsDepartmentController")
@Tag(name = "UmsDepartmentController", description = "组织机构管理")
@RequestMapping("/department")
public class UmsDepartmentController {

    @Autowired
    private UmsDepartmentService umsDepartmentService;


    /**
     * 添加组织机构
     *
     * @param umsDepartment
     * @return
     */
    @ApiOperation("添加组织机构")
    @PostMapping
    public CommonResult create(@RequestBody UmsDepartment umsDepartment) {
        boolean success = umsDepartmentService.create(umsDepartment);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    /**
     * 根据id删除组织机构
     *
     * @param id
     * @return
     */
    @ApiOperation("删除组织机构")
    @DeleteMapping("/{id}")
    public CommonResult delete(@PathVariable Long id) {

        boolean success = umsDepartmentService.delete(id);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("组织机构下有用户，无法删除！");
        }
    }

    /**
     * 查询所有组织机构
     *
     * @return
     */
    @ApiOperation("全部组织机构")
    @GetMapping
    public CommonResult list() {
        List<UmsDepartment> list = umsDepartmentService.listAll();
        return CommonResult.success(list);
    }


    /**
     * 根据id修改组织机构
     *
     * @param umsDepartment
     * @return
     */
    @ApiOperation("修改组织机构")
    @PutMapping
    public CommonResult update(@RequestBody UmsDepartment umsDepartment) {
        boolean success = umsDepartmentService.updateById(umsDepartment);
        if (success) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("根据组织机构id返回其下用户列表")
    @GetMapping("/listAdmin")
    public CommonResult<CommonPage<UmsAdmin>> adminListById(@RequestParam(value = "departmentId", required = false) Integer departmentId,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<UmsAdmin> umsAdminIPage = umsDepartmentService.listAdmin(departmentId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(umsAdminIPage));
    }


}
