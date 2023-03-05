package com.ittime.linglingbo.modules.monitor.vo;

import com.ittime.linglingbo.modules.streamer.model.TblStreamerDaylog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

/**
 * @author zhl129
 * @date 2022/12/29 17:29
 * @email 1293384775@qq.com
 */
@Data
public class MyAccountVo {

    @ApiModelProperty("播主")
    private String streamerName;

    @ApiModelProperty("头像")
    private String imageUrl;

    @ApiModelProperty("今日")
    private TblStreamerDaylog today;

    @ApiModelProperty("昨天")
    private TblStreamerDaylog yesterday;
}
