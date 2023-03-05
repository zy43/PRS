package com.ittime.linglingbo.modules.task.convert;

import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.param.TaskGoodsParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Josh-ZJUT
 * @date 2022/10/21 13:45
 * @email dujianghui537885@163.com
 */
@Mapper(componentModel = "spring")
public interface TaskGoodsConvert {

    TblTaskGoods toEntity(TaskGoodsParam taskGoodsUpdateParam);

    @Mapping(source = "id", target = "goodsId")
    TblTaskGoods toEntity(TblGoods tblGoods);
}
