package org.sun.bootapp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LogAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Pointcut("execution(public * org.sun.bootapp.*.*.*(..))")
    public void log() {
    }
    
    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
    	String methodName = joinPoint.getSignature().getDeclaringTypeName() + 
                "." + joinPoint.getSignature().getName();
        logger.info("@Before: " + methodName);
    	Object result = joinPoint.proceed();
    	logger.info("@After: " + methodName);
    	return result;
    }
}
