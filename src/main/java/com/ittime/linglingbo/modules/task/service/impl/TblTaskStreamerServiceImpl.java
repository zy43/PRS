package com.ittime.linglingbo.modules.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.common.constant.TaskDetailStatusEnum;
import com.ittime.linglingbo.modules.task.convert.TaskStreamerConvert;
import com.ittime.linglingbo.modules.task.mapper.TblTaskSettleMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskStreamerMapper;
import com.ittime.linglingbo.modules.task.model.TblTaskSettle;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerSettleParam;
import com.ittime.linglingbo.modules.task.model.param.TaskStreamerUndertakeParam;
import com.ittime.linglingbo.modules.task.service.TblTaskStreamerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 任务承接结算表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblTaskStreamerServiceImpl extends ServiceImpl<TblTaskStreamerMapper, TblTaskStreamer> implements TblTaskStreamerService {

    @Autowired
    private TaskStreamerConvert taskStreamerConvert;
    @Autowired
    private TblTaskSettleMapper taskSettleMapper;


    @Override
    public boolean undertakeTask(TaskStreamerUndertakeParam param) {
        TblTaskStreamer taskStreamer = taskStreamerConvert.toEntity(param);
        // TDS=2 (Task Detail Status)
        taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.UNDERTAKE_AUDIT.getValue());
        return save(taskStreamer);
    }

    @Override
    public boolean settleTask(TaskStreamerSettleParam param) {
        final TblTaskStreamer taskStreamer = taskStreamerConvert.toEntity(param);
        final Long taskStreamerId = baseMapper.selectOne(new LambdaQueryWrapper<TblTaskStreamer>()
                .eq(TblTaskStreamer::getTaskId, param.getTaskId())).getId();
        taskStreamer.setId(taskStreamerId);
        // TDS=5
        taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.SETTLE_AUDIT.getValue());

        for (TblTaskSettle goodsSettle : param.getGoodsSettles()) {
            taskSettleMapper.insert(goodsSettle);
        }

        return updateById(taskStreamer);
    }
}
