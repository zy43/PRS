package com.ittime.linglingbo.modules.ums.dto;

import com.ittime.linglingbo.modules.fans.model.TblFansAge;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: dzy
 * @date: 2022/12/18 22:18
 * @email: 3323939959@qq.com
 */
@Data
public class UmsFansFeatureVO {

    @ApiModelProperty(value = "男性性别分布")
    private Double maleProportion;

    @ApiModelProperty(value = "地域分布")
    private List<UmsFansRegion> regionDistribution;

    @ApiModelProperty(value = "年龄分布")
    private TblFansAge ageDistribution;

    @ApiModelProperty(value = "爱好分布")
    private List<UmsFansHobbyVO> hobbyDistribution;

    @ApiModelProperty(value = "活跃时间分布")
    private List<UmsFansActiveTime> timeDistribution;
}
