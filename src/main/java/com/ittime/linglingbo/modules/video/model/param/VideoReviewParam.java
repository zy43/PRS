package com.ittime.linglingbo.modules.video.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoReviewParam {
    @ApiModelProperty("视频ID")
    private Long videoId;

    @ApiModelProperty("评论分类：0：差评；1：中评；2：好评")
    private Integer classification;

    @ApiModelProperty("价格相关：0：贵；1：中等；2：便宜")
    private Integer priceRelated;
}
