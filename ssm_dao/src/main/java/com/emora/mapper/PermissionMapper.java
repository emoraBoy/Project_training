package com.emora.mapper;

import com.emora.domain.Permission;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 13:31
 */
public interface PermissionMapper {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findParentPermisson();

    List<Permission> findPermissionByRoleId(Integer id);

}
