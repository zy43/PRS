package com.ittime.linglingbo.modules.streamer.model.param;

import com.ittime.linglingbo.modules.streamer.model.vo.StreamerAppendVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Data
public class StreamerSearchParam {
    @ApiModelProperty("关键词")
    private String keyword;
}
