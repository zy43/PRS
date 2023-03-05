package com.ittime.linglingbo.modules.owner.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ittime.linglingbo.modules.owner.model.TblOwnerAppend;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.owner.model.params.OwnerAppendParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-29
 */
public interface TblOwnerAppendService extends IService<TblOwnerAppend> {

    /**
     * 分页获取品牌列表
     *
     * @param pageSize 分页大小
     * @param pageNum  第几页
     * @param param    条件查询参数
     * @return
     */
    IPage<TblOwnerAppend> list(Integer pageSize, Integer pageNum, OwnerAppendParam param);
}
