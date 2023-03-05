package com.ittime.linglingbo.modules.workbench.vo.streamer;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhl129
 * @date 2022/12/9 16:15
 * @email 1293384775@qq.com
 */
@Data
public class StreamerDynamicDataVo {

    //品牌商总量
    @ApiModelProperty("用户名")
    private Integer ownerCount;

    //品牌总量
    private Integer brandCount;

    //商品总量
    private Integer goodsCount;

    //商品销量
    private Integer saleCount;

    //任务总量
    private Long taskCount;

    //承接任务量：为现存履约中任务量
    private Integer undertakenTaskCount;

    //结算任务量：为累计成功完成任务量
    private Integer settleTaskCount;

    //问题任务量：为现存审核失败+结算失败的任务量
    private Integer problemTaskCount;
}
