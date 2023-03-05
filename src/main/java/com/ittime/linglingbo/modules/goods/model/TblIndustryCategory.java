package com.ittime.linglingbo.modules.goods.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 行业分类表
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_industry_category")
@ApiModel(value = "TblIndustryCategory对象", description = "行业分类表")
public class TblIndustryCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    private Long id;

    @ApiModelProperty("行业分类名称")
    private String industryName;

    @ApiModelProperty("行业描述")
    private String industryDesc;

}
