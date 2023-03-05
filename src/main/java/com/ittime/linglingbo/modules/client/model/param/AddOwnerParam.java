package com.ittime.linglingbo.modules.client.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddOwnerParam {

    @ApiModelProperty("品牌商/政府机构名称")
    private String ownerName;

    @ApiModelProperty("所属企业名称")
    private String companyName;

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("商品分类")
    private Long[] goodsCategoryIds;

    @ApiModelProperty("品牌商描述")
    private String ownerDesc;

}
