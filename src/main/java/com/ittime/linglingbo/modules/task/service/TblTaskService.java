package com.ittime.linglingbo.modules.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.yulichang.base.MPJBaseService;
import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.param.TaskOwnerAddParam;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailStreamerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListStreamerVo;

import java.util.List;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblTaskService extends MPJBaseService<TblTask> {


    /**
     * 根据任务名称分页查询任务
     *
     * @param taskName 任务名称
     * @param pageSize 分页大小
     * @param pageNum  第几页
     * @return
     */
    IPage<TaskListOwnerVo> listForOwner(Integer pageSize, Integer pageNum, String taskName, String goodsCategory, String brand);

    /**
     * 根据任务名称分页查询任务
     *
     * @param taskName 任务名称
     * @param pageSize 分页大小
     * @param pageNum  第几页
     * @return
     */
    IPage<TaskListStreamerVo> listForStreamer(Integer pageSize, Integer pageNum, String taskName, String goodsCategory, String brand);


    /**
     * 根据任务名称查询所有任务
     *
     * @param taskName
     * @return
     */
    List<TaskListOwnerVo> listAllForOwner(String taskName, String goodsCategory, String brand);

    /**
     * 根据任务名称查询所有任务
     *
     * @param taskName
     * @return
     */
    List<TaskListStreamerVo> listAllForStreamer(String taskName);

    /**
     * 删除任务同时删除关联表
     *
     * @param ownerId 品牌方id
     * @param id      任务id
     */
    boolean delete(Long ownerId, Long id);

    /**
     * 查询任务详情
     *
     * @param ownerId 品牌方id
     * @param taskId      任务id
     * @return
     */
    TaskDetailOwnerVo detailForOwner(Long ownerId, Long taskId);

    /**
     * 查询任务详情
     *
     * @param id 任务id
     * @return
     */
    TaskDetailStreamerVo detailForStreamer(Long id);

    /**
     * 更新项目信息
     *
     * @param ownerId           品牌方id
     * @param taskOwnerAddParam
     * @return
     */
    boolean updateTask(Long ownerId, TaskOwnerAddParam taskOwnerAddParam);

    /**
     * 新增项目
     *
     * @param ownerId           品牌方id
     * @param taskOwnerAddParam
     * @return
     */
    boolean create(Long ownerId, TaskOwnerAddParam taskOwnerAddParam);


    /**
     * 任务发布审核
     *
     * @param taskId 任务id
     * @param pass   是否通过
     * @return
     */
    boolean auditCreate(Long taskId, Boolean pass);

    /**
     * 任务承接审核
     *
     * @param taskId 任务id
     * @param pass   是否通过
     * @return
     */
    boolean auditUndertake(Long taskId, Boolean pass);

    /**
     * 任务结算审核
     *
     * @param taskId 任务id
     * @param pass   是否通过
     * @return
     */
    boolean auditSettle(Long taskId, Boolean pass);

}
