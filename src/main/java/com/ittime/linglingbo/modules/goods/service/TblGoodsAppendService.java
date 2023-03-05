package com.ittime.linglingbo.modules.goods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.goods.model.TblGoodsAppend;
import com.ittime.linglingbo.modules.goods.model.param.GoodsAppendSearchParam;
import com.ittime.linglingbo.modules.goods.model.param.GoodsSearchParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsAppendVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
public interface TblGoodsAppendService extends IService<TblGoodsAppend> {

    /**
     * 分页获取商品列表
     *
     * @param pageSize 分页大小
     * @param pageNum  第几页
     * @param param    条件查询参数
     * @return
     */
    IPage<TblGoodsAppend> list(Integer pageSize, Integer pageNum, GoodsSearchParam param);

    /**
     * 商品收藏关键词搜索
     *
     * @param pageSize
     * @param pageNum
     * @param param
     * @param userId
     * @return
     */
    IPage<GoodsAppendVo> searchList(Integer pageSize, Integer pageNum, GoodsAppendSearchParam param, Long userId);
}
