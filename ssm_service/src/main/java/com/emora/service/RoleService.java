package com.emora.service;

import com.emora.domain.Role;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 11:57
 */
public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findByRoleId(Integer roleId);

    void delPermissionsFromRole(Integer roleId);

    void addPermissionsToRole(Integer roleId, Integer permissionId);
}
