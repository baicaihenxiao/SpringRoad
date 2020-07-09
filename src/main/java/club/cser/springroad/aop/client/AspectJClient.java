package club.cser.springroad.aop.client;

import club.cser.springroad.aop.service.ArithmeticCalculatorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aspectj.xml");

        ArithmeticCalculatorService arithmeticCalculatorService = (ArithmeticCalculatorService)ctx.getBean("arithmeticCalculatorServiceImpl");

        System.out.println( arithmeticCalculatorService.add(2, 8) );
        System.out.println( arithmeticCalculatorService.subtract(22, 76) );
    }
}
