package com.ming.bns.admin.aspect.statistics;

import com.ming.bns.admin.aspect.log.Log;
import com.ming.bns.admin.entity.Statistics;
import com.ming.bns.admin.entity.StatisticsItem;
import com.ming.bns.admin.entity.SystemLog;
import com.ming.bns.admin.service.StatisticsItemService;
import com.ming.bns.admin.service.StatisticsService;
import com.ming.bns.admin.service.SystemLogService;
import com.ming.bns.admin.utils.AspectUtils;
import com.ming.bns.admin.vo.StatisticsItemVo;
import com.ming.bns.admin.vo.StatisticsVo;
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
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Order(-1)//保证切面在@Transactional前执行
public class VisitStatisticsAspect {
    @Resource
    private StatisticsService statisticsService;
    @Resource
    private StatisticsItemService statisticsItemService;

    //@Pointcut(value = "@annotation(com.ming.bns.admin.aspect.log.Log) || @within(com.ming.bns.admin.aspect.log.Log)")
    @Pointcut(value = "@annotation(com.ming.bns.admin.aspect.statistics.VisitStatistics)")
    public void point(){}

    @Before("point()")
    public void before(){}

    @Around("point()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //String args = AspectUtils.getInstance().bulidParams(joinPoint);
        //Class clazz = joinPoint.getTarget().getClass();
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        VisitStatistics visitStatistics = method.getAnnotation(VisitStatistics.class);
        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();//获取request
        //HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();//获取response
        //String ip = AspectUtils.getIpAddress(request);
        //String mapping = AspectUtils.getMapping(clazz,method);
        ThreadPool.execute(()-> {
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            StatisticsVo statisticsVo = new StatisticsVo();
            statisticsVo.setType(visitStatistics.type());
            Statistics statistics = statisticsService.selectOne(statisticsVo);
            if(statistics == null){
                statistics = new Statistics();
                statistics.setType(visitStatistics.type());
                statistics.setDesc(visitStatistics.desc());
                statistics.setTotalCount(1);
                statisticsService.insert(statistics);
            }else{
                statistics.setTotalCount(statistics.getTotalCount()+1);
                statisticsService.update(statistics);
            }

            StatisticsItemVo statisticsItemVo = new StatisticsItemVo();
            statisticsItemVo.setStatisticsId(statistics.getId());
            statisticsItemVo.setDate(sdf.format(d));
            StatisticsItem statisticsItem = statisticsItemService.selectOne(statisticsItemVo);
            if(statisticsItem == null){
                statisticsItem = new StatisticsItem();
                statisticsItem.setStatisticsId(statisticsItemVo.getStatisticsId());
                statisticsItem.setDate(statisticsItemVo.getDate());
                statisticsItem.setCount(1);
                statisticsItemService.insert(statisticsItem);
            }else{
                statisticsItem.setCount(statisticsItem.getCount()+1);
                statisticsItemService.update(statisticsItem);
            }
        });
        System.out.println("接口访问统计："+visitStatistics.type()+"|"+visitStatistics.desc()+"|"+(endTime-startTime)+"ms");
        return obj;
    }

    @After("point()")
    public void after(){}
}
