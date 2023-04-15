package com.ittime.PRS.modules.collection.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.PRS.modules.collection.model.Collection;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.PRS.modules.collection.model.vo.CollectionVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhl
 * @since 2023-04-04
 */
public interface CollectionService extends IService<Collection> {

    boolean addCollection(Long id, Long policyId);

    boolean deleteCollection(Long id, Long policyId);

    IPage<CollectionVo> pageList(Long id, Integer pageSize, Integer pageNum);
}
