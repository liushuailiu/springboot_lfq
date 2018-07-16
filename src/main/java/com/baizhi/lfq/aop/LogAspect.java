package com.baizhi.lfq.aop;

import com.baizhi.lfq.dao.LoggingDao;
import com.baizhi.lfq.entity.Admin;
import com.baizhi.lfq.entity.Logging;
import com.baizhi.lfq.service.LoggingService;
import com.baizhi.lfq.service.LoggongServiceImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by 14832 on 2018/7/9.
 */
@Configuration
@Aspect
public class LogAspect {
    @Resource
    LoggingService loggingService;
    //切入点
    //@Pointcut(value = "execution(* com.baizhi.lfq.service.*.*(..))")
    @Pointcut(value = "@annotation(LogAnnotation)")
    public void pointCut() {

    }

    //环绕通知
    @Around(value = "pointCut()")
    public Object arround(ProceedingJoinPoint proceedingJoinPoint) {
        // 是谁 什么时候 干了什么事 执行结果
        //获取Session
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = servletRequestAttributes.getRequest().getSession();
        Admin user = (Admin)session.getAttribute("user");
        String AdminName = user.getName();

        //什么时间
        Date date = new Date();

        //干的事
        String name = proceedingJoinPoint.getSignature().getName();//获取当前的方法


        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();//获取当前的方法
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);//获取注解
        String s = annotation.name();//获取注解属性值

        boolean flag = false;
        //执行结果
        Object proceed = null;
        Logging logging = new Logging(null,AdminName,date,name,s);
        loggingService.insertOneLogging(logging);

        try {

            proceed = proceedingJoinPoint.proceed();
            flag = true;
        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }
        return proceed;

    }
}
