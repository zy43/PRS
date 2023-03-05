package com.ittime.linglingbo.modules.streamer.model;

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
@TableName("tbl_streamer_type")
@ApiModel(value = "TblStreamerType对象", description = "")
public class TblStreamerType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("标签类型Id")
    private Long typeId;

    @ApiModelProperty("标签类别名称")
    private String type;

    @ApiModelProperty("标签")
    private String label;


}
