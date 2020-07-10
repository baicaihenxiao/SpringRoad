package club.cser.springroad.aop.service;

public interface ArithmeticCalculatorService {

    int add(int a, int b);
    int subtract(int a, int b);

    int invalidOp(int a, int b);
}
