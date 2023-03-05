package com.ittime.linglingbo.modules.goods.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Data
public class GoodsAppendSearchParam {
    @ApiModelProperty("关键词")
    private String keyword;
}
