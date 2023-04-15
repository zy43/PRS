package com.ittime.PRS.modules.collection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.PRS.modules.collection.convert.CollectionConvert;
import com.ittime.PRS.modules.collection.model.Collection;
import com.ittime.PRS.modules.collection.mapper.CollectionMapper;
import com.ittime.PRS.modules.collection.model.vo.CollectionVo;
import com.ittime.PRS.modules.collection.service.CollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.PRS.modules.policy.mapper.PolicyMapper;
import com.ittime.PRS.modules.policy.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhl
 * @since 2023-04-04
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {

    @Autowired
    private PolicyMapper policyMapper;

    @Autowired
    private CollectionConvert collectionConvert;

    @Override
    public boolean addCollection(Long userId, Long policyId) {
        Collection collection = new Collection();
        collection.setPolicyId(policyId);
        collection.setUserId(userId);
        baseMapper.insert(collection);
        return true;
    }

    @Override
    public boolean deleteCollection(Long userId, Long policyId) {
        baseMapper.delete(new LambdaQueryWrapper<Collection>().eq(Collection::getUserId, userId)
                .eq(Collection::getPolicyId, policyId));
        return true;

    }

    @Override
    public IPage<CollectionVo> pageList(Long userId, Integer pageSize, Integer pageNum) {

        Page<Policy> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<Collection> collectionQueryWrapper = new LambdaQueryWrapper<>();
        collectionQueryWrapper.eq(Collection::getUserId,userId);
        List<Collection> collectionList = baseMapper.selectList(collectionQueryWrapper);
        List<Long> policyIds = collectionList.stream().map((collection) -> collection.getPolicyId()).collect(Collectors.toList());

        if(policyIds.isEmpty()) return null;

        LambdaQueryWrapper<Policy> policyQueryWrapper = new LambdaQueryWrapper<>();
        policyQueryWrapper.in(Policy::getPolicyId,policyIds);
        IPage<Policy> list = policyMapper.selectPage(page, policyQueryWrapper);

        return list.convert(
                (info) ->{
                    CollectionVo collectionVo = collectionConvert.toCollectionVo(info);
                    collectionVo.setUserId(userId);
                    return collectionVo;
                }
        );
    }
}
