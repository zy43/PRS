package com.ittime.linglingbo.modules.goods.model.param;

import lombok.Data;

@Data
public class PageQueryParam {

    Integer pageSize = 5;

    Integer pageNum = 1;

    String goodsName;

    Long categoryId;

    String brandName;

}

//    @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
//    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
//    @RequestParam(value = "cateGoodsName",required = false) String cateGoodsName,
//    @RequestParam(value = "brandName",required = false) String brandName
