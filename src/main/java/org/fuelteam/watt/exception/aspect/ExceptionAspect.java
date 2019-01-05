package org.fuelteam.watt.exception.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.fuelteam.watt.exception.BaseException;
import org.fuelteam.watt.exception.chain.ExceptionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {

    @Autowired
    private ExceptionManager exceptionManager;

    // @AfterThrowing(pointcut = "execution(* *(..))")
    @AfterThrowing("execution(* org.fuelteam.*.*(..))")
    public void afterThrowing(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length <= 0) return;
        Exception exception = null;
        if (args[0] instanceof Exception) exception = (Exception) args[0];
        if (exception == null) return;
        if (!(exception instanceof BaseException)) throw exception;
        exceptionManager.publish((BaseException) exception);
    }
}
