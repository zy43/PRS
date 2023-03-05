package com.ittime.linglingbo.modules.workbench.vo.streamer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/12/3 14:31
 * @email 1293384775@qq.com
 */
@Data
public class StreamerAccountVo {

    @ApiModelProperty("主播id")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("电话")
    private String tel;

    @ApiModelProperty("认证状态")
    private String certification;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("账户收益")
    private BigDecimal accountIncome;

    @ApiModelProperty("账户结算")
    private BigDecimal accountSettle;
}
