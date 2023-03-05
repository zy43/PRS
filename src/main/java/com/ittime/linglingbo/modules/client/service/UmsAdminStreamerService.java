package com.ittime.linglingbo.modules.client.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.client.model.UmsAdminStreamer;
import com.ittime.linglingbo.modules.client.model.param.StreamerCertificateParam;
import com.ittime.linglingbo.modules.client.model.vo.OwnerListVO;
import com.ittime.linglingbo.modules.client.model.vo.StreamerListVO;
import com.ittime.linglingbo.modules.ums.dto.*;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

/**
 * 播主/MCN 表 服务类
 *
 * @author lxw
 */
public interface UmsAdminStreamerService extends IService<UmsAdminStreamer> {


    /**
     * 分页查询
     *
     * @param pageSize 分页大小
     * @param pageNum  第几页
     * @return
     */
    IPage<StreamerListVO> list(Integer pageSize, Integer pageNum, String hostName, String industry, String goodsCategory);


    /**
     * 主播实名认证
     *
     * @param param
     * @return
     */
    boolean certificate(StreamerCertificateParam param, Long streamerId);

    /**
     * 数据概览
     *
     * @param id   id
     * @param days 天
     * @return {@link UmsGeneralVO}
     */
    UmsGeneralVO collectGeneralData(Long id, Integer days);

    /**
     * 粉丝数据收集
     *
     * @param id id
     * @return {@link UmsFansFeatureVO}
     */
    UmsFansFeatureVO collectFansData(Long id);

    /**
     * 收集视频概况
     *
     * @param id   id
     * @param days 天
     * @return {@link UmsVideoGeneralVO}
     */
    UmsVideoGeneralVO collectVideoGeneralData(Long id, Integer days);

    IPage<UmsVideoDetailVO> collectVideoDetailData(String fromDay, String endDay, String keyWord, Integer pageSize, Integer pageNum, Long id) throws ParseException;

    List<UmsGoodsVO> getGoodsInfo(Long streamer, Integer days, String keyWord, Integer pageSize, Integer pageNum);

    Long getGoodsCount(Long id, Integer days, String keyWord);

    IPage<UmsIndustryRankVO> industryRank(String keyWord, String industry, Integer pageNum, Integer pageSize) throws ParseException;

    List<UmsFansRiseRankVO> fansRiseRank(Integer days, String keyWord, String fromDay, String endDay, String industry, Integer pageNum, Integer pageSize);

    Long getFansTotalCount(Integer days, String keyWord, String fromDay, String endDay, String industry);

    List<UmsIndustryRankVO> regionRank(String keyWord, String province, String city, Integer pageNum, Integer pageSize);

    Long getRegionTotalCount(String keyWord, String province, String city);

    IPage<UmsStarChartVo> getStarChartRank(Integer pageSize, Integer pageNum);

    List<StreamerCompareSearchVo> getStreamerCompareSearch(String key);

    StreamerCompareDetailVo getStreamerCompareDetail(Long id);

    IPage<MCNListVo> getMCNList(MCNListParam mcnListParam, Integer pageSize, Integer pageNum);

    MCNInfoVo MCNDetail(Long mcnId);

    List<MCNSignVo> MCNSign(Long mcnId);

    IPage<UmsIndustryRankVO> blueVRank(String keyWord, String industry, Integer pageNum, Integer pageSize);

}