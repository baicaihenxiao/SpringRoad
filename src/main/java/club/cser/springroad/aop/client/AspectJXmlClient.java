package club.cser.springroad.aop.client;

import club.cser.springroad.aop.service.ArithmeticCalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJXmlClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjXmlConfig.xml");

        ArithmeticCalculatorService arithmeticCalculatorService = (ArithmeticCalculatorService)ctx.getBean("arithmeticCalculatorServiceImpl");

        System.out.println("CLIENT PRINT1: " + arithmeticCalculatorService.getClass().getName()); //这样会打印出代理类
        System.out.println("CLIENT PRINT3: " + arithmeticCalculatorService); // 这个打印出来的是被代理的类

        System.out.println("CLIENT PRINT4: " +  arithmeticCalculatorService.add(2, 8) );
        System.out.println("CLIENT PRINT5: " +  arithmeticCalculatorService.subtract(22, 76) );
    }
}
