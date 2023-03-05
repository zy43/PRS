package com.ittime.linglingbo.modules.goods.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * @author zhl129
 * @date 2022/10/25 20:25
 * @email 1293384775@qq.com
 */

@Data
public class GoodsParam {

    @ApiModelProperty("主键(添加时不传这个参数)")
    private Long goodsId;

    @ApiModelProperty("商品名称")
    private String goodsName;

    @ApiModelProperty("商品数量")
    private Integer goodsNum;

    @ApiModelProperty("商品售价")
    private BigDecimal goodsPrice;

    @ApiModelProperty("图片id")
    private Long imageId;

    @ApiModelProperty("商品品牌")
    private String goodsBrand;

    @ApiModelProperty("商品所属分类")
    private Long categoryId;

    @ApiModelProperty("商品描述")
    private String goodsDesc;

    @ApiModelProperty("商品规格")
    private String goodsSpec;

    @ApiModelProperty("是否上架 1: 已上架 2: 已下架")
    private Integer isShelf;

    @ApiModelProperty("文件上传")
    private MultipartFile file;
}
