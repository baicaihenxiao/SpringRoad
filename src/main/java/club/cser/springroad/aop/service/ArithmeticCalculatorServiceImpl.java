package club.cser.springroad.aop.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticCalculatorServiceImpl implements ArithmeticCalculatorService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int invalidOp(int a, int b) {
        throw new IllegalArgumentException("ArithmeticCalculatorServiceImpl.invalidOp");
    }
}
