package com.ittime.linglingbo.modules.workbench.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.ittime.linglingbo.common.constant.TaskDetailStatusEnum;
import com.ittime.linglingbo.common.constant.TaskStatusEnum;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminOwnerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.task.mapper.TblTaskGoodsMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskSettleMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskStreamerMapper;
import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskSettle;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.workbench.service.OwnerWorkbenchService;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.owner.OwnerSettleDataVo;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhl129
 * @date 2022/12/3 14:43
 * @email 1293384775@qq.com
 */
@Service
public class OwnerWorkbenchServiceImpl implements OwnerWorkbenchService {

    @Autowired
    private TblTaskMapper taskMapper;

    @Autowired
    private UmsAdminOwnerMapper ownerMapper;

    @Autowired
    private TblTaskStreamerMapper taskStreamerMapper;

    @Autowired
    private TblTaskGoodsMapper taskGoodsMapper;

    @Autowired
    private TblTaskSettleMapper taskSettleMapper;

    @Override
    public OwnerAccountVo getAccountInfo(UmsAdmin admin) {
        OwnerAccountVo ownerAccountVo = new OwnerAccountVo();
        //基本信息
        ownerAccountVo.setId(admin.getId());
        ownerAccountVo.setUsername(admin.getUsername());
        ownerAccountVo.setTel(admin.getTel());
        //获取品牌商信息
        LambdaQueryWrapper<UmsAdminOwner> ownerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        ownerLambdaQueryWrapper.eq(UmsAdminOwner::getId,admin.getClientId());
        UmsAdminOwner umsAdminOwner = ownerMapper.selectOne(ownerLambdaQueryWrapper);
        //账户余额
        ownerAccountVo.setAccountBalance(umsAdminOwner.getAccountBalance());
        //认证状态
        String certification = umsAdminOwner.getCertification();
        ownerAccountVo.setCertification(certification);

        if("已认证".equals(certification)){
            //任务消耗
            LambdaQueryWrapper<TblTask> taskLambdaQueryWrapper = new LambdaQueryWrapper<>();
            taskLambdaQueryWrapper.eq(TblTask::getOwnerId,admin.getClientId());
            List<TblTask> taskList = taskMapper.selectList(taskLambdaQueryWrapper);

            BigDecimal taskConsume = new BigDecimal("0.00");
            for (TblTask tblTask : taskList) {
                if(tblTask.getTaskStatus() == TaskDetailStatusEnum.DOING.getValue()){
                    taskConsume = taskConsume.add(tblTask.getEarnestMoney());
                }
            }
            ownerAccountVo.setTaskConsume(taskConsume);
            //账户结算
            //得到品牌商发布的所有任务的id
            List<Long> taskIdList = taskList.stream().map((task) -> task.getId()).collect(Collectors.toList());
            LambdaQueryWrapper<TblTaskStreamer> taskStreamerLambdaQueryWrapper = new LambdaQueryWrapper<>();
            taskStreamerLambdaQueryWrapper.in(TblTaskStreamer::getTaskId,taskIdList)
                    .eq(TblTaskStreamer::getTaskDetailStatus,TaskDetailStatusEnum.DONE.getValue());

            List<TblTaskStreamer> taskStreamerList = taskStreamerMapper.selectList(taskStreamerLambdaQueryWrapper);
            BigDecimal settleCount = new BigDecimal("0.00");
            for (TblTaskStreamer taskStreamer : taskStreamerList) {
                settleCount = settleCount.add(taskStreamer.getSettleMoney());
            }
            ownerAccountVo.setAccountSettle(settleCount);
        }

        return ownerAccountVo;
    }

