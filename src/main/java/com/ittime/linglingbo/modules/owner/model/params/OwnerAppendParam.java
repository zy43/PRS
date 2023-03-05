package com.ittime.linglingbo.modules.owner.model.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Josh-ZJUT
 * @date 2022/12/29 14:27
 * @email dujianghui537885@163.com
 */
@Data
public class OwnerAppendParam {

    @ApiModelProperty("品牌分类")
    private String industry;

    @ApiModelProperty("商品来源")
    private String comeFrom;

    @ApiModelProperty("品牌商名称")
    private String ownerName;

    @ApiModelProperty("近几天")
    private Integer recentlyDay;

}
