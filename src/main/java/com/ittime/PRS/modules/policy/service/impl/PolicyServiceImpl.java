package com.ittime.PRS.modules.policy.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ittime.PRS.modules.policy.model.Policy;
import com.ittime.PRS.modules.policy.mapper.PolicyMapper;
import com.ittime.PRS.modules.policy.model.param.PolicyParam;
import com.ittime.PRS.modules.policy.model.param.SelectParam;
import com.ittime.PRS.modules.policy.model.vo.PolicyVo;
import com.ittime.PRS.modules.policy.model.vo.ProvinceListVo;
import com.ittime.PRS.modules.policy.service.PolicyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhl
 * @since 2023-03-09
 */
@Service
public class PolicyServiceImpl extends ServiceImpl<PolicyMapper, Policy> implements PolicyService {


    @Autowired
    private PolicyMapper policyMapper;



    /**
     * 根据政策类型查找
     * @param policyType
     * @return
     */
    @Override
    public List<PolicyVo> selectByType(String policyType) {

//        // 分组统计
//        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
//        wrapper.select("province, count(province) as sum")
//                .groupBy("province");
//
//        // selectMaps方法会将查询结果封装为一个Map,Map的key为结果的列,value为值
//        List<Map<String, Object>> mapList = policyMapper.selectMaps(wrapper);
//        for (Map<String, Object> mp : mapList) {
//            System.out.println(mp);
//        }

        ArrayList<PolicyVo> list = new ArrayList<>();

        List<Policy> policies = policyMapper.selectList(new LambdaQueryWrapper<Policy>()
                .eq(Policy::getPolicyType, policyType)
                .isNotNull(Policy::getProvince)
                .orderByDesc(Policy::getUpdateDate)
                .last("limit 10"));

        policies.forEach(policy -> {
            PolicyVo policyVo = new PolicyVo();
            BeanUtils.copyProperties(policy, policyVo);
            list.add(policyVo);
        });

        return list;
    }

    /**
     * 该类型下政策筛选
     * @param param
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public IPage<PolicyVo> list(SelectParam param, Integer pageSize, Integer pageNum) {
        Page<Policy> page = new Page<>(pageNum, pageSize);

        LambdaQueryWrapper<Policy> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Policy::getPolicyType, param.getPolicyType())
                .eq(StrUtil.isNotBlank(param.getGrade()), Policy::getPolicyGrade, param.getGrade())
                .eq(StrUtil.isNotBlank(param.getProvince()), Policy::getProvince, param.getProvince())
                .eq(StrUtil.isNotBlank(param.getSource()), Policy::getPolicySource, param.getSource())
                .like(StrUtil.isNotBlank(param.getKeyWord()), Policy::getPolicyTitle, param.getKeyWord())
                .orderByDesc(Policy::getUpdateDate);

        //分页查询
        IPage<Policy> iPage = baseMapper.selectPage(page, wrapper);
        //转为Vo对象返回
        return iPage.convert(policy -> {
            PolicyVo policyVo = new PolicyVo();
            BeanUtils.copyProperties(policy, policyVo);
            return policyVo;
        });

    }

    /**
     * 各省政策数量
     * @return
     */
    @Override
    public List<ProvinceListVo> getProvinceList() {
        QueryWrapper<Policy> wrapper = new QueryWrapper<>();
        wrapper.select("province, count(province) as sum")
                .groupBy("province");
        // selectMaps方法会将查询结果封装为一个Map,Map的key为结果的列,value为值
        List<Map<String, Object>> mapList = policyMapper.selectMaps(wrapper);
        ArrayList<ProvinceListVo> provinceListVos = new ArrayList<>();
        for (Map<String, Object> mp : mapList) {
            ProvinceListVo provinceListVo = new ProvinceListVo();
            // 根据键值拿到数据
            String province = String.valueOf(mp.get("province"));
            int sum = Integer.parseInt(String.valueOf(mp.get("sum")));
            // 注入
            provinceListVo.setProvince(province);
            provinceListVo.setSum(sum);
            provinceListVos.add(provinceListVo);
        }

        return provinceListVos;
    }
}
