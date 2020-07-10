package club.cser.springroad.aop.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(2)
@Component
@Aspect
public class LogAspect2 {
//    不是同一个包的的可以用 @Before("club.cser.springroad.aop.proxy.LogAspect.aopServicePointcut()")
    @Before("LogAspect.aopServicePointcut()")
    public void beforeMethod333(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect2 @Before Method name:" + methodName + ", args=" + argList);
    }

    @After("LogAspect.aopServicePointcut()")
    public void afterMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect2 @After Method name:" + methodName + ", args=" + argList);
    }

    @AfterReturning(value = "LogAspect.aopServicePointcut()", returning = "resultttt")
    public void afterReturninggg(JoinPoint jp, Object resultttt){
        String methodName = jp.getSignature().getName();
        System.out.println("LogAspect2 @AfterReturning Method name:" + methodName + ", result=" + resultttt);
    }
}
