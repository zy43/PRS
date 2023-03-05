package com.ittime.linglingbo.modules.fans.mapper;

import com.ittime.linglingbo.modules.fans.model.TblFansAge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblFansAgeMapper extends BaseMapper<TblFansAge> {

    TblFansAge selectAge(Long id);
}
