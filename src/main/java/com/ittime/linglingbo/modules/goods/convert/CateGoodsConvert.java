package com.ittime.linglingbo.modules.goods.convert;

import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.vo.CateGoodsListVo;
import org.mapstruct.Mapper;

/**
 * @author zhl129
 * @date 2022/10/24 20:56
 * @email 1293384775@qq.com
 */
@Mapper(componentModel = "spring")
public interface CateGoodsConvert {

    CateGoodsListVo toCateGoodsListVo(TblCategoryGoods categoryGoods);

}
