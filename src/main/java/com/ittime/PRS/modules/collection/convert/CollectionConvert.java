package com.ittime.PRS.modules.collection.convert;

import com.ittime.PRS.modules.collection.model.vo.CollectionVo;
import com.ittime.PRS.modules.policy.model.Policy;
import org.mapstruct.Mapper;

/**
 * @author zhl129
 * @date 2023/4/4 19:11
 * @email 1293384775@qq.com
 */
@Mapper(componentModel = "spring")
public interface CollectionConvert {

    CollectionVo toCollectionVo(Policy policy);
}
