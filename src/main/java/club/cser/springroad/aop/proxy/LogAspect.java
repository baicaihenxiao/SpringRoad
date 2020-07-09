package club.cser.springroad.aop.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Aspect
public class LogAspect {

    @Before("execution(* club.cser.springroad.aop.service.*.*(..))")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("Method name:" + methodName + ", args=" + argList);
    }

}
