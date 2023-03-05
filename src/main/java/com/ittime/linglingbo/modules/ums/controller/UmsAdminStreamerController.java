package com.ittime.linglingbo.modules.ums.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.client.service.UmsAdminStreamerService;
import com.ittime.linglingbo.modules.ums.dto.*;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

/**
 * 播主/MCN 表 前端控制器
 *
 * @author Josh
 * @since 2022-09-28
 */
@RestController
@Api(tags = "UmsAdminStreamerController")
@Tag(name = "UmsAdminStreamerController", description = "播主视频、播主排行榜")
@RequestMapping("/streamer")
public class UmsAdminStreamerController {

    @Autowired
    private UmsAdminStreamerService umsAdminStreamerService;

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation("播主数据概览")
    @RequestMapping(value = "/detail/general", method = RequestMethod.GET)
    public CommonResult<UmsGeneralVO> general(@RequestParam Integer days, Principal principal) {

        // 根据principal获取播主id
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        UmsAdmin user = getUserInfo(principal);
        UmsGeneralVO res = umsAdminStreamerService.collectGeneralData(user.getId(), days);

        if (res != null) {
            return CommonResult.success(res);
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("粉丝详情")
    @GetMapping(value = "/detail/fans")
    public CommonResult<UmsFansFeatureVO> fans(Principal principal) {

        // 根据principal获取播主id
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        UmsAdmin user = getUserInfo(principal);

        UmsFansFeatureVO res = umsAdminStreamerService.collectFansData(user.getId());
        if (res != null) {
            return CommonResult.success(res);
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("播主视频基础数据")
    @GetMapping(value = "/detail/video/general")
    public CommonResult<UmsVideoGeneralVO> videoGeneral(@RequestParam Integer days, Principal principal) {

        // 根据principal获取播主id
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        UmsAdmin user = getUserInfo(principal);

        UmsVideoGeneralVO res = umsAdminStreamerService.collectVideoGeneralData(user.getId(), days);
        if (res != null) {
            return CommonResult.success(res);
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("播主视频详细数据")
    @GetMapping(value = "/detail/video/detail")
    public CommonResult<CommonPage<UmsVideoDetailVO>> videoDetail(@RequestParam(name = "fromDay") String fromDay,
                                    @RequestParam(name = "endDay") String endDay,
                                    @RequestParam(name = "keyWord",required = false) String keyWord,
                                    @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                    Principal principal) throws ParseException {
        // 根据principal获取播主id
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        UmsAdmin user = getUserInfo(principal);

        IPage<UmsVideoDetailVO> res = umsAdminStreamerService.collectVideoDetailData(fromDay, endDay, keyWord, pageSize, pageNum, user.getId());

        if (res != null) {
            return CommonResult.success(CommonPage.restPage(res));
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("播主相关商品数据")
    @GetMapping(value = "/detail/goods")
    public CommonResult<CommonPage<UmsGoodsVO>> goodsDetail(@RequestParam(name = "days") Integer days,
                                    @RequestParam(name = "keyWord",required = false) String keyWord,
                                    @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum,
                                    Principal principal) {
        // 根据principal获取播主id
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        UmsAdmin user = getUserInfo(principal);
        List<UmsGoodsVO> list = umsAdminStreamerService.getGoodsInfo(user.getId(),days,keyWord,pageSize,pageNum);
        Long total = umsAdminStreamerService.getGoodsCount(user.getId(),days,keyWord);
        return CommonResult.success(CommonPage.listPage(list,total,pageNum,pageSize));
    }

    @ApiOperation("主播行业排行榜")
    @GetMapping(value = "/rank/industry")
    public CommonResult<CommonPage<UmsIndustryRankVO>> industryRank(@RequestParam(name = "industry",required = false) String industry,
                                     @RequestParam(name = "keyWord",required = false) String keyWord,
                                     @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        IPage<UmsIndustryRankVO> res = umsAdminStreamerService.industryRank(keyWord,industry,pageNum,pageSize);
        if (res != null) {
            return CommonResult.success(CommonPage.restPage(res));
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("主播涨粉排行榜")
    @GetMapping(value = "/rank/fans")
    public CommonResult<CommonPage<UmsFansRiseRankVO>> fansRiseRank(@RequestParam(name = "days", defaultValue = "0") Integer days,
                                     @RequestParam(name = "fromDay") String fromDay,
                                     @RequestParam(name = "endDay") String endDay,
                                     @RequestParam(name = "keyWord",required = false) String keyWord,
                                     @RequestParam(name = "industry",required = false) String industry,
                                     @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {

        List<UmsFansRiseRankVO> res = umsAdminStreamerService.fansRiseRank(days, keyWord,fromDay,endDay, industry, pageNum, pageSize);
        Long total = umsAdminStreamerService.getFansTotalCount(days,keyWord,fromDay,endDay, industry);
        if (res != null) {
            return CommonResult.success(CommonPage.listPage(res,total,pageNum,pageSize));
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("地区排行榜")
    @GetMapping(value = "/rank/region")
    public CommonResult<CommonPage<UmsIndustryRankVO>> regionRank(@RequestParam(name = "keyWord",required = false) String keyWord,
                                   @RequestParam(name = "province",required = false) String province,
                                   @RequestParam(name = "city",required = false) String city,
                                   @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                   @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsIndustryRankVO> res = umsAdminStreamerService.regionRank(keyWord, province, city, pageNum, pageSize);
        Long total = umsAdminStreamerService.getRegionTotalCount(keyWord, province, city);
        if (res != null) {
            return CommonResult.success(CommonPage.listPage(res,total,pageNum,pageSize));
        }

        return CommonResult.failed("数据查询失败");
    }

    @ApiOperation("加V排行榜")
    @GetMapping(value = "/rank/bluev")
    public CommonResult<CommonPage<UmsIndustryRankVO>> blueVRank(@RequestParam(name = "industry",required = false) String industry,
                                                                 @RequestParam(name = "keyWord",required = false) String keyWord,
                                                                 @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                                                 @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum) throws ParseException {
        IPage<UmsIndustryRankVO> res = umsAdminStreamerService.blueVRank(keyWord,industry,pageNum,pageSize);
        if (res != null) {
            return CommonResult.success(CommonPage.restPage(res));
        }

        return CommonResult.failed("数据查询失败");
    }


    @ApiOperation("星图热榜")
    @GetMapping("/starChart")
    public CommonResult<CommonPage<UmsStarChartVo>> getStarChartRank(@RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                                                     @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        IPage<UmsStarChartVo> starChartRank = umsAdminStreamerService.getStarChartRank(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(starChartRank));
    }

    @ApiOperation("抖音号对比搜索")
    @GetMapping("/streamerCompare/search")
    public CommonResult<List<StreamerCompareSearchVo>> getStreamerCompareSearch(@RequestParam(name = "key") String key){
        List<StreamerCompareSearchVo> streamerCompareSearchVoList = umsAdminStreamerService.getStreamerCompareSearch(key);
        if(!streamerCompareSearchVoList.isEmpty()){
            return CommonResult.success(streamerCompareSearchVoList);
        }
        return CommonResult.failed("没有查到抖音号信息");
    }

    @ApiOperation("抖音号对比详细")
    @GetMapping("/streamerCompare/detail")
    public CommonResult<StreamerCompareDetailVo> getStreamerCompareDetail(@RequestParam(name = "id") Long id){
        StreamerCompareDetailVo streamerCompareDetailVo = umsAdminStreamerService.getStreamerCompareDetail(id);
        if(streamerCompareDetailVo !=null){
            return CommonResult.success(streamerCompareDetailVo);
        }
        return CommonResult.failed("没有查到抖音号信息");
    }

    @ApiOperation("MCN机构列表")
    @GetMapping("/MCN/list")
    public CommonResult<CommonPage<MCNListVo>> MCNList( MCNListParam mcnListParam,
                                                       @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                                                       @RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum){
        IPage<MCNListVo> iPage = umsAdminStreamerService.getMCNList(mcnListParam,pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(iPage));
    }

    @ApiOperation("MCN详细")
    @GetMapping("/MCN/detail")
    public CommonResult<MCNInfoVo> MCNDetail(@RequestParam(name = "id")Long MCNId){
        MCNInfoVo mcnInfoVo = umsAdminStreamerService.MCNDetail(MCNId);

        if(mcnInfoVo !=null){
            return CommonResult.success(mcnInfoVo);
        }
        return CommonResult.failed("没有查到MCN信息");
    }

    @ApiOperation("MCN详细-签约抖音号")
    @GetMapping("/MCN/sign")
    public CommonResult<List<MCNSignVo>> MCNSign(@RequestParam(name = "id")Long MCNId){
        List<MCNSignVo> mcnSignVoList = umsAdminStreamerService.MCNSign(MCNId);
        if(mcnSignVoList !=null){
            return CommonResult.success(mcnSignVoList);
        }
        return CommonResult.failed("没有签约信息");
    }


    /**
     * 获取用户信息
     *
     * @param principal 主要
     * @return {@link UmsAdmin}
     */
    public UmsAdmin getUserInfo(Principal principal) {

        String username = principal.getName();
        return umsAdminService.getAdminByUsername(username);
    }
}

