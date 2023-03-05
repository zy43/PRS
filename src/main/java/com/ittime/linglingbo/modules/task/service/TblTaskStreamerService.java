package com.ittime.linglingbo.modules.task.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerSettleParam;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerUndertakeParam;

/**
 * <p>
 * 任务承接结算表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblTaskStreamerService extends IService<TblTaskStreamer> {
    /**
     * 播主提交承接任务申请
     *
     * @param param
     * @return
     */
    boolean undertakeTask(TaskStreamerUndertakeParam param);

    /**
     * 播主提交结算任务申请
     *
     * @param param
     * @return
     */
    boolean settleTask(TaskStreamerSettleParam param);
}
