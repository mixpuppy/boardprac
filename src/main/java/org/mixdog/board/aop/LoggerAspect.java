package org.mixdog.board.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
    @Around("execution(* org.mixdog.board..controller.*Controller.*(..)) || execution(* org.mixdog.board..service.*Impl.*(..)) || execution(* org.mixdog.board..repository.*Dao.*(..))")
    public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        String type = "";
        String name = joinPoint.getSignature().getDeclaringTypeName();
        if(name.indexOf("Controller") > -1) {
            type = "Controller  \t:  ";
        }
        else if(name.indexOf("Service") > -1) {
            type = "ServiceImpl  \t:  ";
        }
        else if(name.indexOf("Dao") > -1) {
            type = "repository \t:  ";
        }
        log.debug(type + name + "." + joinPoint.getSignature().getName() + "()");
        return joinPoint.proceed();
    }
}
