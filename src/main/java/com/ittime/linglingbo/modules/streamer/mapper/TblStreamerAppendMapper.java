package com.ittime.linglingbo.modules.streamer.mapper;

import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface TblStreamerAppendMapper extends BaseMapper<TblStreamerAppend> {

    /**
     * 地区排名
     *
     * @param province 省
     * @param city     城市
     * @param offset   抵消
     * @param pageSize 页面大小
     * @param keyWord  关键字
     * @return {@link List}<{@link UmsIndustryRankVO}>
     */
    List<UmsIndustryRankVO> regionRank(String keyWord, String province, String city, Integer offset, Integer pageSize);

    /**
     * 地区数量
     *
     * @param province 省
     * @param city     城市
     * @param keyWord  关键字
     * @return {@link Long}
     */
    Long regionCount(String keyWord, String province, String city);
}
