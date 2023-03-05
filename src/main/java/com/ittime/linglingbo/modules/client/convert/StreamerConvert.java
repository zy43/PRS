package com.ittime.linglingbo.modules.client.convert;

import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.client.model.vo.StreamerListVO;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.ums.dto.*;
import org.mapstruct.Mapper;

/**
 * 类型转换
 */
@Mapper(componentModel = "spring")
public interface StreamerConvert {

    StreamerListVO toStreamerListVO(UmsAdminStreamer umsAdminStreamer);

    UmsStarChartVo toStarChartVo(TblStreamerAppend tblStreamerAppend);

    StreamerCompareSearchVo toStreamerCompareSearchVO(TblStreamerAppend tblStreamerAppend);

    MCNListVo toMCNListVo(TblStreamerAppend tblStreamerAppend);

    MCNInfoVo toMCNInfoVo(TblStreamerAppend tblStreamerAppend);

    MCNSignVo toMCNSignVo(TblStreamerAppend tblStreamerAppend);
}
