package com.ittime.linglingbo.modules.video.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoAudienceParam {
    @ApiModelProperty("视频ID")
    private Long videoId;
}
