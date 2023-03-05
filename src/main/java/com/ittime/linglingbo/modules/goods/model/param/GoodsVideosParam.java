package com.ittime.linglingbo.modules.goods.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Josh-ZJUT
 * @date 2022/12/19 20:47
 * @email dujianghui537885@163.com
 */
@Data
public class GoodsVideosParam {
    @ApiModelProperty("发布时间左边界")
    private String releaseTimeFrom;
    @ApiModelProperty("发布时间右边界")
    private String releaseTimeTo;
}
