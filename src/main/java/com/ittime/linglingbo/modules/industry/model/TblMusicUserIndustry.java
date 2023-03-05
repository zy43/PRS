package com.ittime.linglingbo.modules.industry.model;

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
@TableName("tbl_music_user_industry")
@ApiModel(value = "TblMusicUserIndustry对象", description = "")
public class TblMusicUserIndustry extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String musicName;

    private String industry;

    private Double heatDegree;

    @ApiModelProperty("音乐使用人数")
    private Long useNumber;

    private String userImageUrl;


}
