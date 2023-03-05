package com.ittime.linglingbo.modules.goods.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.goods.model.TblIndustryCategory;
import com.ittime.linglingbo.modules.goods.model.vo.CateIndustryListVo;
import com.ittime.linglingbo.modules.goods.service.TblIndustryCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 行业分类表 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@RestController
@Api(tags = "TblIndustryCategoryController")
@Tag(name = "TblIndustryCategoryController", description = "品类管理-行业分类")
@RequestMapping("/category/industry")
public class TblIndustryCategoryController {

    @Autowired
    private TblIndustryCategoryService industryCategoryService;

    @GetMapping("/list")
    @ApiOperation("根据行业分类名称获取分页列表")
    @ResponseBody
    public CommonResult<CommonPage<CateIndustryListVo>> list(@RequestParam(value = "cateIndustryName", required = false) String cateIndustryName,
                                                             @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        IPage<CateIndustryListVo> cateIndustryList = industryCategoryService.list(cateIndustryName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(cateIndustryList));
    }

    @GetMapping("/listAll")
    @ApiOperation("获得全部行业分类信息")
    @ResponseBody
    public CommonResult<List<CateIndustryListVo>> listAll() {
        List<CateIndustryListVo> industryListVoList = industryCategoryService.listAll();
        return CommonResult.success(industryListVoList);
    }

    @ApiOperation("创建行业分类")
    @PostMapping
    public CommonResult<String> create(@RequestBody TblIndustryCategory industryCategory) {
        boolean success = industryCategoryService.save(industryCategory);
        if (success) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("编辑行业分类")
    @PutMapping
    public CommonResult<String> update(@RequestBody TblIndustryCategory industryCategory) {
        boolean success = industryCategoryService.updateById(industryCategory);
        if (success) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("查询单个行业分类")
    @GetMapping("/{id}")
    public CommonResult<TblIndustryCategory> get(@PathVariable Long id) {
        return CommonResult.success(industryCategoryService.getById(id));
    }

    @ApiOperation("删除行业分类")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id) {
        boolean success = industryCategoryService.removeById(id);
        if (success) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed("删除失败！");
    }


}

