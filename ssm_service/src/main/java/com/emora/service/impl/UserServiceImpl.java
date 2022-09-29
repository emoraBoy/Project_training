package com.emora.service.impl;

import com.emora.domain.Role;
import com.emora.domain.SysUser;
import com.emora.mapper.UserMapper;
import com.emora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 21:19
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userMapper.findByUserName(username);
        if (user != null) {
            Collection<GrantedAuthority> authority = new ArrayList<>();
            // SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
            for (Role role : user.getRoleList()) {
                SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
                authority.add(simpleGrantedAuthority);
            }
            User userDetails = new User(user.getUsername(), user.getPassword(), authority);
            return userDetails;
        }
        return null;
    }

    @Override
    public List<SysUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void save(SysUser user) {
        userMapper.save(user);
    }

    @Override
    public SysUser findByUserName(String username) {
        return userMapper.findByUserNameCheck(username);
    }

    @Override
    public SysUser findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public void addRoleSToUser(Integer userId, Integer[] ids) {
        userMapper.delRolesFromUser(userId);

        if (ids != null) {
            for (Integer roleId : ids) {
                userMapper.saveRoleToUser(userId, roleId);
            }
        }
    }


}
