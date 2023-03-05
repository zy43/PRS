package com.ittime.linglingbo.modules.task.convert;

import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerSettleParam;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerUndertakeParam;
import org.mapstruct.Mapper;

/**
 * @author Josh-ZJUT
 * @date 2022/11/22 14:02
 * @email dujianghui537885@163.com
 */
@Mapper(componentModel = "spring")
public interface TaskStreamerConvert {

    TblTaskStreamer toEntity(TaskStreamerUndertakeParam param);

    TblTaskStreamer toEntity(TaskStreamerSettleParam param);
}
