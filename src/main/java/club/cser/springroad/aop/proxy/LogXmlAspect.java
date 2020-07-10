package club.cser.springroad.aop.proxy;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;
import java.util.List;

public class LogXmlAspect {

    public void beforeMethod222(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect1 @Before Method name:" + methodName + ", args=" + argList);
    }

    public void afterMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect1 @After Method name:" + methodName + ", args=" + argList);
    }

    public void afterReturninggg(JoinPoint jp, Object resultttt){
        String methodName = jp.getSignature().getName();
        System.out.println("LogAspect1 @AfterReturning Method name:" + methodName + ", result=" + resultttt);
    }
}
