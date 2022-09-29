package com.emora.controller;

import com.emora.domain.Permission;
import com.emora.domain.Role;
import com.emora.service.PermissionService;
import com.emora.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 11:28
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    protected PermissionService permissionService;

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(currPage, pageSize);
        List<Role> roleList = roleService.findAll();
        PageInfo<Role> pageInfo = new PageInfo<>(roleList, 5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll";
    }

    @RequestMapping("/addPermissionsToRoleUI")
    public ModelAndView addPermissionsToRoleUI(Integer roleId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findAll();
        Role role = roleService.findByRoleId(roleId);
        StringBuilder sb = new StringBuilder();
        for (Permission permission : role.getPermissionList()) {
            sb.append(",");
            sb.append(permission.getId());
            sb.append(",");
        }
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.addObject("str", sb.toString());
        modelAndView.addObject("roleId", role.getId());
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionsToRole")
    public String addPermissionsToRole(Integer roleId, Integer[] ids) {
        roleService.delPermissionsFromRole(roleId);
        if (ids != null) {
            for (Integer permissionId : ids) {
                roleService.addPermissionsToRole(roleId, permissionId);
            }
        }
        return "redirect:/role/findAll";
    }

}
