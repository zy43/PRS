package com.ittime.linglingbo.modules.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittime.linglingbo.modules.goods.model.TblGoodsRelateVideo;
import com.ittime.linglingbo.modules.ums.dto.UmsGoodsVO;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblGoodsRelateVideoMapper extends BaseMapper<TblGoodsRelateVideo> {

    /**
     * 获取货物视频信息
     *
     * @param streamerId 拖缆id
     * @param fromDay    从天
     * @param offset     抵消
     * @param pageSize   页面大小
     * @param keyWord    关键字
     * @return {@link List}<{@link UmsGoodsVO}>
     */
    List<UmsGoodsVO> getGoodsVideoInfo(Long streamerId, String fromDay, String keyWord, Integer offset, Integer pageSize);

    /**
     * 获取货物视频数量
     *
     * @param streamerId id
     * @param fromDay    从天
     * @param keyWord    关键字
     * @return {@link Long}
     */
    Long getGoodsVideoCount(Long streamerId, String fromDay, String keyWord);
}
