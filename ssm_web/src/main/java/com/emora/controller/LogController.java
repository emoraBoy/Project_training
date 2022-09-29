package com.emora.controller;

import com.emora.domain.Log;
import com.emora.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author jianpeng
 * @Date 2022/9/11 22:17
 */
@Component
@Aspect
public class LogController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    private LogService logService;

    @Pointcut("execution(* com.emora.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {

        Log log = new Log();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = dateFormat.format(new Date());
        log.setVisitTime(str);

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        log.setUsername(username);

        String ip = request.getRemoteAddr();
        log.setIp(ip);

        Object target = joinPoint.getTarget();
        String name = target.getClass().getName();

        String methodName = joinPoint.getSignature().getName();
        log.setMethod(name + "." + methodName);

        logService.saveLog(log);

    }

}
