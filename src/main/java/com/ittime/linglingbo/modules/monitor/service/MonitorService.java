package com.ittime.linglingbo.modules.monitor.service;

import com.ittime.linglingbo.modules.monitor.vo.AuthorizeVo;
import com.ittime.linglingbo.modules.monitor.vo.MyAccountVo;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;

import java.util.List;

/**
 * @author zhl129
 * @date 2022/12/29 17:27
 * @email 1293384775@qq.com
 */
public interface MonitorService {

    /**
     * 我的抖音号
     * @return
     */
    List<MyAccountVo> getMyAccount(UmsAdmin admin);

    /**
     * 添加授权信息
     * @param streamerId
     * @return
     */
    boolean authorize(Long streamerId);

    /**
     * 已授权列表
     * @param admin
     * @return
     */
    List<AuthorizeVo> authorizeList(UmsAdmin admin);
}
