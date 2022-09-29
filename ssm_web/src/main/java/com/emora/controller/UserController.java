package com.emora.controller;

import com.emora.domain.Role;
import com.emora.domain.SysUser;
import com.emora.service.RoleService;
import com.emora.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 22:45
 */
@Controller
@RequestMapping("/user")
@Secured("ROLE_AMDIN")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(currPage, pageSize);
        List<SysUser> userList = userService.findAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList, 5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("user-list");
        return modelAndView;

    }

    @PostMapping("/save")
    public String save(SysUser user) throws Exception {
        String password = user.getPassword();
        // String newPwd = Md5.md5(password, Md5.md5key);
        String newPwd = passwordEncoder.encode(password);
        user.setPassword(newPwd);
        userService.save(user);
        return "redirect:/user/findAll";
    }

    @PostMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(String username) {

        SysUser user = userService.findByUserName(username);
        if (user == null) {
            return "0";
        } else {
            return "1";
        }
    }

    @GetMapping("/details")
    public ModelAndView details(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        SysUser user = userService.findById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @GetMapping("/addRolesToUserUI")
    public ModelAndView addRolesToUser(Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        SysUser user = userService.findById(userId);
        StringBuilder stringBuilder = new StringBuilder();
        for (Role role : user.getRoleList()) {
            stringBuilder.append(",");
            stringBuilder.append(role.getId());
            stringBuilder.append(",");
        }
        modelAndView.addObject("rolelist", roleList);
        modelAndView.addObject("str", stringBuilder.toString());
        modelAndView.addObject("userId", user.getId());
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    @RequestMapping("/addRoleSToUser")
    public String addRoleSToUser(Integer userId, Integer[] ids) {
        userService.addRoleSToUser(userId, ids);
        return "redirect:/user/findAll";

    }
}
