package com.ittime.linglingbo.modules.video.model;

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
@TableName("tbl_video_viewers_age")
@ApiModel(value = "TblVideoViewersAge对象", description = "")
public class TblVideoViewersAge extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long videoId;

    private Double group617;

    private Double group1824;

    private Double group2530;

    private Double group3135;

    private Double group3640;

    private Double group41;

    private String ageMax;


}
