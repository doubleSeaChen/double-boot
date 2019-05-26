package com.common.aspect;

import com.common.annotation.Log;
import com.common.shiro.ShiroTool;
import com.common.tool.MyUtils;
import com.system.domain.LogDO;
import com.system.domain.UserDO;
import com.system.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    LogService logService;


    @Pointcut("@annotation(com.common.annotation.Log)")
    public void logPointCut() {
    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        // 执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;
        //异步保存日志
        saveLog(point, time);
        return result;
    }

    void saveLog(ProceedingJoinPoint joinPoint, long time) throws InterruptedException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LogDO sysLog = new LogDO();
        sysLog.setId(MyUtils.getUUID32());
        Log syslog = method.getAnnotation(Log.class);
        if (syslog != null) {
            // 注解上的描述
            sysLog.setOperation(syslog.value());
        }
        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className + "." + methodName + "()");
        // 请求的参数
        Object[] args = joinPoint.getArgs();
        sysLog.setCreateDate(new Date());
        sysLog.setTime((int) time);

        UserDO currUser = ShiroTool.getUser();
        if (null == currUser) {
            sysLog.setUserId("");
            sysLog.setUserName("获取用户信息为空");
        } else {
            sysLog.setUserId(currUser.getId());
            sysLog.setUserName(currUser.getUserName());
            sysLog.setName(currUser.getName());
        }

        // 保存系统日志
        logService.save(sysLog);
    }
}
