package com.ittime.linglingbo.modules.owner.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.owner.convert.OwnerAppendConvert;
import com.ittime.linglingbo.modules.owner.model.TblOwnerAppend;
import com.ittime.linglingbo.modules.owner.model.params.OwnerAppendParam;
import com.ittime.linglingbo.modules.owner.model.vo.OwnerDetailVo;
import com.ittime.linglingbo.modules.owner.model.vo.OwnerQueryVo;
import com.ittime.linglingbo.modules.owner.service.TblOwnerAppendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
@RestController
@Api(tags = "TblOwnerAppendController")
@Tag(name = "TblOwnerAppendController", description = "品牌推广")
@RequestMapping("/brand")
public class TblOwnerAppendController {

    @Autowired
    private TblOwnerAppendService ownerAppendService;
    @Autowired
    private OwnerAppendConvert ownerAppendConvert;

    @ApiOperation("电商品牌排行")
    @PostMapping("/list")
    public CommonResult<CommonPage<TblOwnerAppend>> list(
            @RequestBody OwnerAppendParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<TblOwnerAppend> ownerAppendList = ownerAppendService.list(pageSize, pageNum, param);
        return CommonResult.success(CommonPage.restPage(ownerAppendList));
    }

    @ApiOperation("品牌详情")
    @GetMapping("/{ownerId}")
    public CommonResult<OwnerDetailVo> detail(@PathVariable Long ownerId) {
        return CommonResult.success(ownerAppendConvert.toOwnerDetailVo(ownerAppendService.lambdaQuery()
                .eq(TblOwnerAppend::getOwnerId, ownerId).one()));
    }

    @ApiOperation("品牌对比")
    @GetMapping("/queryByName")
    public CommonResult<List<OwnerQueryVo>> queryByName(@RequestParam String ownerName) {
        if (StrUtil.isEmpty(ownerName)) {
            return CommonResult.failed("请输入品牌名称！");
        }
        final List<TblOwnerAppend> list = ownerAppendService.list(new LambdaQueryWrapper<TblOwnerAppend>()
                .like(TblOwnerAppend::getOwnerName, ownerName));
        final List<OwnerQueryVo> ownerQueryVoList = ownerAppendConvert.toOwnerQueryVoList(list);
        for (OwnerQueryVo ownerQueryVo : ownerQueryVoList) {
            ownerQueryVo.setPercentWoman(new BigDecimal(100).subtract(ownerQueryVo.getPercentMan()));
            ownerQueryVo.setHotWordsArray(ownerQueryVo.getHotWords().split(","));
        }
        return CommonResult.success(ownerQueryVoList);
    }


}

