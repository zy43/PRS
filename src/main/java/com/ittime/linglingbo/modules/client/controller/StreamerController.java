package com.ittime.linglingbo.modules.client.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.common.component.IdGenerator;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.client.model.param.StreamerCertificateParam;
import com.ittime.linglingbo.modules.client.model.param.StreamerSeachListParam;
import com.ittime.linglingbo.modules.client.model.vo.AccurateSearchListVO;
import com.ittime.linglingbo.modules.client.model.vo.StreamerListVO;
import com.ittime.linglingbo.modules.client.service.UmsAdminStreamerService;
import com.ittime.linglingbo.modules.minio.service.TblImageService;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.service.TblStreamerAppendService;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

/**
 * 主播 前端控制器
 */

@RestController
@Api(tags = "StreamerController")
@Tag(name = "StreamerController", description = "客户管理-主播管理")
@RequestMapping("/client/streamer")
public class StreamerController {

    @Autowired
    private UmsAdminStreamerService umsAdminStreamerService;

    @Autowired
    private UmsAdminService adminService;

    @Autowired
    private TblStreamerAppendService appendService;

    @Autowired
    private TblImageService tblImageService;


    @GetMapping("/list")
    @ApiOperation("获取分页列表")
    @ResponseBody
    public CommonResult<CommonPage<StreamerListVO>> list(
            @RequestParam(value = "industry", required = false) String industry,
            @RequestParam(value = "goodsCategory", required = false) String goodsCategory,
            @RequestParam(value = "hostName", required = false) String hostName,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        IPage<StreamerListVO> streamerListVO = umsAdminStreamerService.list(pageSize, pageNum, hostName, industry, goodsCategory);
        return CommonResult.success(CommonPage.restPage(streamerListVO));
    }

    @ApiOperation("添加主播")
    @PostMapping
    public CommonResult<String> create(UmsAdminStreamer umsAdminStreamer, MultipartFile multipartFile){
        Long imageId = IdGenerator.generateId();
        tblImageService.upload(multipartFile, imageId);
        umsAdminStreamer.setImageId(imageId);
        boolean success = umsAdminStreamerService.save(umsAdminStreamer);
        if(success){
            return CommonResult.success("添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("根据查询某个主播")
    @GetMapping("/{id}")
    public CommonResult<UmsAdminStreamer> get(@PathVariable Long id){
        return CommonResult.success(umsAdminStreamerService.getById(id));
    }


    @ApiOperation("编辑某个主播的信息")
    @PutMapping
    public CommonResult<String> update(@RequestBody UmsAdminStreamer umsAdminStreamer){
        boolean success = umsAdminStreamerService.updateById(umsAdminStreamer);
        if(success){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("根据id删除品牌商")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id){
        boolean success = umsAdminStreamerService.removeById(id);
        if (success) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed("删除失败！");
    }

    @ApiOperation("提交实名认证")
    @PostMapping("/certification")
    public CommonResult<String> update(StreamerCertificateParam param, Principal principal){
        Long streamerId = adminService.getAdminByUsername(principal.getName()).getClientId();
        boolean success = umsAdminStreamerService.certificate(param, streamerId);
        if (success) {
            return CommonResult.success("提交实名认证成功！");
        }
        return CommonResult.failed("提交实名认证失败！");
    }



    @ApiOperation("列表搜索主播")
    @PostMapping("/searchList")
    public CommonResult<List<AccurateSearchListVO>> searchList(@RequestBody StreamerSeachListParam param){
        List<AccurateSearchListVO> streamerVOList = appendService.accurateSearchList(param);
        return CommonResult.success(streamerVOList);
    }





}
