package com.emora.service;

import com.emora.domain.Permission;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 13:29
 */
public interface PermissionService {

    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findParentPermission();
}
