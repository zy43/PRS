package com.ittime.linglingbo.modules.workbench.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ittime.linglingbo.common.constant.TaskDetailStatusEnum;
import com.ittime.linglingbo.common.constant.WithdrawStatusEnum;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminOwnerMapper;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.task.mapper.TblClientWithdrawCashMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskGoodsMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskStreamerMapper;
import com.ittime.linglingbo.modules.task.model.TblClientWithdrawCash;
import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.workbench.service.StreamerWorkbenchService;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerAccountVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerDynamicDataVo;
import com.ittime.linglingbo.modules.workbench.vo.streamer.StreamerSettleDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhl129
 * @date 2022/12/3 14:44
 * @email 1293384775@qq.com
 */
@Service
public class StreamerWorkbenchServiceImpl implements StreamerWorkbenchService {

    @Autowired
    private UmsAdminStreamerMapper umsAdminStreamerMapper;

    @Autowired
    private TblTaskStreamerMapper taskStreamerMapper;

    @Autowired
    private TblTaskMapper taskMapper;

    @Autowired
    private TblTaskGoodsMapper taskGoodsMapper;

    @Autowired
    private UmsAdminOwnerMapper ownerMapper;

    @Autowired
    private TblClientWithdrawCashMapper withdrawCashMapper;



    @Override
    public StreamerAccountVo getAccountInfo(UmsAdmin admin) {

        StreamerAccountVo streamerAccountVo = new StreamerAccountVo();
        //用户id
        streamerAccountVo.setId(admin.getId());
        //用户名
        streamerAccountVo.setUsername(admin.getUsername());
        //用户电话
        streamerAccountVo.setTel(admin.getTel());
        /*
        	余额信息显示账户当前可用余额
        	任务收益显示当前账户累计任务完成后收益总值
        	账户结算为任务累计结算金额（播主/MCN机构任务收益与账户结算相等，政府/品牌商则不一定相等：由于任务发起后会对相应账户金额进行冻结
         */

        UmsAdminStreamer umsAdminStreamer = umsAdminStreamerMapper.selectById(admin.getClientId());
        String certification = umsAdminStreamer.getCertification();
        //用户认证状态
        streamerAccountVo.setCertification(certification);
        if("已认证".equals(certification)){
            //账户余额
            streamerAccountVo.setAccountBalance(umsAdminStreamer.getAccountBalance());
            //任务收益
            LambdaQueryWrapper<TblTaskStreamer> streamerLambdaQueryWrapper = new LambdaQueryWrapper<>();
            streamerLambdaQueryWrapper.eq(TblTaskStreamer::getStreamerId,umsAdminStreamer.getId());
            List<TblTaskStreamer> taskStreamerList = taskStreamerMapper.selectList(streamerLambdaQueryWrapper);
            BigDecimal taskIncome = new BigDecimal("0.00");
            if(!taskStreamerList.isEmpty()) {
                for (TblTaskStreamer tblTaskStreamer : taskStreamerList) {
                    if (tblTaskStreamer.getTaskDetailStatus() == TaskDetailStatusEnum.DONE.getValue()){
                       taskIncome = taskIncome.add(tblTaskStreamer.getSettleMoney());
                    }
                }
            }
            streamerAccountVo.setAccountIncome(taskIncome);
            //账户结算
            streamerAccountVo.setAccountSettle(taskIncome);

            return streamerAccountVo;
        }





        return null;
    }

