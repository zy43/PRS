package com.ittime.linglingbo.modules.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ittime.linglingbo.common.entity.BaseEntity;
import com.ittime.linglingbo.modules.ums.mapper.UmsAdminMapper;
import com.ittime.linglingbo.modules.ums.mapper.UmsDepartmentMapper;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.model.UmsDepartment;
import com.ittime.linglingbo.modules.ums.service.UmsAdminService;
import com.ittime.linglingbo.modules.ums.service.UmsDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 组织机构 服务实现类
 *
 * @author zhl129
 * @date 2022/10/16 10:49
 * @email 1293384775@qq.com
 */
@Service
public class UmsDepartmentServiceImpl extends ServiceImpl<UmsDepartmentMapper, UmsDepartment> implements UmsDepartmentService {

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    /**
     * 新增组织机构
     *
     * @param umsDepartment
     * @return
     */
    @Override
    public boolean create(UmsDepartment umsDepartment) {
        return save(umsDepartment);
    }

    /**
     * 删除组织机构
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
        //判断组织机构下面是否有用户
        LambdaQueryWrapper<UmsAdmin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdmin::getCompanyId, id);

        long count = umsAdminMapper.selectCount(queryWrapper);
        //有，则无法删除
        if (count > 0) {
            return false;
        }
        //无，则删除
        return removeById(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<UmsDepartment> listAll() {
        LambdaQueryWrapper<UmsDepartment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(BaseEntity::getCreateTime);
        return list(queryWrapper);
    }

    /**
     * 根据组织机构id查询其下用户
     * @param departmentId
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public IPage<UmsAdmin> listAdmin(Integer departmentId, Integer pageSize, Integer pageNum) {
        Page<UmsAdmin> page = new Page<>(pageNum,pageSize);

        LambdaQueryWrapper<UmsAdmin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UmsAdmin::getCompanyId,departmentId);
        IPage<UmsAdmin> umsAdminPage = umsAdminMapper.selectPage(page, queryWrapper);
        return umsAdminPage;
    }


}
