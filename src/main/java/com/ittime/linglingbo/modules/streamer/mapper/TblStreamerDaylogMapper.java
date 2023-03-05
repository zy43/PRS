package com.ittime.linglingbo.modules.streamer.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerDaylog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittime.linglingbo.modules.ums.dto.UmsFansRiseRankVO;
import com.ittime.linglingbo.modules.ums.dto.UmsIndustryRankVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblStreamerDaylogMapper extends BaseMapper<TblStreamerDaylog> {

    List<UmsFansRiseRankVO> fansRiseRank(String keyWord,String fromDay,String endDay, String industry, Integer offset, Integer pageSize);

    Long totalCount(String keyWord, String fromDay, String endDay, String industry);

}
