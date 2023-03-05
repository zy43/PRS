package com.ittime.linglingbo.modules.task.convert;

import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.param.TaskOwnerAddParam;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailStreamerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListStreamerVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Josh-ZJUT
 * @date 2022/10/20 12:43
 * @email dujianghui537885@163.com
 */
@Mapper(componentModel = "spring")
public interface TaskConvert {
    TaskListOwnerVo toTaskListOwnerVo(TblTask task);

    TaskListStreamerVo toTaskListStreamerVo(TblTask task);

    TaskDetailOwnerVo toTaskDetailOwnerVo(TblTask task);

    TaskDetailStreamerVo toTaskDetailStreamerVo(TblTask task);

    @Mapping(source = "taskId", target = "id")
    TblTask toEntity(TaskOwnerAddParam taskOwnerAddParam);
}
