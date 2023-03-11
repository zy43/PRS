package com.ittime.PRS.modules.policy.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.common.api.CommonPage;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.policy.model.param.PolicyParam;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.model.vo.ProvinceListVo;
import com.ittime.PRS.modules.policy.service.PolicyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private PolicyService policyService;


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
}

