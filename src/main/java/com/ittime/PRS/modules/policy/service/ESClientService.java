package com.ittime.PRS.modules.policy.service;

import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyDetailVo;
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
     *
     * @param policyType
     * @param province
     * @return
     */
    List<PolicyVo> selectByType(String policyType, String province) throws IOException;

    /**
     * 该类型下政策筛选
     *
     * @param param
     * @param current
     * @param pageSize
     * @return
     */
    Map<String,Object> list(SelectParam param, int current, int pageSize) throws IOException;

    /**
     * 首页权重全局搜索
     *
     * @param keyWord
     * @param current
     * @param pageSize
     * @return
     */
    Map<String,Object> listAll(String keyWord, int current, int pageSize) throws IOException;

    /**
     * 查看详情
     * @param id
     * @return
     */
    PolicyDetailVo getById(Long id) throws IOException;

    SearchResponse getFilterList(String indexName) throws IOException;
}
