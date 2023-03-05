package com.ittime.linglingbo.modules.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ittime.linglingbo.modules.ums.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * @author macro
 * @since 2020-08-21
 */
public interface UmsAdminMapper extends BaseMapper<UmsAdmin> {

    /**
     * 获取资源相关用户ID列表
     */
    List<Long> getAdminIdList(@Param("resourceId") Long resourceId);

    /**
     * 更新信息
     *
     * @param nickName 昵称
     * @param password 密码
     * @param tel      电话
     * @param username 用户名
     * @return boolean
     */
    Boolean updateInfo(String nickName, String password, String tel, String username);
}
