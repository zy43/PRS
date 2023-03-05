package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoViewersRegionVo {
    @ApiModelProperty("省份")
    private String viewersProvince;

    @ApiModelProperty("城市")
    private String viewersCity;

    @ApiModelProperty("比例")
    private Double proportion;

    @ApiModelProperty("人数最多城市")
    private String cityMax;

    @ApiModelProperty("人数最多省份")
    private String provinceMax;
}
