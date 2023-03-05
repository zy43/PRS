package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoViewersSexVo {
    @ApiModelProperty("男性比例")
    private Double maleProportion;

    @ApiModelProperty("女性比例")
    private Double femaleProportion;

    @ApiModelProperty("人数最多性别")
    private String sexMax;
}
