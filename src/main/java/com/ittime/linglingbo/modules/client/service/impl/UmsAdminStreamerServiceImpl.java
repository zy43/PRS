package com.ittime.linglingbo.modules.client.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.base.MPJBaseServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.ittime.linglingbo.common.entity.BaseEntity;
import com.ittime.linglingbo.modules.client.convert.StreamerConvert;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.client.model.param.StreamerCertificateParam;
import com.ittime.linglingbo.modules.client.model.vo.StreamerListVO;
import com.ittime.linglingbo.modules.client.service.UmsAdminStreamerService;
import com.ittime.linglingbo.modules.fans.mapper.*;
import com.ittime.linglingbo.modules.fans.model.*;
import com.ittime.linglingbo.modules.goods.mapper.TblGoodsRelateVideoMapper;
import com.ittime.linglingbo.modules.goods.model.TblCategoryGoods;
import com.ittime.linglingbo.modules.goods.model.TblGoods;
import com.ittime.linglingbo.modules.goods.model.TblGoodsRelateStreamer;
import com.ittime.linglingbo.modules.minio.mapper.TblImageMapper;
import com.ittime.linglingbo.modules.minio.service.TblImageService;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerDaylogMapper;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerDaylog;
import com.ittime.linglingbo.modules.task.model.TblTask;
import com.ittime.linglingbo.modules.task.model.TblTaskGoods;
import com.ittime.linglingbo.modules.task.model.TblTaskStreamer;
import com.ittime.linglingbo.modules.task.model.vo.TaskListStreamerVo;
import com.ittime.linglingbo.modules.ums.dto.*;
import com.ittime.linglingbo.modules.video.mapper.TblVideoHotwordsMapper;
import com.ittime.linglingbo.modules.video.mapper.TblVideoInfoMapper;
import com.ittime.linglingbo.modules.video.model.TblVideoHotwords;
import com.ittime.linglingbo.modules.video.model.TblVideoInfo;
import com.ittime.linglingbo.security.util.DateUtil;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 播主/MCN 表 服务实现类
 */
@Service
public class UmsAdminStreamerServiceImpl extends MPJBaseServiceImpl<UmsAdminStreamerMapper, UmsAdminStreamer> implements UmsAdminStreamerService {

    @Autowired
    private StreamerConvert streamerConvert;

    @Autowired
    private TblFansSexMapper tblFansSexMapper;

    @Autowired
    private TblStreamerDaylogMapper tblStreamerDaylogMapper;

    @Autowired
    private TblFansRegionMapper tblFansRegionMapper;

    @Autowired
    private TblFansAgeMapper tblFansAgeMapper;

    @Autowired
    private TblFansHobbyMapper tblFansHobbyMapper;

    @Autowired
    private TblFansActivetimeMapper tblFansActivetimeMapper;

    @Autowired
    private TblVideoInfoMapper tblVideoInfoMapper;

    @Autowired
    private TblVideoHotwordsMapper tblVideoHotwordsMapper;

    @Autowired
    private TblGoodsRelateVideoMapper tblGoodsRelateVideoMapper;

    @Autowired
    private TblStreamerAppendMapper tblStreamerAppendMapper;

    @Autowired
    private TblImageMapper tblImageMapper;


