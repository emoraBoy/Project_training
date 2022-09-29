package com.emora.controller;

import com.emora.domain.Permission;
import com.emora.service.PermissionService;
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
 * @Date 2022/9/11 12:20
 */
@Controller
@RequestMapping("/permission")
public class PermissionContriller {
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/findAll")
    public ModelAndView findAll(@RequestParam(value = "currPage", required = false, defaultValue = "1") Integer currPage, @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageHelper.startPage(currPage, pageSize);
        List<Permission> permissionList = permissionService.findAll();
        PageInfo<Permission> pageInfo = new PageInfo<>(permissionList, 5);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }


    @GetMapping("/saveUI")
    public ModelAndView saveUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissionList = permissionService.findParentPermission();
        modelAndView.addObject("permissionList", permissionList);
        modelAndView.setViewName("permission-add");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:/permission/findAll";
    }


}
