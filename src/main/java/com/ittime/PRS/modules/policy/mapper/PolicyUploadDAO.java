package com.ittime.PRS.modules.policy.mapper;

import cn.hutool.core.util.StrUtil;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.model.excel.PolicyExcel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhl129
 * @date 2023/3/9 16:11
 * @email 1293384775@qq.com
 */
@Repository
public class PolicyUploadDAO {

    @Autowired
    private PolicyMapper policyMapper;

    @Transactional(rollbackFor = Exception.class)
    public void save(List<PolicyExcel> list) {
        for (PolicyExcel policyExcel : list) {
            Policy policy = new Policy()
                    .setPolicyId(policyExcel.getPolicyId())
                    .setPolicyBody(policyExcel.getPolicyBody())
                    .setPolicyGrade(policyExcel.getPolicyGrade())
                    .setPolicyType(policyExcel.getPolicyType())
                    .setPolicyTitle(policyExcel.getPolicyTitle())
                    .setPolicySource(policyExcel.getPolicySource())
                    .setCity(policyExcel.getCity())
                    .setProvince(policyExcel.getProvince())
                    .setPubAgency(policyExcel.getPubAgency())
                    .setPubAgencyFullname(policyExcel.getPubAgencyFullname())
                    .setPubAgencyId(policyExcel.getPubAgencyId())
                    .setPubNumber(policyExcel.getPubNumber())
                    .setPubTime(policyExcel.getPubTime())
                    .setUpdateDate(policyExcel.getUpdateDate());
            if(StrUtil.isNotBlank(policy.getPolicyBody())&&policy.getPolicyBody().length()>10000)
                policy.setPolicyBody(policy.getPolicyBody().substring(0,10000));
            if(StrUtil.isNotBlank(policy.getPolicyTitle())&&policy.getPolicyTitle().length()>10000)
                policy.setPolicyTitle(policy.getPolicyTitle().substring(0,10000));
            policyMapper.insert(policy);
        }
    }
}
