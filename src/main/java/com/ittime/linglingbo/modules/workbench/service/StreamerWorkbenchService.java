package com.ittime.linglingbo.modules.workbench.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerSettleDataVo;

/**
 * @author zhl129
 * @date 2022/12/3 14:41
 * @email 1293384775@qq.com
 */
public interface StreamerWorkbenchService {

    /**
     * 获取用户账户信息
     * @param admin
     * @return
     */
    StreamerAccountVo getAccountInfo(UmsAdmin admin);

    /**
     * 任务动态数据
     * @return
     */
    StreamerDynamicDataVo getTaskDynamicData(UmsAdmin admin);

    /**
     * 任务结算数据
     * @param admin
     * @return
     */
    StreamerSettleDataVo getTaskSettleData(UmsAdmin admin);
}
