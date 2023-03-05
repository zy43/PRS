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
@TableName("tbl_topic")
@ApiModel(value = "TblTopic对象", description = "")
public class TblTopic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String topic;

    private Long participation;

    private Long amountPlay;

    private String usingTrend;

    private String hotThree;

    private Long mostComments;

    private Long mostShared;


}
