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
@TableName("tbl_fans_hobby")
@ApiModel(value = "TblFansHobby对象", description = "")
public class TblFansHobby extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("唯一编号")
    private Long id;

    @ApiModelProperty("抖音ID")
    private Long streamerId;

    @ApiModelProperty("播主名称")
    private String nickName;

    @ApiModelProperty("粉丝兴趣")
    private String fansHobby;

    @ApiModelProperty("占比")
    private Double proportion;


}
