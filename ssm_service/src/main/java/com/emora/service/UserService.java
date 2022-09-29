package com.emora.service;

import com.emora.domain.SysUser;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 21:19
 */
public interface UserService {

    List<SysUser> findAll();

    void save(SysUser user);

    SysUser findByUserName(String username);


    SysUser findById(Integer id);

    void addRoleSToUser(Integer userId, Integer[] ids);
}
