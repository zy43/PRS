package com.ittime.linglingbo.modules.workbench.service;

import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerSettleDataVo;

/**
 * @author zhl129
 * @date 2022/12/3 14:42
 * @email 1293384775@qq.com
 */
public interface OwnerWorkbenchService {
    /**
     *账户信息
     * @param admin
     * @return
     */
    OwnerAccountVo getAccountInfo(UmsAdmin admin);

    /**
     *投放数据动态
     * @param admin
     * @return
     */
    OwnerDynamicDataVo getTaskDynamicData(UmsAdmin admin);

    /**
     * 投放结算动态
     * @param admin
     * @return
     */
    OwnerSettleDataVo getTaskSettleData(UmsAdmin admin);
}
