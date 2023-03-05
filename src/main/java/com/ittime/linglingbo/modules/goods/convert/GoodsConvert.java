package com.ittime.linglingbo.modules.goods.convert;

import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.goods.model.param.GoodsParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsDetailVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsListVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author zhl129
 * @date 2022/10/25 20:33
 * @email 1293384775@qq.com
 */
@Mapper(componentModel = "spring")
public interface GoodsConvert {

    GoodsListVo toGoodsListVo(TblGoods tblGoods);

    GoodsDetailVo toGoodsDetailVo(TblGoods tblGoods);

    @Mapping(source = "goodsId", target = "id")
    TblGoods toEntity(GoodsParam goodsParam);
}
