package com.ittime.linglingbo.modules.goods.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.goods.model.*;
import com.ittime.linglingbo.modules.goods.model.param.GoodsSearchParam;
import com.ittime.linglingbo.modules.goods.model.param.GoodsVideosParam;
import com.ittime.linglingbo.modules.goods.service.*;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.service.TblStreamerAppendService;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.modules.video.service.TblVideoInfoService;
import com.ittime.linglingbo.security.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Josh-ZJUT
 * @date 2022/12/10 19:51
 * @email dujianghui537885@163.com
 */
@RestController
@Api(tags = "GoodsSearchController")
@Tag(name = "GoodsSearchController", description = "商品搜索")
@RequestMapping("/goodsSearch")
public class GoodsSearchController {

    @Autowired
    TblGoodsAppendService goodsAppendService;

    @Autowired
    TblGoodsDaylogService goodsDaylogService;

    @Autowired
    TblGoodsRelateVideoService goodsRelateVideoService;

    @Autowired
    TblVideoInfoService videoInfoService;

    @Autowired
    TblGoodsRelateStreamerService goodsRelateStreamerService;

    @Autowired
    TblStreamerAppendService streamerAppendService;

    @Autowired
    TblGoodsAudienceService goodsAudienceService;

    @ApiOperation("分页获取商品列表")
    @PostMapping("/list")
    public CommonResult<CommonPage<TblGoodsAppend>> list(
            @RequestBody GoodsSearchParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<TblGoodsAppend> goodsAppendList = goodsAppendService.list(pageSize, pageNum, param);
        return CommonResult.success(CommonPage.restPage(goodsAppendList));
    }

    @ApiOperation("商品详情")
    @GetMapping("/{goodsId}")
    public CommonResult<TblGoodsAppend> detail(@PathVariable Long goodsId) {
        return CommonResult.success(goodsAppendService.lambdaQuery().eq(TblGoodsAppend::getGoodsId, goodsId).one());
    }

    @ApiOperation("商品增量数据")
    @GetMapping("/{goodsId}/increase")
    public CommonResult<TblGoodsDaylog> increase(
            @RequestParam(value = "logDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date logDate,
            @PathVariable Long goodsId
    ) {
        TblGoodsDaylog goodsDaylog = goodsDaylogService.lambdaQuery()
                .eq(TblGoodsDaylog::getLogDate, logDate)
                .eq(TblGoodsDaylog::getGoodsId, goodsId).one();
        return CommonResult.success(goodsDaylog);
    }

    @ApiOperation("商品近期增量数据")
    @GetMapping("/{goodsId}/increase/recently/{days}")
    public CommonResult<List<TblGoodsDaylog>> increase(
            @PathVariable Long goodsId,
            @PathVariable Integer days
    ) {
        if (days > 30 || days < 1) {
            return CommonResult.failed("请输入正确天数！");
        }
        List<TblGoodsDaylog> list = goodsDaylogService.list(new LambdaQueryWrapper<TblGoodsDaylog>()
                .eq(TblGoodsDaylog::getGoodsId, goodsId)
                .apply("DATE_SUB(CURDATE(), INTERVAL " + days + " DAY) <= log_date"));
        return CommonResult.success(list);
    }

    @ApiOperation("媒体推广视频")
    @PostMapping("/{goodsId}/videos")
    public CommonResult<CommonPage<TblVideoInfo>> videos(
            @PathVariable Long goodsId,
            @RequestBody GoodsVideosParam param,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ) throws ParseException {
        final List<Long> videoIds = goodsRelateVideoService.list(new LambdaQueryWrapper<TblGoodsRelateVideo>()
                        .eq(TblGoodsRelateVideo::getGoodsId, goodsId))
                .stream()
                .map(TblGoodsRelateVideo::getVideoId)
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(videoIds)) {
            CommonResult.success("没有数据！");
        }
        final String releaseTimeFrom = param.getReleaseTimeFrom();
        final String releaseTimeTo = param.getReleaseTimeTo();
        final IPage<TblVideoInfo> page = videoInfoService.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<TblVideoInfo>()
                        .in(CollectionUtil.isNotEmpty(videoIds), TblVideoInfo::getVideoId, videoIds)
                        .ge(releaseTimeFrom != null, TblVideoInfo::getReleaseTime, releaseTimeFrom)
                        .le(releaseTimeTo != null, TblVideoInfo::getReleaseTime, DateUtil.delayOneDay(releaseTimeTo)));
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("在售播主分析")
    @GetMapping("/{goodsId}/streamers")
    public CommonResult<CommonPage<TblStreamerAppend>> streamers(
            @PathVariable Long goodsId,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ) {
        final List<Long> streamerIds = goodsRelateStreamerService.list(new LambdaQueryWrapper<TblGoodsRelateStreamer>()
                        .eq(TblGoodsRelateStreamer::getGoodsId, goodsId))
                .stream().map(TblGoodsRelateStreamer::getStreamerId)
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(streamerIds)) {
            CommonResult.success("没有数据！");
        }
        final IPage<TblStreamerAppend> page = streamerAppendService.page(new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<TblStreamerAppend>()
                        .in(CollectionUtil.isNotEmpty(streamerIds),TblStreamerAppend::getStreamerId, streamerIds));
        return CommonResult.success(CommonPage.restPage(page));
    }

    @ApiOperation("商品观众占比")
    @GetMapping("/{goodsId}/audience")
    public CommonResult<TblGoodsAudience> audience(@PathVariable Long goodsId) {
        final TblGoodsAudience audience = goodsAudienceService.lambdaQuery()
                .eq(TblGoodsAudience::getGoodsId, goodsId)
                .one();
        final Double age617 = audience.getPAge617();
        final Double age1824 = audience.getPAge1824();
        final Double age2530 = audience.getPAge2530();
        final Double age3135 = audience.getPAge3135();
        final Double age3640 = audience.getPAge3640();
        final Double age41 = audience.getPAge41();
        double total = age617 + age1824 + age2530 + age3135 + age3640 + age41;
        if (total > 1) {
            // 转换成百分比
            audience.setPAge617(age617 / total);
            audience.setPAge1824(age1824 / total);
            audience.setPAge2530(age2530 / total);
            audience.setPAge3135(age3135 / total);
            audience.setPAge3640(age3640 / total);
            audience.setPAge41(age41 / total);
        }
        return CommonResult.success(audience);
    }

}
