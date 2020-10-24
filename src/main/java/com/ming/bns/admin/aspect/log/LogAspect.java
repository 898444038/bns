package com.ming.bns.admin.aspect.log;
import java.lang.reflect.Method;
import java.util.Date;

import com.ming.bns.admin.entity.bns.SystemLog;
import com.ming.bns.admin.service.bns.SystemLogService;
import com.ming.bns.admin.utils.AspectUtils;
import com.ming.bns.system.thread.ThreadPool;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Order(-1)//保证切面在@Transactional前执行
public class LogAspect {
    @Resource
    private SystemLogService systemLogService;

    //@Pointcut(value = "@annotation(com.ming.bns.admin.aspect.log.Log) || @within(com.ming.bns.admin.aspect.log.Log)")
    @Pointcut(value = "@annotation(com.ming.bns.admin.aspect.log.Log)")
    public void point(){}

    @Before("point()")
    public void before(){}

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String args = AspectUtils.getInstance().bulidParams(joinPoint);
        Class clazz = joinPoint.getTarget().getClass();
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        Log logAnno = method.getAnnotation(Log.class);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request
        //HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();//获取response
        String ip = AspectUtils.getIpAddress(request);
        String mapping = AspectUtils.getMapping(clazz,method);
        ThreadPool.execute(()-> {
            SystemLog log = new SystemLog();
            log.setLoginIp(ip);
            log.setMapping(mapping);
            log.setMethod(method.getName());
            log.setArgs(args);
            log.setResult(AspectUtils.getInstance().argValue(obj));
            if(log.getResult()!=null && log.getResult().length()>200){
                log.setResult(log.getResult().substring(0,200)+"......");
            }
            log.setType(logAnno.value());
            log.setCreateTime(new Date());
            log.setExecuteTime((endTime-startTime)+"");
            systemLogService.insert(log);
        });
        return obj;
    }

    @After("point()")
    public void after(){}
}
