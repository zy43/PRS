package com.ittime.linglingbo.modules.streamer.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.linglingbo.modules.client.mapper.UmsAdminStreamerMapper;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.client.model.param.StreamerSeachListParam;
import com.ittime.linglingbo.modules.client.model.vo.AccurateSearchListVO;
import com.ittime.linglingbo.modules.favorite.mapper.TblFavoriteStreamerMapper;
import com.ittime.linglingbo.modules.favorite.model.TblFavoriteGoods;
import com.ittime.linglingbo.modules.favorite.model.TblFavoriteStreamer;
import com.ittime.linglingbo.modules.minio.mapper.TblImageMapper;
import com.ittime.linglingbo.modules.streamer.convert.StreamerAppendConvert;
import com.ittime.linglingbo.modules.streamer.model.param.StreamerSearchParam;
import com.ittime.linglingbo.modules.streamer.model.TblStreamerAppend;
import com.ittime.linglingbo.modules.streamer.mapper.TblStreamerAppendMapper;
import com.ittime.linglingbo.modules.streamer.model.vo.StreamerAppendVo;
import com.ittime.linglingbo.modules.streamer.service.TblStreamerAppendService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
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
public class TblStreamerAppendServiceImpl extends ServiceImpl<TblStreamerAppendMapper, TblStreamerAppend> implements TblStreamerAppendService {

    @Autowired
    private StreamerAppendConvert streamerAppendConvert;

    @Autowired
    private TblFavoriteStreamerMapper  favoriteStreamerMapper;

    @Autowired
    private TblStreamerAppendMapper appendMapper;

    @Autowired
    private TblImageMapper imageMapper;

    /**
     * 收藏主播分页查询
     *
     * @param pageSize
     * @param pageNum
     * @param param
     * @param userId
     * @return
     */
    @Override
    public IPage<StreamerAppendVo> list(Integer pageSize, Integer pageNum, StreamerSearchParam param, Long userId) {
        //分页对象
        Page<TblStreamerAppend> page = new Page<>(pageNum, pageSize);

        //查找我的收藏播主ids
        List<Long> streamerIds = favoriteStreamerMapper.selectList(new LambdaQueryWrapper<TblFavoriteStreamer>()
                .eq(TblFavoriteStreamer::getAdminId, userId)).stream().map(TblFavoriteStreamer::getStreamerId).collect(Collectors.toList());

        List<Long> ids = new ArrayList<>();
        //防止关键字为空把全部主播都选中
        if(StrUtil.isNotEmpty(param.getKeyword())){
            //获取相似主播名称的id
            ids= appendMapper.selectList(new LambdaQueryWrapper<TblStreamerAppend>()
                    .like(TblStreamerAppend::getStreamerName, param.getKeyword())).stream().map(TblStreamerAppend::getStreamerId).collect(Collectors.toList());
        }

        //条件查询--标签或主播名称
        LambdaQueryWrapper<TblStreamerAppend> queryWrapper = new LambdaQueryWrapper<>();
        if(ids.size() == 0){
            queryWrapper.like(StrUtil.isNotEmpty(param.getKeyword()), TblStreamerAppend::getLabel, param.getKeyword())
                    .in(TblStreamerAppend::getStreamerId, streamerIds);
        }
        else{
            queryWrapper.like(StrUtil.isNotEmpty(param.getKeyword()), TblStreamerAppend::getLabel, param.getKeyword())
                    .or().in(StrUtil.isNotEmpty(param.getKeyword()), TblStreamerAppend::getStreamerId, ids)
                    .in(TblStreamerAppend::getStreamerId, streamerIds);
        }
        //分页查询
        IPage<TblStreamerAppend> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(streamerAppend -> {
            StreamerAppendVo streamerAppendVo = streamerAppendConvert.toStreamerAppendListVo(streamerAppend);
            // 获取主播头像地址并注入
            String imageUrlById = imageMapper.getImageUrlById(streamerAppend.getStreamerId());
            streamerAppendVo.setImageUrl(imageUrlById);
            return streamerAppendVo;
        });

    }

    @Override
    public List<AccurateSearchListVO> accurateSearchList(StreamerSeachListParam param) {
        TblStreamerAppend append = new TblStreamerAppend();
        BeanUtils.copyProperties(param, append);
        LambdaQueryWrapper<TblStreamerAppend> query = new LambdaQueryWrapper<>();
        query.eq(StrUtil.isNotEmpty(param.getIndustry()), TblStreamerAppend::getIndustry, param.getIndustry())
                .eq(StrUtil.isNotEmpty(param.getLabel()), TblStreamerAppend::getLabel, param.getLabel())
                .eq(param.getAccountType() != 0, TblStreamerAppend::getAccountType, param.getAccountType())
                .eq(param.getPortraitSex() != 0, TblStreamerAppend::getPortraitSex, param.getPortraitSex())
                .eq(param.getPortraitAge() != 0, TblStreamerAppend::getPortraitAge, param.getPortraitAge());
        List<TblStreamerAppend> list = appendMapper.selectList(query);
        ArrayList<AccurateSearchListVO> vos = new ArrayList<>();
        for (TblStreamerAppend tblStreamerAppend : list) {
            AccurateSearchListVO vo = new AccurateSearchListVO();
            BeanUtils.copyProperties(tblStreamerAppend,vo);
            vos.add(vo);
        }
        return vos;
    }

}
