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
@TableName("tbl_video_topic_map")
@ApiModel(value = "TblVideoTopicMap对象", description = "")
public class TblVideoTopicMap extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号")
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("话题")
    private String topicName;


}
