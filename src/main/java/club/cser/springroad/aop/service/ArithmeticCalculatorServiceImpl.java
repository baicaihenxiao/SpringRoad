package club.cser.springroad.aop.service;

public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }
}
