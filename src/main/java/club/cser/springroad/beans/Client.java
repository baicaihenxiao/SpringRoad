package club.cser.springroad.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("cody");
        helloWorld.hello();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloBean = (HelloWorld) applicationContext.getBean("helloWorld");
        helloBean.hello();
    }
}
