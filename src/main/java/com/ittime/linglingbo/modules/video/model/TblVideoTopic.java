package com.ittime.linglingbo.modules.video.model;

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
@TableName("tbl_video_topic")
@ApiModel(value = "TblVideoTopic对象", description = "")
public class TblVideoTopic extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long topicId;

    private String topicName;

    private Long participants;

    private Long playbackVolume;

    private Long topicComments;

    private Long topicShares;

    private Long topicDayPeople;

    private Integer trend;

    private String topicImageUrl;


}
