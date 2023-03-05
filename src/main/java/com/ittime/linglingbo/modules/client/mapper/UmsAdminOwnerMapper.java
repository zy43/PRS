package com.ittime.linglingbo.modules.client.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.modules.client.model.UmsAdminOwner;
import com.ittime.linglingbo.modules.ums.dto.UmsIncomeVO;
import com.ittime.linglingbo.modules.ums.dto.UmsWithdrawRecordVO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 * 品牌商/政府机构表 Mapper 接口
 * </p>
 *
 * @author Josh
 * @since 2022-09-28
 */
public interface UmsAdminOwnerMapper extends BaseMapper<UmsAdminOwner> {


    /**
     * 存款
     *
     * @param userName 用户名
     * @param amount   量
     * @return boolean
     */
    boolean deposit(String userName, BigDecimal amount);

    /**
     * 列出所有收入
     *
     * @return {@link List}<{@link UmsIncomeVO}>
     */
    List<UmsIncomeVO> incomeListAll();

    /**
     * 收入列表
     *
     * @param pageSize 页面大小
     * @param offSet   从组
     * @return {@link List}<{@link UmsIncomeVO}>
     */
    List<UmsIncomeVO> incomeList(Integer pageSize, Integer offSet, String ownerName);

    /**
     * 收入总计数量
     *
     * @return {@link Long}
     */
    Long incomeTotalCount(String ownerName);

    /**
     * 提取记录所有者
     * 品牌商提取记录
     *
     * @param personName 人名字
     * @return {@link List}<{@link UmsWithdrawRecordVO}>
     */
    List<UmsWithdrawRecordVO> withdrawRecordOwner(Integer pageSize, Integer offSet, String personName);

    /**
     * 提取记录等浮电缆
     * 播主提取记录
     *
     * @param personName 人名字
     * @return {@link List}<{@link UmsWithdrawRecordVO}>
     */
    List<UmsWithdrawRecordVO> withdrawRecordStreamer(Integer pageSize, Integer offSet, String personName);

    boolean cutDown(Long clientId, BigDecimal withdrawAmount);

    BigDecimal getAccountBalance(Long clientId);

    /**
     * 品牌商提现总计数量
     *
     * @param personName 人名字
     * @return {@link Long}
     */
    Long withdrawOwnerTotalCount(String personName);

    /**
     * 播主提现总记录数
     *
     * @param personName 人名字
     * @return {@link Long}
     */
    Long withdrawStreamerTotalCount(String personName);
}
