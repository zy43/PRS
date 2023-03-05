package com.ittime.linglingbo.modules.favorite.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description：添加收藏dto
 * @Author zy-zjut
 * @Date 2022/12/29
 **/
@Data
public class AddFavoritesParam {

    @ApiModelProperty("收藏类型")
    private Integer addType;

    @ApiModelProperty("播主or商品or视频ID")
    private Long xxId;
}
