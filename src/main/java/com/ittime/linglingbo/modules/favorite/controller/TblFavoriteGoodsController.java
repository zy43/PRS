package com.ittime.linglingbo.modules.favorite.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.favorite.model.param.AddFavoritesParam;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteGoodsService;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteStreamerService;
import com.ittime.linglingbo.modules.favorite.service.TblFavoriteVideoService;
import com.ittime.linglingbo.modules.goods.model.param.GoodsAppendSearchParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsAppendVo;
import com.ittime.linglingbo.modules.goods.service.TblGoodsAppendService;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * <p>
 * 商品收藏表 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@RestController
@Api(tags = "TblFavoriteGoodsController")
@Tag(name = "TblFavoriteGoodsController", description = "商品收藏")
@RequestMapping("/monitor/collection/tblFavoriteGoods")
public class TblFavoriteGoodsController {

    @Autowired
    private TblGoodsAppendService goodsAppendService;

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private TblFavoriteGoodsService favoriteGoodsService;

    @Autowired
    private TblFavoriteStreamerService favoriteStreamerService;

    @Autowired
    private TblFavoriteVideoService favoriteVideoService;




    @ApiOperation("添加收藏(addType：收藏类型（0：收藏商品；1：收藏播主；2：收藏视频))")
    @PostMapping("/addFavorites")
    public CommonResult<String> create(@RequestBody AddFavoritesParam addFavoritesParam, Principal principal) {
        //用户Id
        Long id = adminService.getAdminByUsername(principal.getName()).getId();
        Integer addType = addFavoritesParam.getAddType();
        boolean success;
        if(addType == 0)
             success = favoriteGoodsService.create(addFavoritesParam.getXxId(), id);
        else if (addType == 1) {
            success = favoriteStreamerService.create(addFavoritesParam.getXxId(), id);
        }
        else success = favoriteVideoService.create(addFavoritesParam.getXxId(), id);

        if (success) {
            return CommonResult.success("收藏成功");
        } else {
            return CommonResult.failed("收藏失败");
        }
    }


    @ApiOperation("收藏商品关键词搜索(商品名称)")
    @PostMapping("/list")
    public CommonResult<CommonPage<GoodsAppendVo>> list(
            @RequestBody GoodsAppendSearchParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            Principal principal) {
        //用户id
        Long userId = adminService.getAdminByUsername(principal.getName()).getId();
        IPage<GoodsAppendVo> GoodsAppendVoList = goodsAppendService.searchList(pageSize, pageNum, param, userId);
        return CommonResult.success(CommonPage.restPage(GoodsAppendVoList));
    }

}

