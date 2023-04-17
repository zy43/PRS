package com.ittime.PRS.modules.policy.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.PRS.common.entity.BaseEntity;
import com.ittime.PRS.modules.collection.mapper.CollectionMapper;
import com.ittime.PRS.modules.collection.model.Collection;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.mapper.PolicyMapper;
import com.ittime.PRS.modules.policy.model.PolicySimilarity;
import com.ittime.PRS.modules.policy.model.param.PolicyParam;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.CountVo;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.model.vo.ProvinceListVo;
import com.ittime.PRS.modules.policy.model.vo.SimilarityVo;
import com.ittime.PRS.modules.policy.service.PolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.lucene.search.TotalHits;
import org.checkerframework.checker.units.qual.A;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.Cardinality;
import org.elasticsearch.search.aggregations.metrics.CardinalityAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {


    @Autowired
    private PolicyMapper policyMapper;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private CollectionMapper collectionMapper;



    /**
     * 根据政策类型查找
     * @param policyType
     * @return
     */
    @Override
    public List<PolicyVo> selectByType(String policyType) {

//        // 分组统计
//        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
//        wrapper.select("province, count(province) as sum")
//                .groupBy("province");
//
//        // selectMaps方法会将查询结果封装为一个Map,Map的key为结果的列,value为值
//        List<Map<String, Object>> mapList = policyMapper.selectMaps(wrapper);
//        for (Map<String, Object> mp : mapList) {
//            System.out.println(mp);
//        }

        ArrayList<PolicyVo> list = new ArrayList<>();

        List<Policy> policies = policyMapper.selectList(new LambdaQueryWrapper<Policy>()
                .eq(Policy::getPolicyType, policyType)
                .isNotNull(Policy::getProvince)
                .orderByDesc(Policy::getUpdateDate)
                .last("limit 10"));

        policies.forEach(policy -> {
            PolicyVo policyVo = new PolicyVo();
            BeanUtils.copyProperties(policy, policyVo);
            list.add(policyVo);
        });

        return list;
    }

    /**
     * 该类型下政策筛选
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public IPage<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum) {
        Page<Policy> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<Policy> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StrUtil.isNotBlank(param.getPolicyType()),Policy::getPolicyType, param.getPolicyType())
                .eq(StrUtil.isNotBlank(param.getGrade()), Policy::getPolicyGrade, param.getGrade())
                .like(StrUtil.isNotBlank(param.getProvince()), Policy::getProvince, param.getProvince())
                .like(StrUtil.isNotBlank(param.getSource()), Policy::getPolicySource, param.getSource())
                .like(StrUtil.isNotBlank(param.getKeyWord()), Policy::getPolicyTitle, param.getKeyWord())
                .orderByDesc(Policy::getUpdateDate);

        //分页查询
        IPage<Policy> iPage = baseMapper.selectPage(page, wrapper);
        //转为Vo对象返回
        return iPage.convert(policy -> {
            PolicyVo policyVo = new PolicyVo();
            BeanUtils.copyProperties(policy, policyVo);
            return policyVo;
        });

    }

    /**
     * 各省政策数量
     * @return
     */
    @Override
    public List<ProvinceListVo> getProvinceList() {
        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
        wrapper.select("province, count(province) as sum")
                .groupBy("province");
        // selectMaps方法会将查询结果封装为一个Map,Map的key为结果的列,value为值
        List<Map<String, Object>> mapList = policyMapper.selectMaps(wrapper);
        ArrayList<ProvinceListVo> provinceListVos = new ArrayList<>();
        for (Map<String, Object> mp : mapList) {
            ProvinceListVo provinceListVo = new ProvinceListVo();
            // 根据键值拿到数据
            String province = String.valueOf(mp.get("province"));
            int sum = Integer.parseInt(String.valueOf(mp.get("sum")));
            // 注入
            provinceListVo.setProvince(province);
            provinceListVo.setSum(sum);
            provinceListVos.add(provinceListVo);
        }

        return provinceListVos;
    }

    @Override
    public CountVo getPolicyCount() throws IOException {
        CountVo countVo = new CountVo();

        Integer countryGradeCount = getCountryGradeCount();
        countVo.setCountryGradeCount(countryGradeCount);

        Integer allPolicyCount = getAllPolicyCount();
        countVo.setPolicyCount(allPolicyCount);

        Integer provinceGradeCount = getProvinceGradeCount();
        countVo.setProvinceGradeCount(provinceGradeCount);


        QueryWrapper<Policy> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT policy_type");
        Long policyTypeCount = baseMapper.selectCount(queryWrapper);
        countVo.setPolicyTypeCount(policyTypeCount.intValue());
        return countVo;
    }



    public Integer getCountryGradeCount() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("policy");
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 查询所有数据
        sourceBuilder.query(QueryBuilders.termQuery("policy_grade", "国家级"));
        //超过一万时 如果需要精确统计设置为true
        sourceBuilder.trackTotalHits(true);
        request.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        Long count = response.getHits().getTotalHits().value;
        Integer countryGradeCount = count.intValue();
        return countryGradeCount;
    }

    public Integer getAllPolicyCount() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("policy");
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 查询所有数据
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        //超过一万时 如果需要精确统计设置为true
        sourceBuilder.trackTotalHits(true);
        request.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        Long count = response.getHits().getTotalHits().value;
        Integer allPolicyCount = count.intValue();
        return allPolicyCount;
    }

    public Integer getProvinceGradeCount() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("policy");
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        boolQuery.must(QueryBuilders.existsQuery("province"));
        sourceBuilder.query(boolQuery);
        //超过一万时 如果需要精确统计设置为true
        sourceBuilder.trackTotalHits(true);
        request.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        Long count = response.getHits().getTotalHits().value;
        Integer provinceGradeCount = count.intValue();
        return provinceGradeCount;
    }


    @Override
    public List<SimilarityVo> getSimilarityPolicy(Long id) throws IOException {
        ArrayList<SimilarityVo> similarityVos = new ArrayList<>();
        LambdaQueryWrapper<Collection> collectionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        collectionLambdaQueryWrapper.eq(Collection::getUserId,id);
        collectionLambdaQueryWrapper.orderByDesc(BaseEntity::getCreateTime);
        List<Collection> collectionList = collectionMapper.selectList(collectionLambdaQueryWrapper);
        //用户没有收藏
        if(collectionList.isEmpty()){
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.setSeed(10000L);

            SearchRequest request = new SearchRequest();
            request.indices("policy");
            // 构建查询的请求体
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            // 查询所有数据
            sourceBuilder.query(QueryBuilders.matchAllQuery());
            int num = (int)(Math.random()*300);
            System.out.println(num);
            sourceBuilder.from(secureRandom.nextInt(num));
            sourceBuilder.size(20);
            request.source(sourceBuilder);
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            if (RestStatus.OK.equals(response.status())) {
                SearchHits hits = response.getHits();
                for (SearchHit hit : hits.getHits()) {
                    SimilarityVo similarityVo = new SimilarityVo();
                    Policy policy = JSON.parseObject(hit.getSourceAsString(), Policy.class); //文档内容
                    BeanUtils.copyProperties(policy,similarityVo);
                    similarityVos.add(similarityVo);
                }
            }
            return similarityVos;
        }
        //根据收藏推荐
        List<Long> policyIdList = collectionList.stream().map(collection -> collection.getPolicyId()).collect(Collectors.toList());
        for (int i = 0; i < policyIdList.size() && i<5; i++) {
            Long policyId = policyIdList.get(i);
            SearchRequest request = new SearchRequest();
            request.indices("policy_priority");
            // 构建查询的请求体
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            // 查询所有数据
            sourceBuilder.query(QueryBuilders.termQuery("policy1", policyId.toString()));
            //sourceBuilder.sort("similarity",SortOrder.DESC);

            request.source(sourceBuilder);
            SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            for (SearchHit hit : hits.getHits()) {
                SimilarityVo similarityVo = new SimilarityVo();
                PolicySimilarity policySimilarity = JSON.parseObject(hit.getSourceAsString(), PolicySimilarity.class);//文档内容

                LambdaQueryWrapper<Policy> lambdaQueryWrapper = new LambdaQueryWrapper<>();
                lambdaQueryWrapper.eq(Policy::getPolicyId,policySimilarity.getPolicy2());
                Policy policy = baseMapper.selectOne(lambdaQueryWrapper);
                BeanUtils.copyProperties(policy,similarityVo);
                similarityVos.add(similarityVo);
            }
        }

        return similarityVos;
    }
}