    /**
     * 获取开始日期
     *
     * @param days 天
     * @return {@link String}
     */
    public String getStartDay(Integer days) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days * -1);

        return format.format(c.getTime());
    }


    @Override
    public IPage<StreamerListVO> list(Integer pageSize, Integer pageNum, String hostName, String industry, String goodsCategory) {

        // 联表查询
        MPJLambdaWrapper<UmsAdminStreamer> wrapper = new MPJLambdaWrapper<UmsAdminStreamer>()
                .selectAll(UmsAdminStreamer.class)
                .like(StrUtil.isNotEmpty(hostName), UmsAdminStreamer::getHostName, hostName)
                .eq(StrUtil.isNotEmpty(industry), UmsAdminStreamer::getIndustry, industry);

        if (StrUtil.isNotEmpty(goodsCategory)) {
            wrapper.leftJoin(TblGoodsRelateStreamer.class, TblGoodsRelateStreamer::getStreamerId, UmsAdminStreamer::getId)
                    .leftJoin(TblGoods.class, TblGoods::getId, TblGoodsRelateStreamer::getGoodsId)
                    .leftJoin(TblCategoryGoods.class, TblCategoryGoods::getId, TblGoods::getCategoryId)
                    .eq(TblCategoryGoods::getCategoryName, goodsCategory);
        }


        // task 实体对象
        final IPage<UmsAdminStreamer> iPage = baseMapper.selectJoinPage(new Page<>(pageNum, pageSize), UmsAdminStreamer.class, wrapper);
        // 转成 VO
        return iPage.convert(streamer -> {
            StreamerListVO streamerListVO = streamerConvert.toStreamerListVO(streamer);
            return streamerListVO;
        });



//        //分页对象
//        Page<UmsAdminStreamer> page = new Page<>(pageNum, pageSize);
//        //条件查询
//        LambdaQueryWrapper<UmsAdminStreamer> queryWrapper = new LambdaQueryWrapper<>();
//
//        IPage<UmsAdminStreamer> iPage = baseMapper.selectPage(page, queryWrapper);
//        //转为Vo对象返回
//        return iPage.convert(umsAdminStreamer -> {
//            StreamerListVO streamerListVO = streamerConvert.toStreamerListVO(umsAdminStreamer);
//            return streamerListVO;
//        });

    }

    @Override
    public boolean certificate(StreamerCertificateParam param, Long streamerId) {
        try {
            // 预留逻辑：判断身份证号和姓名对的上
            {
                String idCard = param.getIdCard();
                String realName = param.getRealName();
                System.out.println("调用身份验证接口...");
            }
            // 身份符合 提交审核
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("id", streamerId);
            updateWrapper.set("certification", "审核中");
            baseMapper.update(null, updateWrapper);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public UmsGeneralVO collectGeneralData(Long id, Integer days) {

        UmsGeneralVO res = new UmsGeneralVO();

        // 获取开始时间点的日期
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, days * -1);
        String fromDay = format.format(c.getTime());

        //获取最新作品 粉丝增量 新增转赞评
        LambdaQueryWrapper<TblStreamerDaylog> streamerWrapper = new LambdaQueryWrapper<>();
        streamerWrapper.eq(id != null, TblStreamerDaylog::getStreamerId, id);
        streamerWrapper.ge(StrUtil.isNotBlank(fromDay), TblStreamerDaylog::getLogDate, fromDay);
        List<TblStreamerDaylog> dayLogs = tblStreamerDaylogMapper.selectList(streamerWrapper);

        Long fansAdd = 0L, likes = 0L, comments = 0L, shares = 0L, videoCount = 0L;
        List<Long> fansAddList = new ArrayList<>();
        List<Long> likesAddList = new ArrayList<>();
        List<Long> commentsAddList = new ArrayList<>();
        List<Long> lastTenVideoLikesList = new ArrayList<>();
        List<Long> lastTenVideoCommentsList = new ArrayList<>();
        List<Date> lastTenVideoDateList = new ArrayList<>();

        for (TblStreamerDaylog dayLog : dayLogs) {

            // 基础数据
            fansAdd += dayLog.getDayFans();
            likes += dayLog.getDayLikes();
            comments += dayLog.getDayComments();
            shares += dayLog.getDayShares();
            videoCount += dayLog.getDayVideos();

            // 图表数据
            fansAddList.add(dayLog.getDayFans());
            likesAddList.add(dayLog.getDayLikes());
            commentsAddList.add(dayLog.getDayComments());
        }
        res.setFansAdd(fansAdd);
        res.setNewProduct(videoCount);
        res.setCommentsAdd(comments);
        res.setLikesAdd(likes);
        res.setSharesAdd(shares);
        res.setCommentsAddList(commentsAddList);
        res.setLikesAddList(likesAddList);
        res.setFansAddList(fansAddList);

        //近十个视频点赞评论
        LambdaQueryWrapper<TblVideoInfo> videoWrapper = new LambdaQueryWrapper<>();
        videoWrapper.eq(id != null, TblVideoInfo::getStreamerId, id)
                .orderByDesc(TblVideoInfo::getReleaseTime).last("limit 10");
        List<TblVideoInfo> videoInfos = tblVideoInfoMapper.selectList(videoWrapper);

        for (TblVideoInfo info : videoInfos) {
            lastTenVideoLikesList.add(0,info.getLikes());
            lastTenVideoCommentsList.add(0,info.getComments());
            lastTenVideoDateList.add(0, info.getReleaseTime());
        }
        res.setLastTenVideoCommentsList(lastTenVideoCommentsList);
        res.setLastTenVideoLikesList(lastTenVideoLikesList);
        res.setLastTenVideoDateList(lastTenVideoDateList);

        return res;
    }

    @Override
    public UmsFansFeatureVO collectFansData(Long id) {

        UmsFansFeatureVO res = new UmsFansFeatureVO();

        // 性别分布数据
        LambdaQueryWrapper<TblFansSex> fansSexWrapper = new LambdaQueryWrapper<>();
        fansSexWrapper.eq(id != null, TblFansSex::getStreamerId, id);
        TblFansSex sex = tblFansSexMapper.selectOne(fansSexWrapper);
        if(sex != null){
            res.setMaleProportion(sex.getMaleProportion());
        }

        // 地区分布数据
        LambdaQueryWrapper<TblFansRegion> regionWrapper = new LambdaQueryWrapper<>();
        regionWrapper.eq(id != null, TblFansRegion::getStreamerId, id);
        List<TblFansRegion> regions = tblFansRegionMapper.selectList(regionWrapper);
        List<UmsFansRegion> resRegions = new ArrayList<>();
        for (TblFansRegion region : regions) {
            UmsFansRegion tmp = new UmsFansRegion();
            tmp.setProvince(region.getFansProvince());
            tmp.setRate(region.getProportion());
            resRegions.add(tmp);
        }
        if (resRegions != null) {
            res.setRegionDistribution(resRegions);
        }

        // 年龄分布
        TblFansAge age = tblFansAgeMapper.selectAge(id);
        res.setAgeDistribution(age);

        // 爱好分布
        LambdaQueryWrapper<TblFansHobby> hobbyWrapper = new LambdaQueryWrapper<>();
        hobbyWrapper.eq(id != null, TblFansHobby::getStreamerId, id);
        List<TblFansHobby> hobbies = tblFansHobbyMapper.selectList(hobbyWrapper);
        List<UmsFansHobbyVO> resHobbies = new ArrayList<>();
        for (TblFansHobby hobby : hobbies) {
            UmsFansHobbyVO tmp = new UmsFansHobbyVO();
            tmp.setFansHobby(hobby.getFansHobby());
            tmp.setProportion(hobby.getProportion());
            resHobbies.add(tmp);
        }
        Collections.sort(resHobbies);
        res.setHobbyDistribution(resHobbies);

        // 活跃时间分布
        LambdaQueryWrapper<TblFansActivetime> activeWrapper = new LambdaQueryWrapper<>();
        activeWrapper.eq(id != null, TblFansActivetime::getStreamerId, id);
        List<TblFansActivetime> activeTimes = tblFansActivetimeMapper.selectList(activeWrapper);
        List<UmsFansActiveTime> resActiveTime = new ArrayList<>();
        for (TblFansActivetime activeTime : activeTimes) {
            UmsFansActiveTime tmp = new UmsFansActiveTime();
            tmp.setActiveTime(activeTime.getActiveTime());
            tmp.setProportion(activeTime.getProportion());

            resActiveTime.add(tmp);
        }
        res.setTimeDistribution(resActiveTime);
        return res;
    }

    @Override
    public UmsVideoGeneralVO collectVideoGeneralData(Long id, Integer days) {

        UmsVideoGeneralVO res = new UmsVideoGeneralVO();

        String fromDay = getStartDay(days);

        LambdaQueryWrapper<TblStreamerDaylog> videoWrapper = new LambdaQueryWrapper<>();
        videoWrapper.eq(id != null, TblStreamerDaylog::getStreamerId, id);
        videoWrapper.ge(TblStreamerDaylog::getLogDate, fromDay);
        List<TblStreamerDaylog> dayLogs = tblStreamerDaylogMapper.selectList(videoWrapper);
        Long num = 0L, likes = 0L, comments = 0L, shares = 0L;
        for (TblStreamerDaylog dayLog : dayLogs) {
            num += dayLog.getDayVideos();
            likes += dayLog.getDayLikes();
            comments += dayLog.getDayComments();
            shares += dayLog.getDayShares();
        }
        res.setVideoNum(num);
        res.setAvgComments(comments / num);
        res.setAvgLikes(likes / num);
        res.setAvgShares(shares / num);
        return res;
    }

    @Override
    public IPage<UmsVideoDetailVO> collectVideoDetailData(String fromDay, String endDay,
                                                          String keyWord, Integer pageSize, Integer pageNum, Long id) throws ParseException {
        //分页对象
        Page<TblVideoInfo> page = new Page<>(pageNum, pageSize);
        //条件查询
        LambdaQueryWrapper<TblVideoInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(id != null, TblVideoInfo::getStreamerId, id);
        queryWrapper.ge(fromDay != null, TblVideoInfo::getReleaseTime, fromDay);
        queryWrapper.le(endDay != null, TblVideoInfo::getReleaseTime, DateUtil.delayOneDay(endDay));
        queryWrapper.like(keyWord != null, TblVideoInfo::getVideoName, keyWord);

        IPage<TblVideoInfo> iPage = tblVideoInfoMapper.selectPage(page, queryWrapper);
        return iPage.convert(tblVideoInfo -> {
            UmsVideoDetailVO res = new UmsVideoDetailVO();
            BeanUtils.copyProperties(tblVideoInfo, res);
            return res;
        });
    }

    @Override
    public List<UmsGoodsVO> getGoodsInfo(Long streamerId, Integer days, String keyWord, Integer pageSize, Integer pageNum) {

        String fromDay = getStartDay(days);
        Integer offset = (pageNum - 1) * pageSize;
        return tblGoodsRelateVideoMapper.getGoodsVideoInfo(streamerId, fromDay, keyWord, offset, pageSize);
    }

    @Override
    public Long getGoodsCount(Long id, Integer days, String keyWord) {

        String fromDay = getStartDay(days);
        return tblGoodsRelateVideoMapper.getGoodsVideoCount(id, fromDay, keyWord);
    }

    @Override
    public IPage<UmsIndustryRankVO> industryRank(String keyWord, String industry, Integer pageNum, Integer pageSize) throws ParseException {
        //分页对象
        Page<TblStreamerAppend> page = new Page<>(pageNum, pageSize);
        //条件查询
        LambdaQueryWrapper<TblStreamerAppend> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(industry != null, TblStreamerAppend::getIndustry, industry);
        queryWrapper.like(StrUtil.isNotBlank(industry), TblStreamerAppend::getIndustry, industry);
        queryWrapper.like(StrUtil.isNotBlank(keyWord), TblStreamerAppend::getStreamerName, keyWord);

        IPage<TblStreamerAppend> iPage = tblStreamerAppendMapper.selectPage(page, queryWrapper);

        return iPage.convert(tblStreamerAppend -> {
            UmsIndustryRankVO res = new UmsIndustryRankVO();
            res.setAvgComments(tblStreamerAppend.getTotalComments() / tblStreamerAppend.getTotalVideos());
            res.setAvgLikes(tblStreamerAppend.getTotalLikes() / tblStreamerAppend.getTotalVideos());
            res.setAvgShares(tblStreamerAppend.getTotalShares() / tblStreamerAppend.getTotalVideos());
            res.setTotalFans(tblStreamerAppend.getTotalFans());
            res.setStreamerId(tblStreamerAppend.getStreamerId());
            res.setStreamerName(tblStreamerAppend.getStreamerName());
            return res;
        });
    }

    @Override
    public List<UmsFansRiseRankVO> fansRiseRank(Integer days, String keyWord, String fromDay, String endDay, String industry, Integer pageNum, Integer pageSize) {
        Integer offset = (pageNum - 1) * pageSize;
        if (days != 0) {
            fromDay = getStartDay(days);
        }
        return tblStreamerDaylogMapper.fansRiseRank(keyWord, fromDay, endDay, industry, offset, pageSize);
    }

    @Override
    public Long getFansTotalCount(Integer days, String keyWord, String fromDay, String endDay, String industry) {
        if (days != 0) {
            fromDay = getStartDay(days);
        }
        return tblStreamerDaylogMapper.totalCount(keyWord, fromDay, endDay, industry);
    }

    @Override
    public List<UmsIndustryRankVO> regionRank(String keyWord, String province, String city, Integer pageNum, Integer pageSize) {
        Integer offset = (pageNum - 1) * pageSize;
        return tblStreamerAppendMapper.regionRank(keyWord, province, city, offset, pageSize);
    }

    @Override
    public Long getRegionTotalCount(String keyWord, String province, String city) {
        return tblStreamerAppendMapper.regionCount(keyWord, province, city);
    }

    @Override
    public IPage<UmsStarChartVo> getStarChartRank(Integer pageSize, Integer pageNum) {
        Page<TblStreamerAppend> page = new Page<>(pageNum, pageSize);
        LambdaQueryWrapper<TblStreamerAppend> streamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        streamerAppendLambdaQueryWrapper.orderByDesc(TblStreamerAppend::getStarIndex);
        IPage<TblStreamerAppend> iPage = tblStreamerAppendMapper.selectPage(page, streamerAppendLambdaQueryWrapper);
        return iPage.convert((streamerAppend) -> streamerConvert.toStarChartVo(streamerAppend));
    }

    @Override
    public List<StreamerCompareSearchVo> getStreamerCompareSearch(String key) {

        LambdaQueryWrapper<TblStreamerAppend> streamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();

        if (NumberUtils.isParsable(key)) {
            //输入为抖音号
            Long streamerId = NumberUtils.createLong(key);
            streamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getStreamerId, streamerId);
        } else {
            //输入为播主名称
            streamerAppendLambdaQueryWrapper.like(TblStreamerAppend::getStreamerName, key);
        }
        List<TblStreamerAppend> streamerAppendList = tblStreamerAppendMapper.selectList(streamerAppendLambdaQueryWrapper);
        List<StreamerCompareSearchVo> compareSearchVoArrayList = new ArrayList<>();
        for (TblStreamerAppend streamerAppend : streamerAppendList) {
            Long imageId = baseMapper.getImageId(streamerAppend.getStreamerId());
            String imageUrl = tblImageMapper.getImageUrlById(imageId);
            StreamerCompareSearchVo streamerCompareSearchVo = streamerConvert.toStreamerCompareSearchVO(streamerAppend);
            streamerCompareSearchVo.setImageUrl(imageUrl);
            compareSearchVoArrayList.add(streamerCompareSearchVo);
        }

        return compareSearchVoArrayList;
    }

    @Override
    public StreamerCompareDetailVo getStreamerCompareDetail(Long id) {
        LambdaQueryWrapper<TblStreamerAppend> streamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        streamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getStreamerId, id);

        TblStreamerAppend tblStreamerAppend = tblStreamerAppendMapper.selectOne(streamerAppendLambdaQueryWrapper);
        StreamerCompareDetailVo streamerCompareDetailVo = new StreamerCompareDetailVo();
        //赋值
        BeanUtils.copyProperties(tblStreamerAppend, streamerCompareDetailVo);

        Long imageId = baseMapper.getImageId(id);
        String imageUrl = tblImageMapper.getImageUrlById(imageId);
        streamerCompareDetailVo.setImageUrl(imageUrl);

        LambdaQueryWrapper<TblVideoInfo> videoInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        videoInfoLambdaQueryWrapper.eq(TblVideoInfo::getStreamerId, id);

        List<TblVideoInfo> videoInfoList = tblVideoInfoMapper.selectList(videoInfoLambdaQueryWrapper);
        Set<String> fansHotWords = null;

        if (!videoInfoList.isEmpty()) {
            Long count = tblVideoInfoMapper.selectCount(videoInfoLambdaQueryWrapper);
            //集均点赞
            Long aveLikes = 0L;
            //集均评论
            Long aveComments = 0L;
            //集均分享
            Long aveShares = 0L;

            for (TblVideoInfo videoInfo : videoInfoList) {
                aveLikes += videoInfo.getLikes();
                aveShares += videoInfo.getShares();
                aveComments += videoInfo.getComments();
            }
            if (aveLikes == 0L) {
                streamerCompareDetailVo.setAverageLikes(0L);
            } else streamerCompareDetailVo.setAverageLikes(aveLikes / count);
            if (aveComments == 0L) {
                streamerCompareDetailVo.setAverageComments(0L);
            } else streamerCompareDetailVo.setAverageComments(aveComments / count);
            if (aveShares == 0L) {
                streamerCompareDetailVo.setAverageShares(0L);
            } else streamerCompareDetailVo.setAverageShares(aveShares / count);

            //粉丝评论热词
            List<Long> videoIdList = videoInfoList.stream().map((videoInfo) -> videoInfo.getVideoId()).collect(Collectors.toList());
            LambdaQueryWrapper<TblVideoHotwords> tblVideoHotwordsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            tblVideoHotwordsLambdaQueryWrapper.in(TblVideoHotwords::getVideoId, videoIdList);
            List<TblVideoHotwords> tblVideoHotwords = tblVideoHotwordsMapper.selectList(tblVideoHotwordsLambdaQueryWrapper);
            fansHotWords = tblVideoHotwords.stream().map((videoHotwords) -> videoHotwords.getVideoHotwords()).collect(Collectors.toSet());
        }
        streamerCompareDetailVo.setFansHotWords(fansHotWords);

        //性别比例
        LambdaQueryWrapper<TblFansSex> sexLambdaQueryWrapper = new LambdaQueryWrapper<>();
        sexLambdaQueryWrapper.eq(TblFansSex::getStreamerId, id);
        TblFansSex tblFansSex = tblFansSexMapper.selectOne(sexLambdaQueryWrapper);

        streamerCompareDetailVo.setMaleProportion(tblFansSex.getMaleProportion());
        streamerCompareDetailVo.setFemaleProportion(tblFansSex.getFemaleProportion());
        //粉丝年龄分布
        TblFansAge tblFansAge = tblFansAgeMapper.selectAge(id);
        streamerCompareDetailVo.setGroup617(tblFansAge.getGroup617());
        streamerCompareDetailVo.setGroup1824(tblFansAge.getGroup1824());
        streamerCompareDetailVo.setGroup2530(tblFansAge.getGroup2530());
        //粉丝地区
        LambdaQueryWrapper<TblFansRegion> tblFansRegionLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tblFansRegionLambdaQueryWrapper.eq(TblFansRegion::getStreamerId, id).orderByDesc(TblFansRegion::getProportion);
        List<TblFansRegion> fansRegionList = tblFansRegionMapper.selectList(tblFansRegionLambdaQueryWrapper);

        streamerCompareDetailVo.setFansRegions(fansRegionList);


        streamerCompareDetailVo.setShoppingCartOpen("已开通");

        LambdaQueryWrapper<TblVideoInfo> elecVideoQueryWrapper = new LambdaQueryWrapper<>();
        elecVideoQueryWrapper.eq(TblVideoInfo::getStreamerId, id).gt(TblVideoInfo::getIsRelatedGoods, 0);
        List<TblVideoInfo> elecVideoInfoList = tblVideoInfoMapper.selectList(elecVideoQueryWrapper);
        if (!elecVideoInfoList.isEmpty()) {

            Long count = tblVideoInfoMapper.selectCount(elecVideoQueryWrapper);
            streamerCompareDetailVo.setVideoNum(count.intValue());

            //电商集均点赞
            Long elecAveLikes = 0L;
            //电商集均评论
            Long elecAveComments = 0L;
            //电商集均分享
            Long elecAveShares = 0L;

            //电商橱窗商品数
            Integer goodsNum = 0;

            for (TblVideoInfo videoInfo : elecVideoInfoList) {
                elecAveLikes += videoInfo.getLikes();
                elecAveComments += videoInfo.getShares();
                elecAveShares += videoInfo.getComments();
                goodsNum += videoInfo.getIsRelatedGoods();
            }
            if (elecAveLikes == 0L) {
                streamerCompareDetailVo.setElecAverageLikes(0L);
            } else streamerCompareDetailVo.setElecAverageLikes(elecAveLikes / count);
            if (elecAveComments == 0L) {
                streamerCompareDetailVo.setElecAverageComments(0L);
            } else streamerCompareDetailVo.setElecAverageComments(elecAveComments / count);
            if (elecAveShares == 0L) {
                streamerCompareDetailVo.setElecAverageShares(0L);
            } else streamerCompareDetailVo.setElecAverageShares(elecAveShares / count);
            streamerCompareDetailVo.setGoodsNum(goodsNum);
        }
        streamerCompareDetailVo.setSaleRank("未上榜");

        return streamerCompareDetailVo;
    }

    @Override
    public IPage<MCNListVo> getMCNList(MCNListParam mcnListParam, Integer pageSize, Integer pageNum) {
        //获得MCNid
        LambdaQueryWrapper<UmsAdminStreamer> streamerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        streamerLambdaQueryWrapper.eq(UmsAdminStreamer::getBelongTo, -1);
        List<UmsAdminStreamer> adminStreamerList = baseMapper.selectList(streamerLambdaQueryWrapper);
        if (adminStreamerList.isEmpty()) {
            return new Page<>(pageNum, pageSize);
        }
        List<Long> streamerIdList = adminStreamerList.stream().map((streamer) -> streamer.getId()).collect(Collectors.toList());
        //获得MCN信息
        LambdaQueryWrapper<TblStreamerAppend> appendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        appendLambdaQueryWrapper.in(TblStreamerAppend::getStreamerId, streamerIdList);
        if (mcnListParam != null) {
            appendLambdaQueryWrapper
                    .gt(mcnListParam.getFansBottom() != null, TblStreamerAppend::getTotalFans, mcnListParam.getSignBottom())
                    .lt(mcnListParam.getFansTop() != null, TblStreamerAppend::getTotalFans, mcnListParam.getFansTop())
                    .gt(mcnListParam.getSignBottom() != null, TblStreamerAppend::getSignNum, mcnListParam.getSignBottom())
                    .lt(mcnListParam.getSignTop() != null, TblStreamerAppend::getSignNum, mcnListParam.getSignTop())
                    .eq(mcnListParam.getProvince() != null, TblStreamerAppend::getProvince, mcnListParam.getProvince())
                    .eq(mcnListParam.getCity() != null, TblStreamerAppend::getCity, mcnListParam.getCity());
        }
        Page<TblStreamerAppend> page = new Page<>(pageNum, pageSize);
        IPage<TblStreamerAppend> iPage = tblStreamerAppendMapper.selectPage(page, appendLambdaQueryWrapper);
        return iPage.convert((tblStreamerAppend) -> {
            MCNListVo mcnListVo = streamerConvert.toMCNListVo(tblStreamerAppend);
            Long imageId = baseMapper.getImageId(tblStreamerAppend.getStreamerId());
            String imageUrlById = tblImageMapper.getImageUrlById(imageId);
            mcnListVo.setImageUrl(imageUrlById);
            return mcnListVo;
        });
    }

    @Override
    public MCNInfoVo MCNDetail(Long mcnId) {
        LambdaQueryWrapper<TblStreamerAppend> streamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        streamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getStreamerId, mcnId);
        TblStreamerAppend tblStreamerAppend = tblStreamerAppendMapper.selectOne(streamerAppendLambdaQueryWrapper);
        if (tblStreamerAppend == null) return null;
        MCNInfoVo mcnInfoVo = streamerConvert.toMCNInfoVo(tblStreamerAppend);
        Long imageId = baseMapper.getImageId(tblStreamerAppend.getStreamerId());
        String imageUrlById = tblImageMapper.getImageUrlById(imageId);
        mcnInfoVo.setImageUrl(imageUrlById);
        return mcnInfoVo;
    }

    @Override
    public List<MCNSignVo> MCNSign(Long mcnId) {
        LambdaQueryWrapper<UmsAdminStreamer> adminStreamerLambdaQueryWrapper = new LambdaQueryWrapper<>();
        adminStreamerLambdaQueryWrapper.eq(UmsAdminStreamer::getBelongTo, mcnId);
        List<UmsAdminStreamer> umsAdminStreamers = baseMapper.selectList(adminStreamerLambdaQueryWrapper);
        if (umsAdminStreamers.isEmpty()) return null;
        List<Long> idList = umsAdminStreamers.stream().map((streamer) -> streamer.getId()).collect(Collectors.toList());

        LambdaQueryWrapper<TblStreamerAppend> tblStreamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tblStreamerAppendLambdaQueryWrapper.in(TblStreamerAppend::getStreamerId, idList);
        List<TblStreamerAppend> streamerAppendList = tblStreamerAppendMapper.selectList(tblStreamerAppendLambdaQueryWrapper);
        return streamerAppendList.stream().map((streamerAppend) -> {
            MCNSignVo mcnSignVo = streamerConvert.toMCNSignVo(streamerAppend);
            Long imageId = baseMapper.getImageId(streamerAppend.getStreamerId());
            String imageUrlById = tblImageMapper.getImageUrlById(imageId);
            mcnSignVo.setImageUrl(imageUrlById);
            return mcnSignVo;
        }).collect(Collectors.toList());
    }

    @Override
    public IPage<UmsIndustryRankVO> blueVRank(String keyWord, String industry, Integer pageNum, Integer pageSize) {
        //分页对象
        Page<TblStreamerAppend> page = new Page<>(pageNum, pageSize);
        //条件查询
        LambdaQueryWrapper<TblStreamerAppend> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotBlank(industry), TblStreamerAppend::getIndustry, industry);
        queryWrapper.like(StrUtil.isNotBlank(keyWord), TblStreamerAppend::getStreamerName, keyWord);
        //蓝V
        queryWrapper.eq(TblStreamerAppend::getBlueV, 1);

        IPage<TblStreamerAppend> iPage = tblStreamerAppendMapper.selectPage(page, queryWrapper);

        return iPage.convert(tblStreamerAppend -> {
            UmsIndustryRankVO res = new UmsIndustryRankVO();
            res.setAvgComments(tblStreamerAppend.getTotalComments() / tblStreamerAppend.getTotalVideos());
            res.setAvgLikes(tblStreamerAppend.getTotalLikes() / tblStreamerAppend.getTotalVideos());
            res.setAvgShares(tblStreamerAppend.getTotalShares() / tblStreamerAppend.getTotalVideos());
            res.setTotalFans(tblStreamerAppend.getTotalFans());
            res.setStreamerId(tblStreamerAppend.getStreamerId());
            res.setStreamerName(tblStreamerAppend.getStreamerName());
            return res;
        });
    }

}
