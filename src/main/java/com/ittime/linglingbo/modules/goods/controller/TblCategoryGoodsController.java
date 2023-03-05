package com.ittime.linglingbo.modules.goods.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.vo.CateGoodsListVo;
import com.ittime.linglingbo.modules.goods.service.TblCategoryGoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 带货商品分类表 前端控制器
 * </p>
 *
 * @author Zhl
 * @since 2022-10-24
 */
@RestController
@Api(tags = "TblCategoryGoodsController")
@Tag(name = "TblCategoryGoodsController", description = "品类管理-商品分类")
@RequestMapping("/category/goods")
public class TblCategoryGoodsController {

    @Autowired
    private TblCategoryGoodsService categoryGoodsService;


    @GetMapping("/list")
    @ApiOperation("根据商品分类名称获取分页列表")
    @ResponseBody
    public CommonResult<CommonPage<CateGoodsListVo>> list(@RequestParam(value = "cateGoodsName", required = false) String cateGoodsName,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<CateGoodsListVo> cateGoodsList = categoryGoodsService.list(cateGoodsName, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(cateGoodsList));
    }

    @GetMapping("/listAll")
    @ApiOperation("获得所有商品分类")
    @ResponseBody
    public CommonResult<List<CateGoodsListVo>> listAll() {

        List<CateGoodsListVo> cateGoodsListVoList = categoryGoodsService.listAll();
        return CommonResult.success(cateGoodsListVoList);
    }

    @ApiOperation("创建商品分类")
    @PostMapping
    public CommonResult<String> create(@RequestBody TblCategoryGoods categoryGoods) {
        boolean success = categoryGoodsService.save(categoryGoods);
        if (success) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("添加失败");
        }
    }


    @ApiOperation("编辑商品分类")
    @PutMapping
    public CommonResult<String> update(@RequestBody TblCategoryGoods categoryGoods) {
        boolean success = categoryGoodsService.updateById(categoryGoods);
        if (success) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("查询单个商品分类")
    @GetMapping("/{id}")
    public CommonResult<TblCategoryGoods> get(@PathVariable Long id) {
        return CommonResult.success(categoryGoodsService.getById(id));
    }

    @ApiOperation("删除商品分类")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id) {
        boolean success = categoryGoodsService.removeById(id);
        if (success) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed("删除失败！");
    }

}

