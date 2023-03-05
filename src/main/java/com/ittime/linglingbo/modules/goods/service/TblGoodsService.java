package com.ittime.linglingbo.modules.goods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.goods.model.param.GoodsParam;
import com.ittime.linglingbo.modules.goods.model.param.PageQueryParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsDetailVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsListVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsRankVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblGoodsService extends IService<TblGoods> {

    /**
     * 根据条件进行商品分页查询
     */
    IPage<GoodsListVo> list(PageQueryParam param);

    /**
     * 添加商品
     *
     * @param goodsParam 商品信息
     * @param ownerId    品牌商id
     * @return
     */
    boolean create(GoodsParam goodsParam, Long ownerId);

    /**
     * 根据id更新商品信息
     *
     * @param goodsParam
     * @return
     */
    boolean updateGoods(GoodsParam goodsParam);

    /**
     * 根据id查找商品信息
     *
     * @param id
     * @return
     */
    GoodsDetailVo getGoods(Long id);

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    boolean deleteGoods(Long id);

    /**
     * 获得所有商品
     *
     * @return
     */
    List<GoodsDetailVo> listAll(String goodsName, String brandName, Long categoryId);

    IPage<GoodsRankVO> goodsRank(Integer pageSize, Integer pageNum);

}
