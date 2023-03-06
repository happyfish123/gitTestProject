package com.example.demo.aop.param;

import com.example.demo.common.AbstractVO;
import com.example.demo.common.ResponseEntity;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 参数校验
 */
@Slf4j
@Aspect
@Component
public class ParamCheckAspect {

    @Pointcut("execution(public * com.example.demo.web.*.*(..))")
    public void webPointCut() {

    }

    @Pointcut("execution(public * com.example.demo.rpcservice.*.*(..))")
    public void rpcPointCut() {

    }


    @Around("webPointCut() || rpcPointCut() ")
    public Object paramCheck(ProceedingJoinPoint joinPoint) {
        ResponseEntity<Object> result = new ResponseEntity<>();
        try {
            Object[] args = joinPoint.getArgs();
            if (args != null && args.length == 1) {
                if (args[0] instanceof AbstractVO) {
                    AbstractVO request = (AbstractVO) args[0];
                    request.checkParam();
                } else if (args[0] instanceof List) {
                    List requests = (List) args[0];
                    for (Object request : requests) {
                        if (!(request instanceof AbstractVO)) {
                            break;
                        }
                        ((AbstractVO) request).checkParam();
                    }
                }

            }
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error("fail to invoke interface with: {}, cause: {}", joinPoint, Throwables.getStackTraceAsString(e));
            result.failure(e.getMessage(), e);
            return result;
        }
    }

}
