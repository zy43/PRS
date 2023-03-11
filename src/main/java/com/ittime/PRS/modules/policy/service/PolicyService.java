package com.ittime.PRS.modules.policy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.PRS.modules.policy.model.Policy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.PRS.modules.policy.model.param.PolicyParam;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.model.vo.ProvinceListVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
public interface PolicyService extends IService<Policy> {

    /**
     * 根据政策类型查找
     * @param policyType
     * @return
     */
    List<PolicyVo> selectByType(String policyType);

    /**
     * 该类型下政策筛选
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    IPage<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum);

    /**
     * 各省政策数量
     * @return
     */
    List<ProvinceListVo> getProvinceList();
}
