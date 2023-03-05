package com.ittime.linglingbo.modules.monitor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.minio.mapper.TblImageMapper;
import com.ittime.linglingbo.modules.monitor.service.MonitorService;
import com.ittime.linglingbo.modules.monitor.vo.AuthorizeVo;
import com.ittime.linglingbo.modules.monitor.vo.MyAccountVo;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerDaylogMapper;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerDaylog;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhl129
 * @date 2022/12/29 17:28
 * @email 1293384775@qq.com
 */
@Service
public class MonitorServiceImpl implements MonitorService {

    @Autowired
    private TblStreamerAppendMapper streamerAppendMapper;

    @Autowired
    private TblStreamerDaylogMapper streamerDaylogMapper;

    @Autowired
    private UmsAdminStreamerMapper streamerMapper;

    @Autowired
    private TblImageMapper imageMapper;

    @Override
    public List<MyAccountVo> getMyAccount(UmsAdmin admin) {
        Long id = admin.getClientId();
        LambdaQueryWrapper<TblStreamerAppend> streamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        streamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getStreamerId,id);
        List<TblStreamerAppend> tblStreamerAppendList = streamerAppendMapper.selectList(streamerAppendLambdaQueryWrapper);
        List<MyAccountVo> myAccountVoList = new ArrayList<>();

        for (TblStreamerAppend streamerAppend : tblStreamerAppendList) {
            MyAccountVo myAccountVo = new MyAccountVo();
            myAccountVo.setStreamerName(streamerAppend.getStreamerName());
            Long imageId = streamerMapper.getImageId(id);
            String imageUrlById = imageMapper.getImageUrlById(imageId);
            myAccountVo.setImageUrl(imageUrlById);
            //今日
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            LambdaQueryWrapper<TblStreamerDaylog> tblStreamerDaylogLambdaQueryWrapper = new LambdaQueryWrapper<>();
            tblStreamerDaylogLambdaQueryWrapper.eq(TblStreamerDaylog::getStreamerId,id).eq(TblStreamerDaylog::getLogDate,simpleDateFormat.format(date));
            TblStreamerDaylog streamerDaylog = streamerDaylogMapper.selectOne(tblStreamerDaylogLambdaQueryWrapper);
            myAccountVo.setToday(streamerDaylog);
            //昨日
            LambdaQueryWrapper<TblStreamerDaylog> yesterdayQueryWrapper = new LambdaQueryWrapper<>();
            yesterdayQueryWrapper.eq(TblStreamerDaylog::getStreamerId,id)
                    .eq(TblStreamerDaylog::getLogDate,simpleDateFormat.format(new Date(date.getTime()-24 * 60 * 60 * 1000)));
            TblStreamerDaylog yesterday = streamerDaylogMapper.selectOne(yesterdayQueryWrapper);
            myAccountVo.setYesterday(yesterday);

            myAccountVoList.add(myAccountVo);
        }

        return myAccountVoList;
    }

    @Override
    public boolean authorize(Long streamerId) {
        LambdaQueryWrapper<TblStreamerAppend> tblStreamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tblStreamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getStreamerId,streamerId).eq(TblStreamerAppend::getAuthorize,0);
        TblStreamerAppend streamerAppend = streamerAppendMapper.selectOne(tblStreamerAppendLambdaQueryWrapper);
        if(streamerAppend == null) return false;
        streamerAppend.setAuthorize(streamerId);


        LambdaQueryWrapper<TblStreamerAppend> updateQueryWrapper = new LambdaQueryWrapper<>();
        updateQueryWrapper.eq(TblStreamerAppend::getStreamerId,streamerId);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        streamerAppend.setAuthorizeTime(simpleDateFormat.format(date));
        streamerAppendMapper.update(streamerAppend,updateQueryWrapper);
        return true;
    }

    @Override
    public List<AuthorizeVo> authorizeList(UmsAdmin admin) {
        Long id = admin.getClientId();
        LambdaQueryWrapper<TblStreamerAppend> tblStreamerAppendLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tblStreamerAppendLambdaQueryWrapper.eq(TblStreamerAppend::getAuthorize,id);
        List<TblStreamerAppend> tblStreamerAppendList = streamerAppendMapper.selectList(tblStreamerAppendLambdaQueryWrapper);
        List<AuthorizeVo> authorizeVos = new ArrayList<>();
        if(tblStreamerAppendList.isEmpty())
            return authorizeVos;
        for (TblStreamerAppend streamerAppend : tblStreamerAppendList) {
            AuthorizeVo authorizeVo = new AuthorizeVo();
            authorizeVo.setAuthorize("已授权");
            authorizeVo.setStreamerName(streamerAppend.getStreamerName());
            authorizeVo.setAuthorizeTime(streamerAppend.getAuthorizeTime());
            authorizeVo.setStreamerId(streamerAppend.getStreamerId());

            Long imageId = streamerMapper.getImageId(streamerAppend.getStreamerId());
            String imageUrlById = imageMapper.getImageUrlById(imageId);
            authorizeVo.setImageUrl(imageUrlById);
            authorizeVos.add(authorizeVo);
        }
        return authorizeVos;
    }


}
