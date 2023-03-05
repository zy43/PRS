package com.ittime.linglingbo.modules.video.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.video.model.param.VideoSearchParam;
import com.ittime.linglingbo.modules.video.model.vo.HotVideoVO;
import com.ittime.linglingbo.modules.video.model.vo.VideoInfoVo;
import com.ittime.linglingbo.modules.video.model.vo.VideoRankVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblVideoInfoService extends IService<TblVideoInfo> {

    /**
     * 收藏视频关键词搜索
     *
     * @param pageSize
     * @param pageNum
     * @param param
     * @param userId
     * @return
     */
    IPage<VideoInfoVo> list(Integer pageSize, Integer pageNum, VideoSearchParam param, Long userId);


    /**
     * 热门视频分页查找
     */
    IPage<HotVideoVO> searchList(Integer pageSize, Integer pageNum);


    /**
     * 电商视频排行
     */
    IPage<VideoRankVO> videoBrandRank(Integer pageSize, Integer pageNum);


    IPage<VideoRankVO> videoIndustryRank(Integer pageSize, Integer pageNum);

    IPage<VideoRankVO> hotVideoRank(Integer pageSize, Integer pageNum);
}
