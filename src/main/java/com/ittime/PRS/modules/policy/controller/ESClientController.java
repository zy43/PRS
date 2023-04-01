package com.ittime.PRS.modules.policy.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ittime.PRS.common.api.CommonResult;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.model.vo.ESIndexVo;
import com.ittime.PRS.modules.policy.service.ESClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.checkerframework.checker.units.qual.C;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhl129
 * @date 2023/3/24 15:03
 * @email 1293384775@qq.com
 */
@RestController
@Api(tags = "ESClientController")
@Tag(name = "ESClientController", description = "ESClient")
@RequestMapping("/es")
public class ESClientController {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private ESClientService esClientService;



    @ApiOperation("查询所有索引数据")
    @GetMapping("/getAll")
    public CommonResult<List<Map<String, Object>>> getAllPolicy(String indexName) throws IOException {

        SearchResponse response = esClientService.getAll(indexName);
        SearchHits hits = response.getHits();
        List<Map<String, Object>> result = Arrays.stream(hits.getHits()).map(SearchHit::getSourceAsMap).collect(Collectors.toList());
        return CommonResult.success(result,"took: " + response.getTook()+"total: " + hits.getTotalHits());
    }

    @ApiOperation("term查询，查询条件为关键字")
    @GetMapping("/getTermList")
    public CommonResult<List<Map<String, Object>>> getTermList(String indexName,String key,String value) throws IOException {

        SearchResponse response = esClientService.getTermList(indexName,key,value);
        SearchHits hits = response.getHits();
        List<Map<String, Object>> result = Arrays.stream(hits.getHits()).map(SearchHit::getSourceAsMap).collect(Collectors.toList());
        return CommonResult.success(result,"took: " + response.getTook()+"total: " + hits.getTotalHits());
    }

    @ApiOperation("分页查询")
    @GetMapping("/getPageList")
    public CommonResult<List<Map<String, Object>>> getPageList(String indexName,String key,String value) throws IOException {

        SearchResponse response = esClientService.getTermList(indexName,key,value);
        SearchHits hits = response.getHits();
        List<Map<String, Object>> result = Arrays.stream(hits.getHits()).map(SearchHit::getSourceAsMap).collect(Collectors.toList());
        return CommonResult.success(result,"took: " + response.getTook()+"total: " + hits.getTotalHits());
    }





    //-------------------index---------------------
    @ApiOperation("索引创建")
    @PostMapping("/index")
    public CommonResult<String> createIndex(String indexName) throws IOException {
        // 创建索引 - 请求对象
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        // 发送请求，获取响应
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        // 响应状态
        return CommonResult.success("操作状态 = " + acknowledged);
    }

    @ApiOperation("索引查询")
    @GetMapping("/index")
    public CommonResult<ESIndexVo> getIndex(String indexName) throws IOException {
        // 查询索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest(indexName);
        // 发送请求，获取响应
        GetIndexResponse response = restHighLevelClient.indices().get(request, RequestOptions.DEFAULT);
        ESIndexVo esIndexVo = new ESIndexVo();
        esIndexVo.setAliases(response.getAliases());
        esIndexVo.setMappings(response.getMappings());
        esIndexVo.setSettings(response.getSettings());
        return CommonResult.success(esIndexVo);
    }

    @ApiOperation("索引删除")
    @DeleteMapping("/index")
    public CommonResult<String> deleteIndex(String indexName) throws IOException {
        // 删除索引 - 请求对象
        DeleteIndexRequest request = new DeleteIndexRequest(indexName);
        // 发送请求，获取响应
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        // 操作结果
        return CommonResult.success("操作结果: " + response.isAcknowledged());
    }


    //-------------------doc---------------------
    @ApiOperation("创建文档")
    @PostMapping("/doc")
    public CommonResult<String> createDoc(@RequestBody Policy policy,String indexName) throws IOException {
        // 新增文档 - 请求对象
        IndexRequest request = new IndexRequest();
        // 设置索引及唯一性标识
        request.index(indexName).id(policy.getPolicyId().toString());
        ObjectMapper objectMapper = new ObjectMapper();
        String policyJson = JSON.toJSONString(policy);
        // 添加文档数据, 数据格式为Json格式
        request.source(policyJson, XContentType.JSON);
        // 客户端发送请求，获取响应对象
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        return CommonResult.success("_index: " + response.getIndex()+"  id: " + response.getId()+"  _result: " + response.getResult());
    }

    @ApiOperation("修改文档")
    @PutMapping("/doc")
    public CommonResult<String> updateDoc(@RequestBody Policy policy,String indexName) throws IOException {
        // 修改文档 - 请求对象
        UpdateRequest request = new UpdateRequest();
        // 配置修改参数
        request.index(indexName).id(policy.getPolicyId().toString());
        // 设置请求体，对数据进行修改
        request.doc(XContentType.JSON, "policyName", "政策");
        // 客户端发送请求，获取响应对象
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        return CommonResult.success("_index: " + response.getIndex()+"  id: " + response.getId()+"  _result: " + response.getResult());
    }

    @ApiOperation("查询文档")
    @GetMapping("/doc")
    public CommonResult<String> getDoc(@RequestBody Policy policy,String indexName) throws IOException {
        // 创建请求对象
        GetRequest request = new GetRequest().index(indexName).id(policy.getPolicyId().toString());
        // 客户端发送请求，获取响应对象
        GetResponse response = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        // 打印结果信息
        return CommonResult.success("_index: " + response.getIndex()+"_type: " + response.getType()+"_id: " + response.getId()+"source: " + response.getSourceAsString());
    }

    @ApiOperation("删除文档")
    @DeleteMapping("/doc")
    public CommonResult<String> deleteDoc(@RequestBody Policy policy,String indexName) throws IOException {
        // 创建请求对象
        DeleteRequest request = new DeleteRequest().index(indexName).id(policy.getPolicyId().toString());
        // 客户端发送请求，获取响应对象
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        return CommonResult.success(response.toString());
    }


}
