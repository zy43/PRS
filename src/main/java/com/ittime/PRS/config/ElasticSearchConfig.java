package com.ittime.PRS.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Data
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticSearch.serviceAddr}")
    private String serviceAddr;

    @Value("${elasticSearch.servicePort}")
    private Integer servicePort;

    @Value("${elasticSearch.serviceProtocol}")
    private String serviceProtocol;

    // 注册 rest高级客户端 
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(serviceAddr,servicePort,serviceProtocol)
                )
        );
        return client;
    }
}