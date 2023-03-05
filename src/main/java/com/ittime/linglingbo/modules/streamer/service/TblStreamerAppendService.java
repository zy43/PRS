package com.ittime.linglingbo.modules.streamer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.modules.client.model.param.StreamerSeachListParam;
import com.ittime.linglingbo.modules.client.model.vo.AccurateSearchListVO;
import com.ittime.linglingbo.modules.streamer.model.param.StreamerSearchParam;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.streamer.model.vo.StreamerAppendVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblStreamerAppendService extends IService<TblStreamerAppend> {

    /**
     * 收藏主播分页查询
     *
     * @param pageSize
     * @param pageNum
     * @param param
     * @param userId
     * @return
     */
    IPage<StreamerAppendVo> list(Integer pageSize, Integer pageNum, StreamerSearchParam param, Long userId);


    List<AccurateSearchListVO> accurateSearchList(StreamerSeachListParam param);


}
