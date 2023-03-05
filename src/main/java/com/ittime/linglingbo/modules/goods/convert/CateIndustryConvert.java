package com.ittime.linglingbo.modules.goods.convert;

import com.ittime.linglingbo.modules.goods.model.TblIndustryCategory;
import com.ittime.linglingbo.modules.goods.model.vo.CateIndustryListVo;
import org.mapstruct.Mapper;

/**
 * @author zhl129
 * @date 2022/10/25 9:41
 * @email 1293384775@qq.com
 */
@Mapper(componentModel = "spring")
public interface CateIndustryConvert {

    CateIndustryListVo toCateIndustryListVo(TblIndustryCategory industryCategory);
}
