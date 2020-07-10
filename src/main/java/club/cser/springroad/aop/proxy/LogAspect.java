package club.cser.springroad.aop.proxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(3)
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* club.cser.springroad.aop.service.*.*(..))")
    public void aopServicePointcut(){}

    @Before("aopServicePointcut()")
    public void beforeMethod222(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect1 @Before Method name:" + methodName + ", args=" + argList);
    }


    // @After无法获得返回值，无论被代理的方法执行中是否发生异常，都会在执行后调用
    @After("aopServicePointcut()")
    public void afterMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        List<Object> argList = Arrays.asList(jp.getArgs());
        System.out.println("LogAspect1 @After Method name:" + methodName + ", args=" + argList);
    }

    // @After之后调用，可以获得返回值，但是如果发生异常，该方法不会被调用。
    @AfterReturning(value = "aopServicePointcut()", returning = "resultttt")
    public void afterReturninggg(JoinPoint jp, Object resultttt){
        String methodName = jp.getSignature().getName();
        System.out.println("LogAspect1 @AfterReturning Method name:" + methodName + ", result=" + resultttt);
    }

    // 可以通过细分Exception来对不同的异常执行advise。
    // 如果@Around修改了被切方法的异常类型，这里接收到的是修改后的异常，如果@Around处理了之后没有在抛出异常，这个方法不会执行。
    @AfterThrowing(value = "aopServicePointcut()", throwing = "ex")
    public void afterThrowinggg(JoinPoint jp, Exception ex){
        String methodName = jp.getSignature().getName();
//        System.out.println("@AfterThrowing Method name:" + methodName + ", ex=" + Arrays.toString(ex.getStackTrace()));
        System.out.println("@AfterThrowing Method name:" + methodName + ", ex=" + ex);
    }

    @Around(value = "aopServicePointcut()")
    public Object afterThrowinggg(ProceedingJoinPoint pjp){
        String methodName = pjp.getSignature().getName();
        Object result = null;

        try {
            System.out.println("@Around  before Method name:" + methodName + ", args=" + Arrays.toString(pjp.getArgs()));
            result = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("@Around  afterThrowing Method name:" + methodName + ", throwable=" + throwable);
//            throw new RuntimeException("@Around change to RuntimeException:" + throwable); 调用这个会调用String的构造函数，会丢失Cause by
            throw new RuntimeException(throwable);
        } finally {
            System.out.println("@Around  after Method name:" + methodName);
        }

        System.out.println("@Around  afterReturning??? Method name:" + methodName + ", result=" + result);

        return result; // 需要保证返回类型和被切方法类型不一致，比如返回null，和int类型不一致。
    }


}
