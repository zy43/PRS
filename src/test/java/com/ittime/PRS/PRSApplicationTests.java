package com.ittime.PRS;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.service.PolicyService;
import io.swagger.models.auth.In;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class PRSApplicationTests {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Autowired
    private PolicyService policyService;

    @Test
    void createIndex() throws IOException {
        CreateIndexRequest zhl = new CreateIndexRequest("zhl");
        CreateIndexResponse response = client.indices().create(zhl, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    @Test
    void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("zhl");
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }
    @Test
    void addDocument() throws IOException {
        Long id = 100000001L;
        Policy policy = policyService.getOne(new LambdaQueryWrapper<Policy>().eq(Policy::getPolicyId, id));
        IndexRequest request = new IndexRequest("129");
        request.id("1001");
        request.source(JSON.toJSONString(policy), XContentType.JSON);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        System.out.println(response.toString());

    }

}
