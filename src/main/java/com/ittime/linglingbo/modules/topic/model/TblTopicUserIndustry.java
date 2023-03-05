package com.ittime.linglingbo.modules.topic.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
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
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_topic_user_industry")
@ApiModel(value = "TblTopicUserIndustry对象", description = "")
public class TblTopicUserIndustry extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String topicName;

    private String industry;

    private Double proportion;


}
