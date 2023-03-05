package com.ittime.linglingbo.modules.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;

import java.math.BigDecimal;

/**
 * <p>
 * 主播/品牌商提现表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblClientWithdrawCashService extends IService<TblClientWithdrawCash> {

    /**
     * 提现审核
     *
     * @param withdrawId    提现记录 id
     * @param pass          是否通过
     * @param adminId       审核人 admin_id
     * @return
     */
    boolean auditWithdraw(Long withdrawId, Boolean pass,Long adminId);
    boolean cutDown(Long roleId, Long clientId, BigDecimal withdrawAmount);
}
