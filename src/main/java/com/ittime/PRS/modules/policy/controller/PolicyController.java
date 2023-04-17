package com.ittime.PRS.modules.policy.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.common.api.CommonPage;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.model.param.PolicyParam;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.CountVo;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.model.vo.ProvinceListVo;
import com.ittime.PRS.modules.policy.model.vo.SimilarityVo;
import com.ittime.PRS.modules.policy.service.PolicyService;
import com.ittime.PRS.modules.ums.model.UmsAdmin;
import com.ittime.PRS.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
@RestController
@Api(tags = "PolicyController")
@Tag(name = "PolicyController", description = "政策controller")
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @Autowired
    private UmsAdminService umsAdminService;


    @ApiOperation("首页根据类型查找")
    @PostMapping("/listByType")
    public CommonResult<List<PolicyVo>> selectByType(@RequestBody PolicyParam param) {

        List<PolicyVo> policyVos = policyService.selectByType(param.getPolicyType());
        return CommonResult.success(policyVos);
    }

    @ApiOperation("该类型下政策筛选")
    @PostMapping("/selectList")
    public CommonResult<CommonPage<PolicyVo>> list(@RequestBody SelectParam param,
                                                   @RequestParam(value = "pageSize", defaultValue = "30") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        IPage<PolicyVo> page = policyService.list(param, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(page));

    }

    @ApiOperation("地图各省政策数量")
    @PostMapping("/getProvinceList")
    public CommonResult<List<ProvinceListVo>> list() {

        List<ProvinceListVo> provinceList = policyService.getProvinceList();
        return CommonResult.success(provinceList);
    }

    @ApiOperation("4种政策数据统计信息")
    @PostMapping("/getPolicyCount")
    public CommonResult<CountVo> getPolicyCount() throws IOException {

        CountVo countVo = policyService.getPolicyCount();
        return CommonResult.success(countVo);
    }

    @ApiOperation("首页根据用户收藏推荐")
    @PostMapping("/getSimilarityPolicy")
    public CommonResult<List<SimilarityVo>> getSimilarityPolicy(Principal principal) throws IOException {
        Long id = 0L;
        if(principal != null) {
            id = umsAdminService.getAdminByUsername(principal.getName()).getId();
        }
        List<SimilarityVo> similarityVos = policyService.getSimilarityPolicy(id);
        return CommonResult.success(similarityVos);
    }

    @ApiOperation("政策添加")
    @PostMapping("/add")
    public CommonResult<String> add(@RequestBody Policy policy){
        boolean flag = policyService.save(policy);
        if(flag) return CommonResult.success("添加成功");
        else return CommonResult.failed("添加失败");
    }

    @ApiOperation("政策删除")
    @PostMapping("/delete/{id}")
    public CommonResult<String> delete(@PathVariable Long id){
        boolean flag = policyService.removeById(id);
        if(flag) return CommonResult.success("删除成功");
        else return CommonResult.failed("删除失败");
    }

    @ApiOperation("政策修改")
    @PostMapping("/update")
    public CommonResult<String> update(@RequestBody Policy policy){
        boolean flag = policyService.updateById(policy);
        if(flag) return CommonResult.success("修改成功");
        else return CommonResult.failed("修改失败");
    }
}

