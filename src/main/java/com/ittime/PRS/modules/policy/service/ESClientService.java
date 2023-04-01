package com.ittime.PRS.modules.policy.service;

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
}
