package com.ittime.linglingbo.modules.video.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteVideoMapper;
import com.ittime.linglingbo.modules.favorite.model.TblFavoriteVideo;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsMapper;
import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.video.convert.VideoInfoConvert;
import com.ittime.linglingbo.modules.video.mapper.TblVideoDaylogMapper;
import com.ittime.linglingbo.modules.video.mapper.TblVideoHotwordsMapper;
import com.ittime.linglingbo.modules.video.model.TblVideoDaylog;
import com.ittime.linglingbo.modules.video.model.TblVideoHotwords;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.modules.video.mapper.TblVideoInfoMapper;
import com.ittime.linglingbo.modules.video.model.param.VideoSearchParam;
import com.ittime.linglingbo.modules.video.model.vo.HotVideoVO;
import com.ittime.linglingbo.modules.video.model.vo.VideoInfoVo;
import com.ittime.linglingbo.modules.video.model.vo.VideoRankVO;
import com.ittime.linglingbo.modules.video.service.TblVideoInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-12-17
 */
@Service
public class TblVideoInfoServiceImpl extends ServiceImpl<TblVideoInfoMapper, TblVideoInfo> implements TblVideoInfoService {


    @Autowired
    private VideoInfoConvert videoInfoConvert;

    @Autowired
    private TblVideoHotwordsMapper videoHotwordsMapper;

    @Autowired
    private TblFavoriteVideoMapper favoriteVideoMapper;

    @Autowired
    private TblStreamerAppendMapper tblStreamerAppendMapper;

    @Autowired
    private TblGoodsMapper tblGoodsMapper;

    @Autowired
    private TblVideoDaylogMapper tblVideoDaylogMapper;


    @Override
    public IPage<VideoInfoVo> list(Integer pageSize, Integer pageNum, VideoSearchParam param, Long userId) {
        //分页对象
        Page<TblVideoInfo> page = new Page<>(pageNum, pageSize);
        //查找我的收藏视频ids
        List<Long> videoIds = favoriteVideoMapper.selectList(new LambdaQueryWrapper<TblFavoriteVideo>()
                .eq(TblFavoriteVideo::getAdminId, userId)).stream().map(TblFavoriteVideo::getVideoId).collect(Collectors.toList());

        List<Long> ids = new ArrayList<>();
        //防止关键字为空把热词表全部视频id都选中
        if(StrUtil.isNotEmpty(param.getKeyword())) {
            //获取包含类似热词的视频ids
            ids = videoHotwordsMapper.selectList(new LambdaQueryWrapper<TblVideoHotwords>()
                    .like(TblVideoHotwords::getVideoHotwords, param.getKeyword())).stream().map(TblVideoHotwords::getVideoId).collect(Collectors.toList());
        }
        //条件查询--热词或视频名称
        LambdaQueryWrapper<TblVideoInfo> queryWrapper = new LambdaQueryWrapper<>();
        if(ids.size() == 0){
            queryWrapper.like(StrUtil.isNotEmpty(param.getKeyword()), TblVideoInfo::getVideoName, param.getKeyword())
                    .in(TblVideoInfo::getVideoId, videoIds);
        }
        else{
            queryWrapper.like(StrUtil.isNotEmpty(param.getKeyword()), TblVideoInfo::getVideoName, param.getKeyword())
                    .or().in(StrUtil.isNotEmpty(param.getKeyword()), TblVideoInfo::getVideoId, ids)
                    .in(TblVideoInfo::getVideoId, videoIds);
        }
        //分页查询
        IPage<TblVideoInfo> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(videoInfo -> {
            VideoInfoVo videoInfoVo = videoInfoConvert.toVideoInfoListVo(videoInfo);
            //获取视频热词并注入
            List<String> hotWords = videoHotwordsMapper.selectList(new LambdaQueryWrapper<TblVideoHotwords>()
                    .eq(TblVideoHotwords::getVideoId, videoInfoVo.getVideoId())).stream().map(TblVideoHotwords::getVideoHotwords).collect(Collectors.toList());
            videoInfoVo.setHotWords(hotWords);
            // 获取主播名称和粉丝数量并注入
            String name = tblStreamerAppendMapper.selectById(videoInfo.getStreamerId()).getStreamerName();
            Long totalFans = tblStreamerAppendMapper.selectById(videoInfo.getStreamerId()).getTotalFans();
            videoInfoVo.setStreamerName(name);
            videoInfoVo.setTotalFans(totalFans);
            return videoInfoVo;
        });
    }

    @Override
    public IPage<HotVideoVO> searchList(Integer pageSize, Integer pageNum){
        //分页对象
        Page<TblVideoInfo> page = new Page<>(pageNum, pageSize);
        QueryWrapper<TblVideoInfo> wrapper = new QueryWrapper<>();
        //分页查询
        IPage<TblVideoInfo> iPage = baseMapper.selectPage(page, wrapper);
        return iPage.convert(videoInfo -> {
            //根据主播id查找主播的名字
            Long streamerId = videoInfo.getStreamerId();
            TblStreamerAppend streamer = tblStreamerAppendMapper.selectOne(new QueryWrapper<TblStreamerAppend>()
                    .eq("streamer_id", streamerId));
            HotVideoVO vo = videoInfoConvert.tohotVideoVO(videoInfo);
            vo.setStreamerName(streamer.getStreamerName());
            return vo;
        });
    }

    @Override
    public IPage<VideoRankVO> videoBrandRank(Integer pageSize, Integer pageNum) {
        // 根据现在的时间查符合条件的
        QueryWrapper<TblVideoDaylog> wrapper1 = new QueryWrapper<>();
        System.out.println(DateUtil.today());
        wrapper1.eq("log_date", DateUtil.today());
        List<TblVideoDaylog> daylogs = tblVideoDaylogMapper.selectList(wrapper1);


        //分页对象
        Page<TblVideoInfo> page = new Page<>(pageNum, pageSize);
        QueryWrapper<TblVideoInfo> wrapper = new QueryWrapper<>();
        //分页查询
        IPage<TblVideoInfo> iPage = baseMapper.selectPage(page, wrapper);

        return iPage.convert(videoInfo -> {
            //根据主播id查找主播的名字
            Long streamerId = videoInfo.getStreamerId();
            TblStreamerAppend streamer = tblStreamerAppendMapper.selectOne(new QueryWrapper<TblStreamerAppend>()
                    .eq("streamer_id", streamerId));
            VideoRankVO vo = videoInfoConvert.toVideoRankVO(videoInfo);
            vo.setStreamerName(streamer.getStreamerName());
            // 查询关联商品名字
            Long goodsId = videoInfo.getGoodsId();
            TblGoods goodsObj = tblGoodsMapper.selectById(goodsId);
            vo.setGoodsName(goodsObj.getGoodsName());
           // 查询24小时内的
            for (TblVideoDaylog daylog : daylogs) {
                if(daylog.getVideoId().longValue() == videoInfo.getVideoId().longValue()){
//                    if(vo.getLikes_add() == null){
//                        vo.setLikes_add(Long.valueOf(0));
//                    }
                    Long like_all = daylog.getVideoDayLikes() + vo.getLikes_add();
                    vo.setLikes_add(like_all);
                }
            }
            return vo;
        });

    }

    @Override
    public IPage<VideoRankVO> videoIndustryRank(Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public IPage<VideoRankVO> hotVideoRank(Integer pageSize, Integer pageNum) {
        return null;
    }


}
