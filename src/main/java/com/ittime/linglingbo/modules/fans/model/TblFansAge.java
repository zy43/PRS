package com.ittime.linglingbo.modules.fans.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tbl_fans_age")
@ApiModel(value = "TblFansAge对象", description = "")
public class TblFansAge extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号")
    private Long id;

    @ApiModelProperty("抖音ID")
    private Long streamerId;

    private Double group617;

    @ApiModelProperty("粉丝年龄段")
    private Double group1824;

    @ApiModelProperty("占比")
    private Double group2530;

    private Double group3135;

    private Double group3640;

    private Double group41;


}