    @Override
    public OwnerDynamicDataVo getTaskDynamicData(UmsAdmin admin) {

        Long ownerId = admin.getClientId();
        OwnerDynamicDataVo ownerDynamicDataVo = new OwnerDynamicDataVo();
        //品牌总量 -- 默认品牌商只有一个品牌
        ownerDynamicDataVo.setBrandCount(1);
        //获取发布的任务
        LambdaQueryWrapper<TblTask> taskLambdaQueryWrapper = new LambdaQueryWrapper<>();
        taskLambdaQueryWrapper.eq(TblTask::getOwnerId,ownerId);
        List<TblTask> taskList = taskMapper.selectList(taskLambdaQueryWrapper);
        if(!taskList.isEmpty()){
            //任务总量
            Long taskCount = taskMapper.selectCount(taskLambdaQueryWrapper);
            ownerDynamicDataVo.setTaskCount(taskCount.intValue());

            Integer waitUndertakeTaskCount =0;
            Integer settleTaskCount=0;
            Integer waitHandleTaskCount=0;
            for (TblTask task : taskList) {
                if(task.getTaskStatus() == TaskStatusEnum.UNDERTAKE_WAIT.getValue()){
                    waitUndertakeTaskCount++;
                } else if (task.getTaskStatus() == TaskStatusEnum.DONE.getValue()) {
                    settleTaskCount++;
                } else if (task.getTaskStatus() == TaskStatusEnum.PUBLISH_WAIT.getValue()) {
                    waitHandleTaskCount++;
                }
            }
            //发布任务量
            ownerDynamicDataVo.setWaitUndertakeTaskCount(waitUndertakeTaskCount);
            //结算任务量
            ownerDynamicDataVo.setSettleTaskCount(settleTaskCount);
            //待处理任务量
            ownerDynamicDataVo.setWaitHandleTaskCount(waitHandleTaskCount);

            List<Long> taskIdList = taskList.stream().map((task) -> task.getId()).collect(Collectors.toList());

            //播主总量
            QueryWrapper<TblTaskStreamer> streamerQueryWrapper = new QueryWrapper<>();
            streamerQueryWrapper.select("COUNT(DISTINCT streamer_id) AS streamer_count").lambda().
                    in(TblTaskStreamer::getTaskId,taskIdList).
                    ne(TblTaskStreamer::getTaskDetailStatus,TaskDetailStatusEnum.UNDERTAKE_FAIL.getValue());
            Map<String, Object> streamerCountMap = SqlHelper.getObject(LogFactory.getLog(this.getClass()), this.taskStreamerMapper.selectMaps(streamerQueryWrapper));
            if(streamerCountMap != null){
                Integer streamerCount = Integer.parseInt(streamerCountMap.get("streamer_count").toString()) ;
                ownerDynamicDataVo.setStreamerCount(streamerCount);
            }
            //销售总量
            QueryWrapper<TblTaskStreamer> saleQueryWrapper = new QueryWrapper<>();
            saleQueryWrapper.select("SUM(complete_num) AS sale_count").lambda().
                    in(TblTaskStreamer::getTaskId,taskIdList);
            Map<String,Object> saleCountMap = SqlHelper.getObject(LogFactory.getLog(this.getClass()), this.taskStreamerMapper.selectMaps(saleQueryWrapper));
            if(saleCountMap !=null){
                Integer saleCount = Integer.parseInt(saleCountMap.get("sale_count").toString()) ;
                ownerDynamicDataVo.setSaleCount(saleCount);
            }
            //商品总量
            QueryWrapper<TblTaskGoods> goodsQueryWrapper = new QueryWrapper<>();
            goodsQueryWrapper.select("SUM(goods_num) AS goods_count").lambda().
                    in(TblTaskGoods::getTaskId,taskIdList);
            Map<String,Object> goodsCountMap = SqlHelper.getObject(LogFactory.getLog(this.getClass()), this.taskGoodsMapper.selectMaps(goodsQueryWrapper));
            if(goodsCountMap !=null){
                Integer goodsCount = Integer.parseInt(goodsCountMap.get("goods_count").toString());
                ownerDynamicDataVo.setGoodsCount(goodsCount);
            }

        }

        return ownerDynamicDataVo;
    }

    @Override
    public OwnerSettleDataVo getTaskSettleData(UmsAdmin admin) {

        OwnerSettleDataVo ownerSettleDataVo = new OwnerSettleDataVo();
        LambdaQueryWrapper<TblTask> taskLambdaQueryWrapper = new LambdaQueryWrapper<>();
        taskLambdaQueryWrapper.eq(TblTask::getOwnerId,admin.getClientId()).ne(TblTask::getTaskStatus,TaskStatusEnum.PUBLISH_FAIL.getValue());
        List<TblTask> taskList = taskMapper.selectList(taskLambdaQueryWrapper);
        //预算金额
        BigDecimal budgetCount = new BigDecimal("0.00");
        for (TblTask task : taskList) {
            budgetCount = budgetCount.add(task.getBudget());
        }
        ownerSettleDataVo.setBudgetCount(budgetCount);

        //结算总额
        List<Long> taskIdList = taskList.stream().map((task) -> task.getId()).collect(Collectors.toList());
        QueryWrapper<TblTaskStreamer> settleQueryWrapper = new QueryWrapper<>();
        settleQueryWrapper.select("SUM(settle_money) AS settle_count").lambda().
                in(TblTaskStreamer::getTaskId,taskIdList);
        Map<String,Object> settleCountMap = SqlHelper.getObject(LogFactory.getLog(this.getClass()), this.taskStreamerMapper.selectMaps(settleQueryWrapper));
        if(settleCountMap !=null) {
            BigDecimal settleCount = new BigDecimal(settleCountMap.get("settle_count").toString());
            ownerSettleDataVo.setSettleCount(settleCount);
        }else {
            ownerSettleDataVo.setSettleCount(new BigDecimal("0.00"));
        }
        //销售总量
        QueryWrapper<TblTaskStreamer> saleQueryWrapper = new QueryWrapper<>();
        saleQueryWrapper.select("SUM(complete_num) AS sale_count").lambda().
                in(TblTaskStreamer::getTaskId,taskIdList);
        Map<String,Object> saleCountMap = SqlHelper.getObject(LogFactory.getLog(this.getClass()), this.taskStreamerMapper.selectMaps(saleQueryWrapper));
        if(saleCountMap !=null){
            Integer saleCount = Integer.parseInt(saleCountMap.get("sale_count").toString()) ;
            ownerSettleDataVo.setSaleCount(saleCount);
        }
        //收入产值
        BigDecimal incomeCount = new BigDecimal("0.00");
        LambdaQueryWrapper<TblTaskSettle> goodsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        goodsLambdaQueryWrapper.in(TblTaskSettle::getTaskId,taskIdList);
        List<TblTaskSettle> goodsList = taskSettleMapper.selectList(goodsLambdaQueryWrapper);
        for (TblTaskSettle goods : goodsList) {
            BigDecimal income = new BigDecimal(goods.getSaleNum().toString());
            income = income.multiply(goods.getGoodsPrice());
            incomeCount = incomeCount.add(income);
        }
        incomeCount = incomeCount.subtract(ownerSettleDataVo.getSettleCount());
        ownerSettleDataVo.setIncomeCount(incomeCount);
        return ownerSettleDataVo;
    }
}
