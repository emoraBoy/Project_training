package com.emora.mapper;

import com.emora.domain.Role;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 11:58
 */
public interface RoleMapper {
    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Integer id);

    Role findByRoleId(Integer roleId);

    void delPermissionFromRoleByRoleId(Integer roleId);

    void savePermissionToRole(Integer roleId, Integer permissionId);
}
