package com.ittime.linglingbo.modules.video.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class VideoViewersAgeVo {
    @ApiModelProperty("6-17年龄段")
    private Double group617;

    @ApiModelProperty("18-24年龄段")
    private Double group1824;

    @ApiModelProperty("25-30年龄段")
    private Double group2530;

    @ApiModelProperty("31-35年龄段")
    private Double group3135;

    @ApiModelProperty("36-40年龄段")
    private Double group3640;

    @ApiModelProperty("41以上年龄段")
    private Double group41;

    @ApiModelProperty("人数最多年龄段")
    private String ageMax;
}
