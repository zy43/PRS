package com.ittime.linglingbo.modules.goods.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.goods.model.param.GoodsParam;
import com.ittime.linglingbo.modules.goods.model.param.PageQueryParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsDetailVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsListVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsRankVO;
import com.ittime.linglingbo.modules.goods.service.TblGoodsService;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.video.model.vo.VideoRankVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@RestController
@Api(tags = "TblGoodsController")
@Tag(name = "TblGoodsController", description = "商品管理")
@RequestMapping("/goods")
public class TblGoodsController {

    @Autowired
    private TblGoodsService goodsService;

    @Autowired
    private UmsAdminService adminService;

    @ApiOperation("根据条件进行商品分页查找")
    @GetMapping("/list")
    public CommonResult<CommonPage<GoodsListVo>> list(PageQueryParam param) {
        IPage<GoodsListVo> goodsList = goodsService.list(param);
        return CommonResult.success(CommonPage.restPage(goodsList));
    }

    @ApiOperation("获取全部商品")
    @GetMapping("/listAll")
    public CommonResult<List<GoodsDetailVo>> listAll(String goodsName, String brandName, Long categoryId) {
        List<GoodsDetailVo> goodsList = goodsService.listAll(goodsName, brandName, categoryId);
        return CommonResult.success(goodsList);
    }

    @ApiOperation("添加商品")
    @PostMapping
    public CommonResult<String> create(GoodsParam goodsParam, Principal principal) {
        //ownerId
        Long id = adminService.getAdminByUsername(principal.getName()).getClientId();

        boolean success = goodsService.create(goodsParam, id);
        if (success) {
            return CommonResult.success("添加成功");
        } else {
            return CommonResult.failed("添加失败");
        }
    }


    @ApiOperation("编辑商品信息")
    @PutMapping
    public CommonResult<String> update(GoodsParam goodsParam) {
        boolean success = goodsService.updateGoods(goodsParam);
        if (success) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("查找单个商品")
    @GetMapping("/{id}")
    public CommonResult<GoodsDetailVo> get(@PathVariable Long id) {
        GoodsDetailVo goodsDetailVo = goodsService.getGoods(id);
        return CommonResult.success(goodsDetailVo);
    }

    @ApiOperation("删除单个商品")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id) {
        boolean success = goodsService.deleteGoods(id);
        if (success) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed("删除失败！");
    }


    @ApiOperation("电商商品排行")
    @PostMapping("/rank")
    public CommonResult<CommonPage<GoodsRankVO>> goodsRank(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<GoodsRankVO> vos = goodsService.goodsRank(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(vos));
    }

}

