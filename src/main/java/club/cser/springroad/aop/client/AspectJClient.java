package club.cser.springroad.aop.client;

import club.cser.springroad.aop.service.ArithmeticCalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectj.xml");

        ArithmeticCalculatorService arithmeticCalculatorService = (ArithmeticCalculatorService)ctx.getBean("arithmeticCalculatorServiceImpl");

        System.out.println("CLIENT PRINT1: " + arithmeticCalculatorService.getClass().getName()); //这样会打印出代理类
/*        try {
            // 这个什么都打印不出来，连CLIENT PRINT2都打不出来
            System.out.println("CLIENT PRINT2: " + arithmeticCalculatorService.getClass().newInstance().toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        System.out.println("CLIENT PRINT3: " + arithmeticCalculatorService); // 这个打印出来的是被代理的类

        System.out.println("CLIENT PRINT4: " +  arithmeticCalculatorService.add(2, 8) );
        System.out.println("CLIENT PRINT5: " +  arithmeticCalculatorService.subtract(22, 76) );
//        System.out.println("CLIENT PRINT6: " +  arithmeticCalculatorService.invalidOp(22, 76) );
    }
}
