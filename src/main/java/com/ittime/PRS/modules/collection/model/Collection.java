package com.ittime.PRS.modules.collection.model;

import com.ittime.PRS.common.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhl
 * @since 2023-04-04
 */
@Getter
@Setter
@Accessors(chain = true)
@ApiModel(value = "Collection对象", description = "")
public class Collection extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("政策id")
    private Long policyId;


}
