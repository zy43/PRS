package com.ittime.PRS.modules.policy.service.impl;

import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.mapper.PolicyMapper;
import com.ittime.PRS.modules.policy.service.PolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {

}
