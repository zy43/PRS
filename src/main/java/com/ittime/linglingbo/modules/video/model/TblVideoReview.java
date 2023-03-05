package com.ittime.linglingbo.modules.video.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
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
@TableName("tbl_video_review")
@ApiModel(value = "TblVideoReview对象", description = "")
public class TblVideoReview extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号（UUID自动生成）")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("评论用户头像 20200720 sanrenhe")
    private String commentUserImg;

    @ApiModelProperty("评论用户")
    private String commentUser;

    @ApiModelProperty("评论内容")
    private String content;

    @ApiModelProperty("被点赞数")
    private Long liked;

    @ApiModelProperty("评论分类")
    private Integer classification;

    @ApiModelProperty("价格相关")
    private Integer priceRelated;

    @ApiModelProperty("评论时间")
    private Date commentTime;

    private Integer influence;


}
