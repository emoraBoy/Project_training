package com.emora.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/10 22:14
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping("/showUserName")
    public void showUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        Object O = session.getAttribute("SPRING_SECURITY_CONTEXT");
        SecurityContext  securityContext = (SecurityContext) O;
        Authentication authentication = securityContext.getAuthentication();
        User user= (User) authentication.getPrincipal();
        String username = user.getUsername();
    }
}
