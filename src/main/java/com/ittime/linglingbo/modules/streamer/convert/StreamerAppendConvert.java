package com.ittime.linglingbo.modules.streamer.convert;

import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.model.vo.StreamerAppendVo;
import org.mapstruct.Mapper;

/**
 * @Description：
 * @Author zy-zjut
 * @Date 2022/12/21
 **/
@Mapper(componentModel = "spring")
public interface StreamerAppendConvert {

    StreamerAppendVo toStreamerAppendListVo(TblStreamerAppend streamerAppend);
}
