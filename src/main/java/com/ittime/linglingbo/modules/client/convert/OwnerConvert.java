package com.ittime.linglingbo.modules.client.convert;

import com.ittime.linglingbo.modules.client.model.vo.OwnerListVO;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import org.mapstruct.Mapper;

/**
 * 类型转换
 */
@Mapper(componentModel = "spring")
public interface OwnerConvert {

    OwnerListVO toOwnerListVO(UmsAdminOwner umsAdminOwner);


}
