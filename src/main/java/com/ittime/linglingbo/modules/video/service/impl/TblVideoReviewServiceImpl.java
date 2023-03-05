package com.ittime.linglingbo.modules.video.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.modules.video.convert.VideoAnalysisConvert;
import com.ittime.linglingbo.modules.video.model.TblVideoReview;
import com.ittime.linglingbo.modules.video.mapper.TblVideoReviewMapper;
import com.ittime.linglingbo.modules.video.model.param.VideoReviewParam;
import com.ittime.linglingbo.modules.video.model.vo.VideoReviewVo;
import com.ittime.linglingbo.modules.video.service.TblVideoReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Service
public class TblVideoReviewServiceImpl extends ServiceImpl<TblVideoReviewMapper, TblVideoReview> implements TblVideoReviewService {

    @Autowired
    private VideoAnalysisConvert videoAnalysisConvert;


    @Override
    public IPage<VideoReviewVo> searchList(Integer pageSize, Integer pageNum, VideoReviewParam param) {
        //分页对象
        Page<TblVideoReview> page = new Page<>(pageNum, pageSize);

        //条件查询--评论分类、价格相关
        LambdaQueryWrapper<TblVideoReview> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(param.getClassification() != null, TblVideoReview::getClassification, param.getClassification())
                .eq(param.getPriceRelated() != null, TblVideoReview::getPriceRelated, param.getPriceRelated())
                .eq(TblVideoReview::getVideoId, param.getVideoId());

        //分页查询
        IPage<TblVideoReview> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(videoReview -> videoAnalysisConvert.toVideoReviewVo(videoReview));

    }
}
