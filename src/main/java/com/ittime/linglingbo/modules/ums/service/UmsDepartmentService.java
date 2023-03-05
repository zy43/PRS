package com.ittime.linglingbo.modules.ums.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import com.ittime.linglingbo.modules.ums.model.UmsDepartment;

import java.util.List;

/**
 * 组织机构 服务类
 *
 * @author zhl129
 * @date 2022/10/16 10:34
 * @email 1293384775@qq.com
 */
public interface UmsDepartmentService extends IService<UmsDepartment> {

    boolean create(UmsDepartment umsDepartment);

    boolean delete(Long id);

    List<UmsDepartment> listAll();

    IPage<UmsAdmin> listAdmin(Integer departmentId, Integer pageSize, Integer pageNum);
}
