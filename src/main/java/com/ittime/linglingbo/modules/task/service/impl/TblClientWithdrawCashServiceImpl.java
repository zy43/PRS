package com.ittime.linglingbo.modules.task.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.common.constant.RoleEnum;
import com.ittime.linglingbo.common.constant.WithdrawStatusEnum;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminOwnerMapper;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.task.mapper.TblClientWithdrawCashMapper;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;
import com.ittime.linglingbo.modules.task.service.TblClientWithdrawCashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * <p>
 * 主播/品牌商提现表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblClientWithdrawCashServiceImpl extends ServiceImpl<TblClientWithdrawCashMapper, TblClientWithdrawCash> implements TblClientWithdrawCashService {

    @Autowired
    private UmsAdminOwnerMapper umsAdminOwnerMapper;

    @Autowired
    private UmsAdminStreamerMapper umsAdminStreamerMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cutDown(Long roleId, Long clientId, BigDecimal withdrawAmount) {

        boolean res = false;

        // 先校验，余额小于提现额直接返回false
        if (roleId.equals(RoleEnum.OWNER.getValue())) {

            BigDecimal accountBalance = umsAdminOwnerMapper.getAccountBalance(clientId);
            if (accountBalance.compareTo(withdrawAmount) >= 0) {
                res = umsAdminOwnerMapper.cutDown(clientId, withdrawAmount);
            } else {
                return false;
            }
        } else if (roleId.equals(RoleEnum.STREAMER.getValue())) {

            BigDecimal accountBalance = umsAdminStreamerMapper.getAccountBalance(clientId);
            if (accountBalance.compareTo(withdrawAmount) >= 0) {
                res = umsAdminStreamerMapper.cutDown(clientId, withdrawAmount);
            } else {
                return false;
            }
        }

        return res;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean auditWithdraw(Long withdrawId, Boolean pass, Long adminId) {
        TblClientWithdrawCash withdrawCash = baseMapper.selectById(withdrawId);
        if (pass == null || withdrawCash == null) {
            return false;
        }
        boolean success = false;
        if (pass) {
            // 提现操作
            try {
                final Long clientId = withdrawCash.getClientId();
                final Long roleId = withdrawCash.getRoleId();
                final BigDecimal withdrawAmount = withdrawCash.getWithdrawAmount();
                success = cutDown(roleId, clientId, withdrawAmount);

            } catch (Exception e) {
                // WS=3
                withdrawCash.setWithdrawStatus(WithdrawStatusEnum.FAIL.getValue());
                throw e;
            }
            // WS=2
            withdrawCash.setWithdrawStatus(WithdrawStatusEnum.DONE.getValue());
        } else {
            // 拒绝提现
            // WS=3
            withdrawCash.setWithdrawStatus(WithdrawStatusEnum.FAIL.getValue());
        }
        return success && updateById(withdrawCash);
    }
}
