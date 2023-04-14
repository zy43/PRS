package com.ittime.PRS.modules.policy.service;

import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyDetailVo;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import org.elasticsearch.action.search.SearchResponse;

import java.io.IOException;
import java.util.List;

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
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum) throws IOException;

    /**
     * 首页权重全局搜索
     * @param keyWord
     * @return
     */
    List<PolicyVo> listAll(String keyWord) throws IOException;

    /**
     * 查看详情
     * @param id
     * @return
     */
    PolicyDetailVo getById(Long id) throws IOException;

    SearchResponse getFilterList(String indexName) throws IOException;
}
