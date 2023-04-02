package com.ittime.PRS.modules.policy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zhl129
 * @date 2023/3/31 10:14
 * @email 1293384775@qq.com
 */
public interface ESClientService {

    SearchResponse getAll(String indexName ) throws IOException;

    SearchResponse getTermList(String indexName, String key, String value) throws IOException;

    /**
     * 根据类型查找
     * @param policyType
     * @return
     */
    List<PolicyVo> selectByType(String policyType) throws IOException;

    /**
     * 该类型下政策筛选
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum) throws IOException;
}
