package com.example.demo.aop.log;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 请求日志
 */
@Slf4j
@Aspect
@Component
@Profile("dev")
public class WebLogAspect {

    private final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.demo.web.*.*(..)) || execution(public * com.example.demo.rpcservice.*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        // 获取请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 请求执行前，记录请求内容
            log.info("请求URL : " + request.getRequestURL().toString());
            log.info("请求HTTP_METHOD : " + request.getMethod());
            log.info("请求IP : " + request.getRemoteAddr());
            log.info("请求CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.info("请求参数值PARAMS : " + Arrays.toString(joinPoint.getArgs()));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        if (ret instanceof ResponseEntity) {
            String retJson = JSONObject.toJSONString(ret);
            log.info("响应RESPONSE : " + retJson);
        }
        log.info("响应时间SPEND_TIME : " + (System.currentTimeMillis() - startTime.get()));
    }
}
