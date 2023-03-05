package com.ittime.linglingbo.modules.client.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.client.model.param.AddOwnerParam;
import com.ittime.linglingbo.modules.client.model.param.OwnerCertificateParam;
import com.ittime.linglingbo.modules.client.model.param.StreamerCertificateParam;
import com.ittime.linglingbo.modules.client.model.vo.OwnerListVO;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.client.service.UmsAdminOwnerService;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * 品牌商 前端控制器
 */

@RestController
@Api(tags = "OwnerController")
@Tag(name = "OwnerController", description = "客户管理-品牌商管理")
@RequestMapping("/client/owner")
public class OwnerController {

    @Autowired
    private UmsAdminOwnerService umsAdminOwnerService;

    @Autowired
    private UmsAdminService adminService;

    @GetMapping("/list")
    @ApiOperation("获取分页列表")
    @ResponseBody
    public CommonResult<CommonPage<OwnerListVO>> list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        IPage<OwnerListVO> ownerListVO = umsAdminOwnerService.list(pageSize,pageNum);
        return CommonResult.success(CommonPage.restPage(ownerListVO));
    }


    @GetMapping("/listAll")
    @ApiOperation("获取所有品牌商")
    public CommonResult<List<OwnerListVO>> list(){
        List<OwnerListVO> umsAdminOwnerListVO = umsAdminOwnerService.listAll();
        return CommonResult.success(umsAdminOwnerListVO);
    }


    @ApiOperation("添加品牌商")
    @PostMapping
    public CommonResult<String> create(AddOwnerParam param){
        boolean success = umsAdminOwnerService.addOwner(param);
        if(success){
            return CommonResult.success("添加成功");
        }else{
            return CommonResult.failed("添加失败");
        }
    }

    @ApiOperation("根据查询某个品牌商")
    @GetMapping("/{id}")
    public CommonResult<UmsAdminOwner> get(@PathVariable Long id){
        return CommonResult.success(umsAdminOwnerService.getById(id));
    }


    @ApiOperation("编辑某个品牌商的信息")
    @PutMapping
    public CommonResult<String> update(@RequestBody UmsAdminOwner umsAdminOwner){
        boolean success = umsAdminOwnerService.updateById(umsAdminOwner);
        if(success){
            return CommonResult.success("修改成功");
        }else{
            return CommonResult.failed("修改失败");
        }
    }

    @ApiOperation("根据id删除品牌商")
    @DeleteMapping("/{id}")
    public CommonResult<String> delete(@PathVariable Long id){
        boolean success = umsAdminOwnerService.removeById(id);
        if (success) {
            return CommonResult.success("删除成功！");
        }
        return CommonResult.failed("删除失败！");
    }

    @ApiOperation("提交实名认证")
    @PostMapping("/certification")
    public CommonResult<String> update(OwnerCertificateParam param, Principal principal){
        Long ownerId = adminService.getAdminByUsername(principal.getName()).getClientId();
        boolean success = umsAdminOwnerService.certificate(param, ownerId);
        if (success) {
            return CommonResult.success("提交实名认证成功！");
        }
        return CommonResult.failed("提交实名认证失败！");
    }




}
