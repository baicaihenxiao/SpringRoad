package club.cser.springroad.aop.proxy;

import club.cser.springroad.aop.service.ArithmeticCalculatorService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLogProxy {

    private ArithmeticCalculatorService target;

    public ArithmeticCalculatorLogProxy(ArithmeticCalculatorService target) {
        this.target = target;
    }


    public ArithmeticCalculatorService getProxy() {
        // 代理对象由哪一个加载器加载（应该是创建的proxy由同一个加载器加载） the class loader to define the proxy class
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 代理哪些方法  the list of interfaces for the proxy class to implement
        Class[] interfaces = new Class[]{ArithmeticCalculatorService.class};

        /* 把对target方法的调用分配给handler来调用 the invocation handler to dispatch method invocations to
         Each proxy instance has an associated invocation handler.
         When a method is invoked on a proxy instance, the method
         invocation is encoded and dispatched to the {@code invoke}
         method of its invocation handler.
         */
        InvocationHandler handler = new InvocationHandler() {

            /*
            @param proxy
            方法被哪个proxy调用 the proxy instance that the method was invoked on

            !!! 一般不会直接在invoke方法里使用proxy，甚至不能System.out.println(proxy); 这个会调用proxy.toString()，
            因为proxy同样代理了toString方法，所以proxy.toString()又会递归调invoke方法，直到StackOverflowError
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method:" + method.getName() + ", args=" + Arrays.toString(args));
                Object result = method.invoke(target, args);
                System.out.println("method:" + method.getName() + ", result=" + result);
//                System.out.println(proxy);  // 打印这个会StackOverflowError
                return result;
            }
        };

        /*
         * 构建proxy对象
         *  Returns an instance of a proxy class for the specified interfaces
         * that dispatches method invocations to the specified invocation
         * handler
         */
        //return  a proxy instance with the specified invocation handler of a
        // proxy class that is defined by the specified class loader
        // and that implements the specified interfaces
        ArithmeticCalculatorService proxy = (ArithmeticCalculatorService)Proxy.newProxyInstance(classLoader, interfaces, handler);
        return proxy;
    }

}
