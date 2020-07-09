package club.cser.springroad.aop.client;

import club.cser.springroad.aop.proxy.ArithmeticCalculatorLogProxy;
import club.cser.springroad.aop.service.ArithmeticCalculatorService;
import club.cser.springroad.aop.service.ArithmeticCalculatorServiceImpl;

public class ArithmeticCalculatorClient {
    public static void main(String[] args) {
        ArithmeticCalculatorService arithmeticCalculatorService = new ArithmeticCalculatorServiceImpl();
        ArithmeticCalculatorService proxy = new ArithmeticCalculatorLogProxy(arithmeticCalculatorService).getProxy();
        System.out.println("1 + 5 =" + proxy.add(1, 5) );
        System.out.println("1 - 5 =" + proxy.subtract(1, 5) );
        System.out.println(arithmeticCalculatorService);
        System.out.println(proxy);
    }
}
