package com.ittime.linglingbo.generator;

import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 导入爬虫数据
 *
 * @author Josh-ZJUT
 * @date 2023/3/4 15:23
 * @email dujianghui537885@163.com
 */
public class ScrapyImport {

    @Autowired
    private static UmsAdminStreamerMapper streamerMapper;

    @Autowired
    private static TblStreamerAppendMapper streamerAppendMapper;

    public static void main(String[] args) {
        String dyName = "dyName";
        String dyId = "dyId";
        String introduction = "introduction";
        Long totalVideos = 111L;
        Long increaseVideos = 2L;
        Long totalFans = 333L;
        Long increaseFans = 4L;
        Long followers = 55L;
        Long increaseFollowers = 6L;
        Long likes = 777L;
        Long increaseLikes = 88L;
        dyImport(dyName, dyId, introduction, totalVideos, increaseVideos, totalFans, increaseFans, followers, increaseFollowers, likes, increaseLikes);
    }

    /**
     * @param dyName            抖音名称    UmsAdminStreamer
     * @param dyId              抖音号      TblStreamerAppend
     * @param introduction      简介       UmsAdminStreamer
     * @param totalVideos       视频条数    TblStreamerAppend
     * @param increaseVideos    视频条数增量
     * @param totalFans         粉丝数     TblStreamerAppend
     * @param increaseFans      粉丝数增量   TblStreamerAppend
     * @param followers         关注数
     * @param increaseFollowers 关注数增量
     * @param likes             获赞数         TblStreamerAppend
     * @param increaseLikes     获赞数增量
     */
    private static void dyImport(String dyName, String dyId, String introduction, Long totalVideos, Long increaseVideos, Long totalFans, Long increaseFans, Long followers, Long increaseFollowers, Long likes, Long increaseLikes) {
        UmsAdminStreamer streamer = new UmsAdminStreamer()
                .setHostName(dyName)
                .setPlatform("抖音")
                .setStreamerDesc(introduction);
        streamerMapper.insert(streamer);
        final Long streamerId = streamer.getId();
        TblStreamerAppend streamerAppend = new TblStreamerAppend()
                .setStreamerId(streamerId)
                .setStreamerName(dyName)
                .setIntroduction(introduction)
                .setContactInformation(dyId)
                .setTotalVideos(totalVideos)
                .setTotalFans(totalFans)
                .setFansRankRise(increaseFans)
                .setTotalLikes(likes);
        streamerAppendMapper.insert(streamerAppend);
    }


}
