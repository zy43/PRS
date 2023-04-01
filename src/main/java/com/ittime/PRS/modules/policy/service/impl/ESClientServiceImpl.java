package com.ittime.PRS.modules.policy.service.impl;

import com.ittime.PRS.modules.policy.service.ESClientService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
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
        return response;
    }

}
