package com.ittime.linglingbo.modules.fans.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("tbl_fans_region")
@ApiModel(value = "TblFansRegion对象", description = "")
public class TblFansRegion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("抖音ID")
    private Long streamerId;

    @ApiModelProperty("粉丝地域")
    private String fansProvince;

    private String fansCity;

    @ApiModelProperty("占比")
    private Double proportion;


}
