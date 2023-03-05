package com.ittime.linglingbo.modules.client.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class StreamerSeachListParam {

    /*热搜关键词是什么*/

    @ApiModelProperty("所属行业")
    private String industry;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("点赞数")
    private Long totalLikes;

    @ApiModelProperty("评论数")
    private Long totalComments;

    @ApiModelProperty("视频数量")
    private Long totalVideos;

    /**市 主播性别年龄缺少**/

    @ApiModelProperty("账号类型")
    private Integer accountType;

    @ApiModelProperty("粉丝年龄")
    private Integer portraitAge;

    @ApiModelProperty("粉丝性别")
    private Integer portraitSex;

}
