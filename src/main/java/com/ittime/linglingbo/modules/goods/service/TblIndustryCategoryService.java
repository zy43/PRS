package com.ittime.linglingbo.modules.goods.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.goods.model.TblIndustryCategory;
import com.ittime.linglingbo.modules.goods.model.vo.CateIndustryListVo;

import java.util.List;

/**
 * <p>
 * 行业分类表 服务类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
public interface TblIndustryCategoryService extends IService<TblIndustryCategory> {

    /**
     * 根据行业名称查询行业数据
     *
     * @param cateIndustryName 行业名称
     * @param pageSize         分页大小
     * @param pageNum          第几页
     * @return
     */
    IPage<CateIndustryListVo> list(String cateIndustryName, Integer pageSize, Integer pageNum);

    List<CateIndustryListVo> listAll();
}
