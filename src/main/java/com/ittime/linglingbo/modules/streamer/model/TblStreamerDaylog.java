package com.ittime.linglingbo.modules.streamer.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ittime.linglingbo.common.entity.BaseEntity;
import java.io.Serializable;
import java.util.Date;
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
@TableName("tbl_streamer_daylog")
@ApiModel(value = "TblStreamerDaylog对象", description = "")
public class TblStreamerDaylog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty("日期")
    private Date logDate;

    @ApiModelProperty("抖音id")
    private Long streamerId;

    private Long dayFans;

    private Long dayVideos;

    private Long dayLikes;

    private Long dayComments;

    private Long dayShares;


}
