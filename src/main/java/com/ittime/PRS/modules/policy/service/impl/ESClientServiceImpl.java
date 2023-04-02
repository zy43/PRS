package com.ittime.PRS.modules.policy.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.service.ESClientService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhl129
 * @date 2023/3/31 10:15
 * @email 1293384775@qq.com
 */

@Service
public class ESClientServiceImpl implements ESClientService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public SearchResponse getAll(String indexName) throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices(indexName);
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 查询所有数据
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        sourceBuilder.from(0);
        sourceBuilder.size(10000);
        sourceBuilder.sort("id", SortOrder.ASC);
        request.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        return response;
    }

    @Override
    public SearchResponse getTermList(String indexName, String key, String value) throws IOException {
        // 创建搜索请求对象
        SearchRequest request = new SearchRequest();
        request.indices(indexName);

        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 查询所有数据
        sourceBuilder.query(QueryBuilders.termQuery(key, value));
        sourceBuilder.from(0);
        sourceBuilder.size(10000);
        sourceBuilder.sort("id", SortOrder.ASC);
        request.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        restHighLevelClient.close();
        return response;
    }

    /**
     * 根据类型查找
     * @param policyType
     * @return
     */
    @Override
    public List<PolicyVo> selectByType(String policyType) throws IOException {
        ArrayList<PolicyVo> policyVos = new ArrayList<>();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //  termQuery只能匹配一个值，第一个入参为字段名称，第二个参数为传入的值，相当于sql中的=
        searchSourceBuilder.query(QueryBuilders.termQuery("policy_type.keyword", policyType));
        //构建查询请求对象，入参为索引
        SearchRequest searchRequest = new SearchRequest("policy");
        // searchSourceBuilder.query(QueryBuilders.existsQuery("province"));
        searchSourceBuilder.sort("update_date", SortOrder.DESC);
        //向搜索请求对象中配置搜索源
        searchRequest.source(searchSourceBuilder);
        // 执行搜索,向ES发起http请求
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        if (RestStatus.OK.equals(response.status())) {
            long total = response.getHits().getTotalHits().value; //检索到符合条件的总数
            SearchHit[] hits = response.getHits().getHits();
            //未指定size，默认查询的是10条
            for (SearchHit hit : hits) {
                String index = hit.getIndex();//索引名称
                String id = hit.getId(); //文档id
                Policy policy = JSON.parseObject(hit.getSourceAsString(), Policy.class); //文档内容
                System.out.println(policy.toString());
                PolicyVo policyVo = new PolicyVo();
                BeanUtils.copyProperties(policy, policyVo);
                policyVos.add(policyVo);
            }
            System.out.println(total);
        }
        restHighLevelClient.close();
        return policyVos;
    }

    /**
     * 该类型下政策筛选
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum) throws IOException {
        ArrayList<PolicyVo> policyVos = new ArrayList<>();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 高亮显示
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color:red'>");//前缀后缀
        highlightBuilder.postTags("</span>");
        // 布尔查询
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        // 定义高亮数组
        List<String> highlights = new ArrayList<>();
        builder.filter(QueryBuilders.termQuery("policy_type.keyword", param.getPolicyType()));
        if(StrUtil.isNotBlank(param.getGrade())){
            builder.filter(QueryBuilders.termQuery("policy_grade", param.getGrade()));
            highlightBuilder.field("policy_grade");
            highlights.add("policy_grade");
        }
        if(StrUtil.isNotBlank(param.getProvince())){
            builder.filter(QueryBuilders.termQuery("province", param.getProvince()));
            highlightBuilder.field("province");
            highlights.add("province");
        }
        if(StrUtil.isNotBlank(param.getSource())){
            builder.filter(QueryBuilders.matchQuery("policy_source", param.getSource()));
            highlightBuilder.field("policy_source");
            highlights.add("policy_source");
        }
        if(StrUtil.isNotBlank(param.getKeyWord())){
            builder.filter(QueryBuilders.matchQuery("policy_title", param.getKeyWord()));
            highlightBuilder.field("policy_title");
            highlights.add("policy_title");
        }
        searchSourceBuilder.query(builder).sort("update_date", SortOrder.DESC);

        highlightBuilder.requireFieldMatch(true);//是否搜索字段外的字段要高亮
        searchSourceBuilder.highlighter(highlightBuilder);
        //构建查询请求对象，入参为索引
        SearchRequest searchRequest = new SearchRequest("policy");
        //向搜索请求对象中配置搜索源
        searchRequest.source(searchSourceBuilder);
        // 执行搜索,向ES发起http请求
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        if (RestStatus.OK.equals(response.status())) {
            long total = response.getHits().getTotalHits().value; //检索到符合条件的总数
            SearchHit[] hits = response.getHits().getHits();
            //未指定size，默认查询的是10条
            for (SearchHit hit : hits) {
                //原来的结果
                Map<String, Object> sourceAsMap = hit.getSourceAsMap();
                //获取高亮字段
                Map<String, HighlightField> highlightFields = hit.getHighlightFields();
                System.out.println("=========="+highlightFields);
                // 遍历需要高亮的字段
                highlights.forEach(highlight->{
                    HighlightField content = highlightFields.get(highlight);
                    System.out.println("==content=="+content);
                    //将原来的字段替换为高亮字段即可
                    if (content!=null){
                        Text[] fragments = content.fragments();
                        String newTitle = "";
                        for (Text text : fragments) {
                            newTitle +=text;
                        }
                        sourceAsMap.put(highlight,newTitle);//替换掉原来的内容
                    }
                });
                Policy policy = JSON.parseObject(JSONArray.toJSONString(sourceAsMap), Policy.class); //文档内容
                // System.out.println(policy.toString());
                PolicyVo policyVo = new PolicyVo();
                BeanUtils.copyProperties(policy, policyVo);
                policyVos.add(policyVo);
            }
            System.out.println(total);
        }
        return policyVos;
    }

}
