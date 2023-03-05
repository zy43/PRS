package com.ittime.linglingbo.modules.goods.convert;

import com.ittime.linglingbo.modules.goods.model.TblGoodsAppend;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsAppendVo;

import com.ittime.linglingbo.modules.goods.model.vo.GoodsRankVO;
import org.mapstruct.Mapper;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/22
 **/
@Mapper(componentModel = "spring")
public interface GoodsAppendConvert {

    GoodsAppendVo toGoodsAppendListVo(TblGoodsAppend goodsAppend);

    GoodsRankVO toGoodsRankVO(TblGoodsAppend goodsAppend);
}