    @Override
    public StreamerDynamicDataVo getTaskDynamicData(UmsAdmin admin) {

        StreamerDynamicDataVo streamerDynamicDataVo = new StreamerDynamicDataVo();

        Long streamerId = admin.getClientId();

        LambdaQueryWrapper<TblTaskStreamer> taskStreamerQueryWrapper = new LambdaQueryWrapper<>();

        taskStreamerQueryWrapper.eq(TblTaskStreamer::getStreamerId,streamerId);

        //任务总量
        Long taskCount = taskStreamerMapper.selectCount(taskStreamerQueryWrapper);

        streamerDynamicDataVo.setTaskCount(taskCount);
        if(taskCount != 0L) {

            List<TblTaskStreamer> taskStreamerList = taskStreamerMapper.selectList(taskStreamerQueryWrapper);
            //承接任务量
            //结算任务量
            //问题任务量
            Integer undertakenTaskCount = 0;
            Integer settleTaskCount = 0;
            Integer problemTaskCount = 0;

            //商品销量
            Integer saleCount = 0;

            for (TblTaskStreamer taskStreamer : taskStreamerList) {
                if (taskStreamer.getTaskDetailStatus() == TaskDetailStatusEnum.DOING.getValue()) {
                    undertakenTaskCount++;
                } else if (taskStreamer.getTaskDetailStatus() == TaskDetailStatusEnum.DONE.getValue()) {
                    settleTaskCount++;
                } else if (taskStreamer.getTaskDetailStatus() == TaskDetailStatusEnum.UNDERTAKE_FAIL.getValue()
                        || taskStreamer.getTaskDetailStatus() == TaskDetailStatusEnum.SETTLE_FAIL.getValue()) {
                    problemTaskCount++;
                }
                saleCount += taskStreamer.getCompleteNum();
            }
            streamerDynamicDataVo.setUndertakenTaskCount(undertakenTaskCount);
            streamerDynamicDataVo.setSettleTaskCount(settleTaskCount);
            streamerDynamicDataVo.setProblemTaskCount(problemTaskCount);
            streamerDynamicDataVo.setSaleCount(saleCount);

            //从 task_streamer数据中获得taskId
            List<Long> taskIdList = taskStreamerList.stream().map((taskStreamer) -> taskStreamer.getTaskId()).collect(Collectors.toList());

            List<TblTask> taskList = taskMapper.selectBatchIds(taskIdList);
            //去重复统计品牌商数量
            QueryWrapper<TblTask> taskQueryWrapper = new QueryWrapper<>();
            taskQueryWrapper.select("DISTINCT owner_id").lambda().in(TblTask::getId, taskIdList);
            Long ownerCount = taskMapper.selectCount(taskQueryWrapper);
            //品牌商数量
            streamerDynamicDataVo.setOwnerCount(ownerCount.intValue());

            //品牌数量
            List<Long> ownerIdList = taskMapper.selectList(taskQueryWrapper).stream().map((task) -> task.getOwnerId()).collect(Collectors.toList());
            LambdaQueryWrapper<UmsAdminOwner> ownerLambdaQueryWrapper = new LambdaQueryWrapper<>();
            ownerLambdaQueryWrapper.in(UmsAdminOwner::getId, ownerIdList).eq(UmsAdminOwner::getCertification, "已认证");
            Long brandCount = ownerMapper.selectCount(ownerLambdaQueryWrapper);

            streamerDynamicDataVo.setBrandCount(brandCount.intValue());

            //统计任务中的商品总量
            LambdaQueryWrapper<TblTaskGoods> taskGoodsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            taskGoodsLambdaQueryWrapper.in(TblTaskGoods::getTaskId, taskIdList);

            List<TblTaskGoods> taskGoodsList = taskGoodsMapper.selectList(taskGoodsLambdaQueryWrapper);
            Integer goodsCount = 0;
            for (TblTaskGoods taskGoods : taskGoodsList) {
                goodsCount += taskGoods.getGoodsNum();
            }
            //商品总量
            streamerDynamicDataVo.setGoodsCount(goodsCount);
        }



        return streamerDynamicDataVo;
    }

    @Override
    public StreamerSettleDataVo getTaskSettleData(UmsAdmin admin) {

        StreamerSettleDataVo streamerSettleDataVo = new StreamerSettleDataVo();
        //查找与主播相关的任务数据
        LambdaQueryWrapper<TblTaskStreamer> taskStreamerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        taskStreamerLambdaQueryWrapper.eq(TblTaskStreamer::getStreamerId,admin.getClientId())
                .eq(TblTaskStreamer::getTaskDetailStatus,TaskDetailStatusEnum.DONE.getValue());
        List<TblTaskStreamer> taskStreamerList = taskStreamerMapper.selectList(taskStreamerLambdaQueryWrapper);
        //收益总量
        BigDecimal incomeCount = new BigDecimal("0.00");
        //商品销量
        Integer saleCount = 0;
        if(!taskStreamerList.isEmpty()){
            for (TblTaskStreamer taskStreamer : taskStreamerList) {
                incomeCount = incomeCount.add(taskStreamer.getSettleMoney());
                saleCount +=taskStreamer.getCompleteNum();
            }
        }
        //目前默认收益和结算相同
        streamerSettleDataVo.setSettleCount(incomeCount);
        streamerSettleDataVo.setIncomeCount(incomeCount);
        streamerSettleDataVo.setSaleCount(saleCount);

        LambdaQueryWrapper<TblClientWithdrawCash> withdrawCashLambdaQueryWrapper = new LambdaQueryWrapper<>();
        withdrawCashLambdaQueryWrapper.eq(TblClientWithdrawCash::getClientId,admin.getClientId())
                .eq(TblClientWithdrawCash::getWithdrawStatus, WithdrawStatusEnum.DONE.getValue())
                .eq(TblClientWithdrawCash::getRoleId,9);
        List<TblClientWithdrawCash> withdrawCashList = withdrawCashMapper.selectList(withdrawCashLambdaQueryWrapper);
        BigDecimal withdrawCount = new BigDecimal("0.00");
        if(!withdrawCashList.isEmpty()){
            for (TblClientWithdrawCash withdrawCash : withdrawCashList) {
                withdrawCount = withdrawCount.add(withdrawCash.getWithdrawAmount());
            }
        }
        streamerSettleDataVo.setWithdrawCount(withdrawCount);
        return streamerSettleDataVo;
    }
}
