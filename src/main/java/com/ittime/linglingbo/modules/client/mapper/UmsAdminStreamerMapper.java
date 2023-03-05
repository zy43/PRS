package com.ittime.linglingbo.modules.client.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;

import java.math.BigDecimal;

/**
 * 播主/MCN 表 Mapper 接口
 *
 * @author Josh
 * @since 2022-09-28
 */
public interface UmsAdminStreamerMapper extends MPJBaseMapper<UmsAdminStreamer> {


    boolean cutDown(Long clientId, BigDecimal withdrawAmount);

    BigDecimal getAccountBalance(Long clientId);

    Long getImageId(Long streamerId);
}
