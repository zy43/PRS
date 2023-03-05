package com.ittime.linglingbo.modules.ums.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 组织机构表
 *
 * @author zhl129
 * @date 2022/10/16 10:11
 * @email 1293384775@qq.com
 */
@Getter
@Setter
@TableName("ums_department")
@ApiModel(value = "UmsDepartment对象", description = "组织机构表")
public class UmsDepartment extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("组织机构名称")
    private String companyName;

}
