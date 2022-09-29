package com.emora.mapper;

import com.emora.domain.SysUser;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 21:29
 */
public interface UserMapper {
    SysUser findByUserName(String username);

    List<SysUser> findAll();

    void save(SysUser user);

    SysUser findByUserNameCheck(String username);

    SysUser findById(Integer id);

    void delRolesFromUser(Integer userId);

    void saveRoleToUser(Integer userId, Integer roleId);
}
