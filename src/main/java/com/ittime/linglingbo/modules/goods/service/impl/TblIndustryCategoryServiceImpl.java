package com.ittime.linglingbo.modules.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.modules.goods.convert.CateIndustryConvert;
import com.ittime.linglingbo.modules.goods.mapper.TblIndustryCategoryMapper;
import com.ittime.linglingbo.modules.goods.model.TblIndustryCategory;
import com.ittime.linglingbo.modules.goods.model.vo.CateIndustryListVo;
import com.ittime.linglingbo.modules.goods.service.TblIndustryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 行业分类表 服务实现类
 * </p>
 *
 * @author Josh
 * @since 2022-10-20
 */
@Service
public class TblIndustryCategoryServiceImpl extends ServiceImpl<TblIndustryCategoryMapper, TblIndustryCategory> implements TblIndustryCategoryService {


    @Autowired
    private CateIndustryConvert cateIndustryConvert;

    @Override
    public IPage<CateIndustryListVo> list(String cateIndustryName, Integer pageSize, Integer pageNum) {
        //条件查询
        Page<TblIndustryCategory> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<TblIndustryCategory> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StrUtil.isNotEmpty(cateIndustryName), TblIndustryCategory::getIndustryName, cateIndustryName);
        //Ipage
        IPage<TblIndustryCategory> iPage = baseMapper.selectPage(page, queryWrapper);
        //转为Vo对象返回
        return iPage.convert(industryCategory -> {
            CateIndustryListVo cateIndustryListVo = cateIndustryConvert.toCateIndustryListVo(industryCategory);
            return cateIndustryListVo;
        });
    }

    @Override
    public List<CateIndustryListVo> listAll() {
        List<TblIndustryCategory> industryCategoryList = baseMapper.selectList(null);

        List<CateIndustryListVo> cateIndustryListVoList = industryCategoryList.stream().map((industryCategory) -> {
            CateIndustryListVo cateIndustryListVo = cateIndustryConvert.toCateIndustryListVo(industryCategory);
            return cateIndustryListVo;
        }).collect(Collectors.toList());
        return cateIndustryListVoList;
    }
}
