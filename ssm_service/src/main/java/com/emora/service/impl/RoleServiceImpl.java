package com.emora.service.impl;

import com.emora.domain.Role;
import com.emora.mapper.RoleMapper;
import com.emora.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 11:57
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public Role findByRoleId(Integer roleId) {
        return roleMapper.findByRoleId(roleId);
    }

    @Override
    public void delPermissionsFromRole(Integer roleId) {
        roleMapper.delPermissionFromRoleByRoleId(roleId);
    }

    @Override
    public void addPermissionsToRole(Integer roleId, Integer permissionId) {
        roleMapper.savePermissionToRole(roleId, permissionId);
    }
}
