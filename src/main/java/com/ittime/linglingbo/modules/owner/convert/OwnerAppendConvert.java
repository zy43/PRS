package com.ittime.linglingbo.modules.owner.convert;

import com.ittime.linglingbo.modules.owner.model.TblOwnerAppend;
import com.ittime.linglingbo.modules.owner.model.vo.OwnerDetailVo;
import com.ittime.linglingbo.modules.owner.model.vo.OwnerQueryVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Josh-ZJUT
 * @date 2022/12/29 14:52
 * @email dujianghui537885@163.com
 */
@Mapper(componentModel = "spring")
public interface OwnerAppendConvert {

    OwnerDetailVo toOwnerDetailVo(TblOwnerAppend tblOwnerAppend);

    OwnerQueryVo toOwnerQueryVo(TblOwnerAppend tblOwnerAppend);
    List<OwnerQueryVo> toOwnerQueryVoList(List<TblOwnerAppend> tblOwnerAppendList);


}
