package com.ittime.linglingbo.modules.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.common.component.IdGenerator;
import com.ittime.linglingbo.modules.goods.convert.GoodsAppendConvert;
import com.ittime.linglingbo.modules.goods.convert.GoodsConvert;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsAppendMapper;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsMapper;
import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.goods.model.TblGoodsAppend;
import com.ittime.linglingbo.modules.goods.model.param.GoodsParam;
import com.ittime.linglingbo.modules.goods.model.param.PageQueryParam;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsDetailVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsListVo;
import com.ittime.linglingbo.modules.goods.model.vo.GoodsRankVO;
import com.ittime.linglingbo.modules.goods.service.TblGoodsService;
import com.ittime.linglingbo.modules.minio.service.TblImageService;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.task.mapper.TblTaskGoodsMapper;
import com.ittime.linglingbo.modules.task.mapper.TblTaskStreamerMapper;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.video.model.TblVideoDaylog;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.modules.video.model.vo.VideoRankVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblGoodsServiceImpl extends ServiceImpl<TblGoodsMapper, TblGoods> implements TblGoodsService {

    @Autowired
    private GoodsConvert goodsConvert;

    @Autowired
    private GoodsAppendConvert goodsAppendConvert;

    @Autowired
    private TblTaskGoodsMapper taskGoodsMapper;

    @Autowired
    private TblTaskStreamerMapper taskStreamerMapper;

    @Autowired
    private TblGoodsAppendMapper tblGoodsAppendMapper;

    @Autowired
    private TblImageService tblImageService;
    @Override
    public IPage<GoodsListVo> list(PageQueryParam param) {

        // 分页对象
        Page<TblGoods> page = new Page<>(param.getPageNum(), param.getPageSize());
        // 条件查询
        LambdaQueryWrapper<TblGoods> queryWrapper = new LambdaQueryWrapper<>();
        // 商品名字
        String goodsName = param.getGoodsName();
        queryWrapper.like(StrUtil.isNotBlank(goodsName), TblGoods::getGoodsName, goodsName);
        // 商品品牌
        String brandName = param.getBrandName();
        queryWrapper.eq(StrUtil.isNotBlank(brandName), TblGoods::getGoodsBrand, brandName);
        // 商品分类
        Long categoryId = param.getCategoryId();
        queryWrapper.eq(categoryId != null, TblGoods::getCategoryId, categoryId);
        //Goods对象
        IPage<TblGoods> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象
        IPage<GoodsListVo> voIPage = iPage.convert(tblGoods -> {
            GoodsListVo vo = goodsConvert.toGoodsListVo(tblGoods);
            return vo;
        });

        List<GoodsListVo> goodsListVos = voIPage.getRecords();
        if (goodsListVos.size() != 0) {
            //商品关联任务数量
            for (GoodsListVo goodsListVo : goodsListVos) {
                goodsListVo.setRelatedStreamerCount(0L);
                goodsListVo.setRelatedTaskCount(0L);

                QueryWrapper<TblTaskGoods> taskGoodsQueryWrapper1 = new QueryWrapper<>();
                taskGoodsQueryWrapper1.select("DISTINCT task_id").lambda().eq(TblTaskGoods::getGoodsId, goodsListVo.getId());

                Long relatedTaskCount = taskGoodsMapper.selectCount(taskGoodsQueryWrapper1);
                goodsListVo.setRelatedTaskCount(relatedTaskCount);
                //商品关联主播数量
                if (relatedTaskCount != 0) {

                    LambdaQueryWrapper<TblTaskGoods> taskGoodsQueryWrapper2 = new LambdaQueryWrapper<>();
                    taskGoodsQueryWrapper2.eq(TblTaskGoods::getGoodsId, goodsListVo.getId());
                    List<TblTaskGoods> tblTaskGoods = taskGoodsMapper.selectList(taskGoodsQueryWrapper2);

                    List<Long> taskIdList = tblTaskGoods.stream().map((taskGoods) -> taskGoods.getTaskId()).collect(Collectors.toList());

                    QueryWrapper<TblTaskStreamer> taskStreamerQueryWrapper = new QueryWrapper<>();
                    taskStreamerQueryWrapper.select("DISTINCT streamer_id").lambda().in(TblTaskStreamer::getTaskId, taskIdList);
                    Long relatedStreamerCount = taskStreamerMapper.selectCount(taskStreamerQueryWrapper);
                    goodsListVo.setRelatedStreamerCount(relatedStreamerCount);
                }
            }
        }

        return voIPage;
    }

    @Override
    public boolean create(GoodsParam goodsParam, Long ownerId) {

        TblGoods goods = goodsConvert.toEntity(goodsParam);
        goods.setOwnerId(ownerId);

        Long imageId = IdGenerator.generateId();
        tblImageService.upload(goodsParam.getFile(),imageId);
        goods.setImageId(imageId);
        return save(goods);
    }

    @Override
    public boolean updateGoods(GoodsParam goodsParam) {
        TblGoods goods = goodsConvert.toEntity(goodsParam);
        return updateById(goods);
    }

    @Override
    public GoodsDetailVo getGoods(Long id) {
        TblGoods goods = getById(id);
        GoodsDetailVo goodsDetailVo = goodsConvert.toGoodsDetailVo(goods);
        return goodsDetailVo;
    }

    @Override
    public boolean deleteGoods(Long id) {
        return removeById(id);
    }

    @Override
    public List<GoodsDetailVo> listAll(String goodsName, String brandName, Long categoryId) {
        LambdaQueryWrapper<TblGoods> queryWrapper = new LambdaQueryWrapper<>();
        //商品名
        queryWrapper.like(StrUtil.isNotBlank(goodsName), TblGoods::getGoodsName, goodsName);
        //品牌名
        queryWrapper.eq(StrUtil.isNotBlank(brandName), TblGoods::getGoodsBrand, brandName);
        //分类
        queryWrapper.eq(categoryId != null, TblGoods::getCategoryId, categoryId);
        List<TblGoods> tblGoods = baseMapper.selectList(queryWrapper);
        List<GoodsDetailVo> goodsDetailVoList = tblGoods.stream().map((goods) -> {
            GoodsDetailVo goodsDetailVo = goodsConvert.toGoodsDetailVo(goods);
            return goodsDetailVo;
        }).collect(Collectors.toList());

        return goodsDetailVoList;
    }

    @Override
    public IPage<GoodsRankVO> goodsRank(Integer pageSize, Integer pageNum) {
        //分页对象
        Page<TblGoodsAppend> page = new Page<>(pageNum, pageSize);
        QueryWrapper<TblGoodsAppend> wrapper = new QueryWrapper<>();
        //分页查询
        IPage<TblGoodsAppend> iPage = tblGoodsAppendMapper.selectPage(page, wrapper);

        return iPage.convert(goodsAppend -> {
            GoodsRankVO vo = goodsAppendConvert.toGoodsRankVO(goodsAppend);
            return vo;
        });

    }


    public void judgeEmpty() {

    }

}
