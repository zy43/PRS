package com.ittime.linglingbo.modules.ums.controller;


import com.ittime.linglingbo.common.api.CommonPage;
import com.ittime.linglingbo.common.api.CommonResult;
import com.ittime.linglingbo.modules.client.service.UmsAdminOwnerService;
import com.ittime.linglingbo.modules.client.service.UmsAdminStreamerService;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;
import com.ittime.linglingbo.modules.ums.dto.UmsIncomeVO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawDTO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawRecordVO;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

/**
 * 帐户控制器
 *
 * @author 丁泽宇
 * @date 2022-11-21 14:43
 */
@RestController
@Api(tags = "UmsAccountController")
@Tag(name = "UmsAccountController", description = "账户中心")
@RequestMapping("/account")
public class UmsAccountController {

    @Autowired
    private UmsAdminStreamerService umsAdminStreamerService;

    @Autowired
    private UmsAdminOwnerService umsAdminOwnerService;

    @Autowired
    private UmsAdminService umsAdminService;

    /**
     * deposit 存钱 修改余额字段
     * income query 查询信息
     * withdrawRecord 提现 先用principal查询角色。根据不同角色修改不同的表
     */
    @ApiOperation(value = "品牌方缴纳保证金")
    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public CommonResult<Boolean> deposit(@RequestParam String amount, Principal principal) {
        if (principal == null) {
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        BigDecimal decimal_amount = new BigDecimal(amount);
        boolean success = umsAdminOwnerService.deposit(username, decimal_amount);

        if (success) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("保证金存储失败");
    }

    /**
     * 收入查询全查
     *
     * @return {@link CommonResult}
     */
    @ApiOperation(value = "收益/收入列表全部展示")
    @RequestMapping(value = "/income/listAll", method = RequestMethod.GET)
    public CommonResult<List<UmsIncomeVO>> incomeListAll() {
        return CommonResult.success(umsAdminOwnerService.incomeListAll());
    }

    /**
     * 收入分页查询
     *
     * @return {@link CommonResult}
     */
    @ApiOperation(value = "收益/收入列表分页展示")
    @RequestMapping(value = "/income/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsIncomeVO>> incomeList(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "ownerName", required = false) String ownerName) {
        List<UmsIncomeVO> list = umsAdminOwnerService.incomeList(pageSize, pageNum, ownerName);
        Long total = umsAdminOwnerService.incomeTotalCount(ownerName);
        return CommonResult.success(CommonPage.listPage(list,total,pageNum,pageSize));
    }


    /**
     * 品牌商提现记录
     *
     * @return {@link CommonResult}
     */
    @ApiOperation(value = "品牌商提现记录展示")
    @RequestMapping(value = "/withdrawRecord/owner", method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsWithdrawRecordVO>> withdrawRecordOwner(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "personName", required = false) String personName) {
        List<UmsWithdrawRecordVO> list = umsAdminOwnerService.withdrawRecordOwner(pageSize, pageNum,personName);
        Long total = umsAdminOwnerService.withdrawOwnerTotalCount(personName);
        return CommonResult.success(CommonPage.listPage(list,total,pageNum,pageSize));
    }

    /**
     * 播主提现记录
     *
     * @return {@link CommonResult}
     */
    @ApiOperation(value = "播主提现记录展示")
    @RequestMapping(value = "/withdrawRecord/streamer", method = RequestMethod.GET)
    public CommonResult<CommonPage<UmsWithdrawRecordVO>> withdrawRecordStreamer(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "personName", required = false) String personName) {
        List<UmsWithdrawRecordVO> list = umsAdminOwnerService.withdrawRecordStreamer(pageSize, pageNum,personName);
        Long total = umsAdminOwnerService.withdrawStreamerTotalCount(personName);
        return CommonResult.success(CommonPage.listPage(list,total,pageNum,pageSize));
    }

    /**
     * 发出提现申请
     */
    @ApiOperation(value = "发起提现申请")
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public CommonResult<Boolean> withdraw(@RequestBody TblClientWithdrawCash dto, Principal principal) {

        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(principal.getName());
        Long roleId = umsAdmin.getRoleId();
        Long clientId = umsAdmin.getClientId();

        int count = umsAdminOwnerService.withdraw(dto,clientId,roleId);

        if (count != 0) {
            return CommonResult.success(null);
        }
        return CommonResult.failed("提现失败");
    }
}
