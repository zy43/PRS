package com.ittime.linglingbo.modules.task.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.ittime.linglingbo.common.component.IdGenerator;
import com.ittime.linglingbo.common.constant.TaskDetailStatusEnum;
import com.ittime.linglingbo.common.constant.TaskStatusEnum;
import com.ittime.linglingbo.common.exception.ApiException;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminOwnerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.goods.mapper.TblCategoryGoodsMapper;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsMapper;
import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.task.convert.TaskConvert;
import com.ittime.linglingbo.modules.task.convert.TaskGoodsConvert;
import com.ittime.linglingbo.modules.task.mapper.TblTaskGoodsMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskSettleMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskStreamerMapper;
import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskSettle;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.param.TaskOwnerAddParam;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskDetailStreamerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListOwnerVo;
import com.ittime.linglingbo.modules.task.model.vo.TaskListStreamerVo;
import com.ittime.linglingbo.modules.task.service.TblTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblTaskServiceImpl extends MPJBaseServiceImpl<TblTaskMapper, TblTask> implements TblTaskService {

    @Autowired
    private TblTaskMapper taskMapper;

    @Autowired
    private TaskConvert taskConvert;


    @Autowired
    private TaskGoodsConvert taskGoodsConvert;

    @Autowired
    private UmsAdminOwnerMapper ownerMapper;

    @Autowired
    private TblTaskGoodsMapper taskGoodsMapper;

    @Autowired
    private TblGoodsMapper goodsMapper;

    @Autowired
    private TblCategoryGoodsMapper categoryGoodsMapper;

    @Autowired
    private TblTaskStreamerMapper taskStreamerMapper;

    @Autowired
    private TblTaskSettleMapper taskSettleMapper;

    public IPage<TaskListOwnerVo> listForOwner(Integer pageSize, Integer pageNum, String taskName, String goodsCategory, String brand) {
        // 联表查询
        MPJLambdaWrapper<TblTask> wrapper = new MPJLambdaWrapper<TblTask>()
                .selectAll(TblTask.class)
                .like(StrUtil.isNotEmpty(taskName), TblTask::getTaskName, taskName);
        if (StrUtil.isNotEmpty(brand)) {
            wrapper.leftJoin(TblTaskGoods.class, TblTaskGoods::getTaskId, TblTask::getId)
                    .leftJoin(TblGoods.class, TblGoods::getId, TblTaskGoods::getGoodsId)
                    .like(TblGoods::getGoodsBrand, brand);
            if (StrUtil.isNotEmpty(goodsCategory)) {
                wrapper.leftJoin(TblCategoryGoods.class, TblCategoryGoods::getId, TblGoods::getCategoryId)
                        .like(TblCategoryGoods::getCategoryName, goodsCategory);
            }
        } else {
            if (StrUtil.isNotEmpty(goodsCategory)) {
                wrapper.leftJoin(TblTaskGoods.class, TblTaskGoods::getTaskId, TblTask::getId)
                        .leftJoin(TblGoods.class, TblGoods::getId, TblTaskGoods::getGoodsId)
                        .leftJoin(TblCategoryGoods.class, TblCategoryGoods::getId, TblGoods::getCategoryId)
                        .like(TblCategoryGoods::getCategoryName, goodsCategory);
            }
        }


        // task 实体对象
        IPage<TblTask> iPage = taskMapper.selectJoinPage(new Page<>(pageNum, pageSize), TblTask.class, wrapper);
        // 转成 VO
        return iPage.convert(this::convertToView);
    }

    public IPage<TaskListStreamerVo> listForStreamer(Integer pageSize, Integer pageNum, String taskName, String goodsCategory, String brand) {
        // 联表查询
        MPJLambdaWrapper<TblTask> wrapper = new MPJLambdaWrapper<TblTask>()
                .selectAll(TblTask.class)
                .like(StrUtil.isNotEmpty(taskName), TblTask::getTaskName, taskName);
        if (StrUtil.isNotEmpty(brand)) {
            wrapper.leftJoin(TblTaskGoods.class, TblTaskGoods::getTaskId, TblTask::getId)
                    .leftJoin(TblGoods.class, TblGoods::getId, TblTaskGoods::getGoodsId)
                    .eq(TblGoods::getGoodsBrand, brand);
            if (StrUtil.isNotEmpty(goodsCategory)) {
                wrapper.leftJoin(TblCategoryGoods.class, TblCategoryGoods::getId, TblGoods::getCategoryId)
                        .eq(TblCategoryGoods::getCategoryName, goodsCategory);
            }
        } else {
            if (StrUtil.isNotEmpty(goodsCategory)) {
                wrapper.leftJoin(TblTaskGoods.class, TblTaskGoods::getTaskId, TblTask::getId)
                        .leftJoin(TblGoods.class, TblGoods::getId, TblTaskGoods::getGoodsId)
                        .leftJoin(TblCategoryGoods.class, TblCategoryGoods::getId, TblGoods::getCategoryId)
                        .eq(TblCategoryGoods::getCategoryName, goodsCategory);
            }
        }


        // task 实体对象
        final IPage<TblTask> iPage = baseMapper.selectJoinPage(new Page<>(pageNum, pageSize), TblTask.class, wrapper);
        // 转成 VO
        return iPage.convert(task -> {
            TaskListStreamerVo taskListStreamerVo = taskConvert.toTaskListStreamerVo(task);
            // 所属企业名称
            if (task.getOwnerId() != null) {
                final String companyName = ownerMapper.selectById(task.getOwnerId()).getCompanyName();
                taskListStreamerVo.setCompanyName(companyName);
            }
            // 关联商品数量
            final Long goodsCount = taskGoodsMapper.selectCount(new LambdaQueryWrapper<TblTaskGoods>()
                    .eq(TblTaskGoods::getTaskId, task.getId()));
            taskListStreamerVo.setRelatedGoodsCount(goodsCount);

            final List<TblTaskStreamer> taskStreamers = taskStreamerMapper.selectList(new LambdaQueryWrapper<TblTaskStreamer>()
                    .eq(TblTaskStreamer::getTaskId, task.getId()));
            // 关联播主数
            taskListStreamerVo.setRelatedStreamerCount((long) taskStreamers.size());
            // 播主完成量
            final int totalCompleteNum = taskStreamers.stream().mapToInt(TblTaskStreamer::getCompleteNum).sum();
            taskListStreamerVo.setCompleteNum(totalCompleteNum);
            return taskListStreamerVo;
        });
    }

    public List<TaskListOwnerVo> listAllForOwner(String taskName, String goodsCategory, String brand) {

        List<Long> categoryIds = new ArrayList<>();
        if (StrUtil.isNotEmpty(goodsCategory)) {
            categoryIds = categoryGoodsMapper.selectList(new LambdaQueryWrapper<TblCategoryGoods>().like(TblCategoryGoods::getCategoryName, goodsCategory))
                    .stream().map(TblCategoryGoods::getId).collect(Collectors.toList());
        }
        List<Long> goodsIds = new ArrayList<>();
        if (StrUtil.isNotEmpty(brand)) {
            goodsIds = goodsMapper.selectList(new LambdaQueryWrapper<TblGoods>()
                            .like(TblGoods::getGoodsBrand, brand)
                            .in(CollectionUtil.isNotEmpty(categoryIds), TblGoods::getCategoryId, categoryIds))
                    .stream().map(TblGoods::getId).collect(Collectors.toList());
        }
        List<Long> taskIds = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(goodsIds)) {
            taskIds = taskGoodsMapper.selectList(new LambdaQueryWrapper<TblTaskGoods>().in(TblTaskGoods::getGoodsId, goodsIds))
                    .stream().map(TblTaskGoods::getTaskId).collect(Collectors.toList());
        }

        QueryWrapper<TblTask> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<TblTask> lambda = wrapper.lambda();
        if (StrUtil.isNotEmpty(taskName)) {
            lambda.like(TblTask::getTaskName, taskName)
                    .in(CollectionUtil.isNotEmpty(taskIds), TblTask::getId, taskIds);
        }
        List<TblTask> list = baseMapper.selectList(lambda);
        return list.stream().map(this::convertToView).collect(Collectors.toList());
    }

    public List<TaskListStreamerVo> listAllForStreamer(String taskName) {
        QueryWrapper<TblTask> wrapper = new QueryWrapper<>();
        LambdaQueryWrapper<TblTask> lambda = wrapper.lambda();
        if (StrUtil.isNotEmpty(taskName)) {
            lambda.like(TblTask::getTaskName, taskName);
        }
        List<TblTask> list = baseMapper.selectList(lambda);
        List<TaskListStreamerVo> res = new ArrayList<>(list.size());
        for (TblTask task : list) {
            TaskListStreamerVo taskListStreamerVo = taskConvert.toTaskListStreamerVo(task);
            // 所属企业名称
            if (task.getOwnerId() != null) {
                final UmsAdminOwner owner = ownerMapper.selectById(task.getOwnerId());
                if (owner != null) {
                    taskListStreamerVo.setCompanyName(owner.getCompanyName());
                }
            }
            // 关联商品数量
            final Long goodsCount = taskGoodsMapper.selectCount(new LambdaQueryWrapper<TblTaskGoods>()
                    .eq(TblTaskGoods::getTaskId, task.getId()));
            taskListStreamerVo.setRelatedGoodsCount(goodsCount);

            final List<TblTaskStreamer> taskStreamers = taskStreamerMapper.selectList(new LambdaQueryWrapper<TblTaskStreamer>()
                    .eq(TblTaskStreamer::getTaskId, task.getId()));
            // 关联播主数
            taskListStreamerVo.setRelatedStreamerCount((long) taskStreamers.size());
            // 播主完成量
            final int totalCompleteNum = taskStreamers.stream().mapToInt(TblTaskStreamer::getCompleteNum).sum();
            taskListStreamerVo.setCompleteNum(totalCompleteNum);
            res.add(taskListStreamerVo);
        }
        return res;
    }

    /**
     * zhl:
     * 关联删除
     * 1.task
     * 2.task_goods
     * 3.task_brand
     * 4.tbl_category_goods
     * 待商议：
     * 5.task_settle
     * 6.task_streamer
     *
     * @param id 任务id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long ownerId, Long id) {
        if (!baseMapper.selectById(id).getOwnerId().equals(ownerId)) {
            return false;
        }

        // 删除任务商品关联表
        List<Long> taskGoodsIds = taskGoodsMapper
                .selectList(new LambdaQueryWrapper<TblTaskGoods>()
                        .eq(TblTaskGoods::getTaskId, id))
                .stream().map(TblTaskGoods::getId)
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(taskGoodsIds)) {
            taskGoodsMapper.deleteBatchIds(taskGoodsIds);
        }
        // 删除任务主播关联表
        List<Long> taskStreamerIds = taskStreamerMapper
                .selectList(new LambdaQueryWrapper<TblTaskStreamer>()
                        .eq(TblTaskStreamer::getTaskId, id))
                .stream().map(TblTaskStreamer::getId)
                .collect(Collectors.toList());
        if (CollectionUtil.isNotEmpty(taskStreamerIds)) {
            for (Long taskStreamerId : taskStreamerIds) {
                if (taskStreamerMapper.selectById(taskStreamerId).getTaskDetailStatus() >= 4) {
                    throw new ApiException("任务正在履约，无法删除！");
                }
            }
            taskStreamerMapper.deleteBatchIds(taskStreamerIds);
        }
        // 删除任务
        return removeById(id);
    }

    @Override
    public TaskDetailOwnerVo detailForOwner(Long ownerId, Long taskId) {
        if (!baseMapper.selectById(taskId).getOwnerId().equals(ownerId)) {
            return null;
        }
        // TblTask -> TaskDetailOwnerVo
        TaskDetailOwnerVo taskDetailOwnerVo = taskConvert.toTaskDetailOwnerVo(getById(taskId));
        // 任务关联的商品信息（名称、规格、数量、售价）
        List<TblTaskGoods> taskGoodsList = taskGoodsMapper.selectList(new LambdaQueryWrapper<TblTaskGoods>()
                .eq(TblTaskGoods::getTaskId, taskId));
        taskDetailOwnerVo.setTaskGoodsList(taskGoodsList);
        // 商品 ids
        final List<Long> goodsIds = taskGoodsList.stream()
                .map(TblTaskGoods::getGoodsId)
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(goodsIds)) {
            return taskDetailOwnerVo;
        }
        // 商品元信息列表
        final List<TblGoods> goodsList = goodsMapper.selectList(new LambdaQueryWrapper<TblGoods>()
                .in(TblGoods::getId, goodsIds));
        // 商品所属品牌（界面上需要打勾）
        Set<String> brandSet = new HashSet<>();
        // 品牌所属分类（界面上需要打勾）
        Set<String> goodsCategorySet = new HashSet<>();
        for (TblGoods goods : goodsList) {
            // 已知商品的情况下，回填品牌和分类
            brandSet.add(goods.getGoodsBrand());
            final String categoryName = categoryGoodsMapper.selectById(goods.getCategoryId()).getCategoryName();
            goodsCategorySet.add(categoryName);
        }
        taskDetailOwnerVo.setBrandSet(brandSet);
        taskDetailOwnerVo.setGoodsCategorySet(goodsCategorySet);

        // 结算信息
        final TblTaskStreamer taskStreamer = taskStreamerMapper.selectOne(new LambdaQueryWrapper<TblTaskStreamer>()
                .eq(TblTaskStreamer::getTaskId, taskId));
        if (taskStreamer != null) {
            // 结算金额
            taskDetailOwnerVo.setSettleMoney(taskStreamer.getSettleMoney());
            // 结算备注
            taskDetailOwnerVo.setSettleRemark(taskStreamer.getSettleRemark());
            // 播主完成量
            taskDetailOwnerVo.setCompleteNum(taskStreamer.getCompleteNum());
        }

        // 商品结算明细
        final List<TblTaskSettle> goodsSettles = taskSettleMapper.selectList(new LambdaQueryWrapper<TblTaskSettle>()
                .eq(TblTaskSettle::getTaskId, taskId));
        if (CollectionUtil.isNotEmpty(goodsSettles)) {
            taskDetailOwnerVo.setGoodsSettles(goodsSettles);
        }

        return taskDetailOwnerVo;
    }

    @Override
    public TaskDetailStreamerVo detailForStreamer(Long id) {

        // TblTask -> TaskDetailOwnerVo
        TaskDetailStreamerVo taskDetailStreamerVo = taskConvert.toTaskDetailStreamerVo(getById(id));
        // 任务关联的商品信息（名称、规格、数量、售价）
        List<TblTaskGoods> taskGoodsList = taskGoodsMapper.selectList(new LambdaQueryWrapper<TblTaskGoods>()
                .eq(TblTaskGoods::getTaskId, id));
        taskDetailStreamerVo.setTaskGoodsList(taskGoodsList);
        // 商品 ids
        final List<Long> goodsIds = taskGoodsList.stream()
                .map(TblTaskGoods::getGoodsId)
                .collect(Collectors.toList());
        if (CollectionUtil.isEmpty(goodsIds)) {
            return taskDetailStreamerVo;
        }
        // 商品元信息列表
        final List<TblGoods> goodsList = goodsMapper.selectList(new LambdaQueryWrapper<TblGoods>()
                .in(TblGoods::getId, goodsIds));
        // 商品所属品牌（界面上需要打勾）
        Set<String> brandSet = new HashSet<>();
        // 品牌所属分类（界面上需要打勾）
        Set<String> goodsCategorySet = new HashSet<>();
        for (TblGoods goods : goodsList) {
            // 已知商品的情况下，回填品牌和分类
            brandSet.add(goods.getGoodsBrand());
            final String categoryName = categoryGoodsMapper.selectById(goods.getCategoryId()).getCategoryName();
            goodsCategorySet.add(categoryName);
        }
        taskDetailStreamerVo.setBrandSet(String.join("，", brandSet));
        taskDetailStreamerVo.setGoodsCategorySet(String.join("，", goodsCategorySet));
        return taskDetailStreamerVo;
    }

    /**
     * zhl:
     * 关联删除
     * 1.task
     * 2.task_goods
     * 3.task_brand
     * 4.tbl_category_goods
     * 待商议：
     * 5.task_settle
     * 6.task_streamer
     *
     * @param taskOwnerAddParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateTask(Long ownerId, TaskOwnerAddParam taskOwnerAddParam) {
        if (!baseMapper.selectById(taskOwnerAddParam.getTaskId()).getOwnerId().equals(ownerId)) {
            return false;
        }
        // 先删除旧联系
        taskGoodsMapper.delete(new LambdaQueryWrapper<TblTaskGoods>().eq(TblTaskGoods::getTaskId, taskOwnerAddParam.getTaskId()));
        // 再建立新联系
        for (Long goodsId : taskOwnerAddParam.getGoodsIds()) {
            final TblGoods tblGoods = goodsMapper.selectById(goodsId);
            TblTaskGoods taskGoods = taskGoodsConvert.toEntity(tblGoods);
            taskGoods.setTaskId(taskOwnerAddParam.getTaskId());
            taskGoodsMapper.insert(taskGoods);
        }

        final TblTask task = taskConvert.toEntity(taskOwnerAddParam);
        return updateById(task);
    }

    @Override
    public boolean create(Long ownerId, TaskOwnerAddParam taskOwnerAddParam) {
        TblTask task = taskConvert.toEntity(taskOwnerAddParam);
        task.setOwnerId(ownerId);
        // TS=1 (Task Status)
        task.setTaskStatus(TaskStatusEnum.PUBLISH_WAIT.getValue());
        // 先添加任务表生成 taskId
        final boolean success = save(task);
        final Long taskId = task.getId();
        for (Long goodsId : taskOwnerAddParam.getGoodsIds()) {
            final TblGoods tblGoods = goodsMapper.selectById(goodsId);
            if (tblGoods == null) {
                log.error("商品id不存在");
                return false;
            }
            TblTaskGoods taskGoods = taskGoodsConvert.toEntity(tblGoods);
            taskGoods.setTaskId(taskId);
            taskGoods.setId(IdGenerator.generateId());
            taskGoodsMapper.insert(taskGoods);
        }
        return success;
    }

    @Override
    public boolean auditCreate(Long taskId, Boolean pass) {
        TblTask task = baseMapper.selectById(taskId);
        if (pass == null || task == null) {
            return false;
        }
        if (pass) {
            // TS=2
            task.setTaskStatus(TaskStatusEnum.UNDERTAKE_WAIT.getValue());
        } else {
            // TS=3
            task.setTaskStatus(TaskStatusEnum.PUBLISH_FAIL.getValue());
        }
        return updateById(task);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean auditUndertake(Long taskId, Boolean pass) {
        TblTask task = baseMapper.selectById(taskId);
        TblTaskStreamer taskStreamer = taskStreamerMapper.selectOne(new LambdaQueryWrapper<TblTaskStreamer>()
                .eq(TblTaskStreamer::getTaskId, taskId));
        if (pass == null || task == null || taskStreamer == null) {
            return false;
        }
        boolean a = false;
        if (pass) {
            // TS=4
            task.setTaskStatus(TaskStatusEnum.DOING.getValue());
            a = updateById(task);
            // TDS=4
            taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.DOING.getValue());
        } else {
            // TDS=3
            taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.UNDERTAKE_FAIL.getValue());
        }
        final int b = taskStreamerMapper.updateById(taskStreamer);
        return a && b > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean auditSettle(Long taskId, Boolean pass) {
        TblTask task = baseMapper.selectById(taskId);
        TblTaskStreamer taskStreamer = taskStreamerMapper.selectOne(new LambdaQueryWrapper<TblTaskStreamer>()
                .eq(TblTaskStreamer::getTaskId, taskId));
        if (pass == null || task == null || taskStreamer == null) {
            return false;
        }
        if (pass) {
            // TS=5
            task.setTaskStatus(TaskStatusEnum.DONE.getValue());
            updateById(task);
            // TDS=7
            taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.DONE.getValue());
        } else {
            // TDS=6
            taskStreamer.setTaskDetailStatus(TaskDetailStatusEnum.SETTLE_FAIL.getValue());
        }
        final int b = taskStreamerMapper.updateById(taskStreamer);
        return b > 0;
    }


    private TaskListOwnerVo convertToView(TblTask task) {
        if (task == null) {
            return null;
        }
        TaskListOwnerVo taskListOwnerVo = taskConvert.toTaskListOwnerVo(task);
        // 所属企业名称
        if (task.getOwnerId() != null) {
            final UmsAdminOwner owner = ownerMapper.selectById(task.getOwnerId());
            if (owner != null) {
                taskListOwnerVo.setCompanyName(owner.getCompanyName());
            }
        }
        // 关联商品数量
        final Long count = taskGoodsMapper.selectCount(new LambdaQueryWrapper<TblTaskGoods>()
                .eq(TblTaskGoods::getTaskId, task.getId()));
        taskListOwnerVo.setRelatedGoodsCount(count);
        // 中标主播名称
        final TblTaskStreamer taskStreamer = taskStreamerMapper.selectOne(new LambdaQueryWrapper<TblTaskStreamer>()
                .eq(TblTaskStreamer::getTaskId, task.getId()));
        if (taskStreamer != null) {
            taskListOwnerVo.setStreamerName(taskStreamer.getStreamerName());
        }
        return taskListOwnerVo;
    }
}
