package com.emora.service.impl;

import com.emora.domain.Permission;
import com.emora.mapper.PermissionMapper;
import com.emora.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 13:30
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll() {

        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.save(permission);

    }

    @Override
    public List<Permission> findParentPermission() {
        return permissionMapper.findParentPermisson();
    }
}
