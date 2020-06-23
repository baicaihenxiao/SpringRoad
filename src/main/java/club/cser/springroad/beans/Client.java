package club.cser.springroad.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("cody");
        helloWorld.hello();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 通过xml定义的bean id创建，id需要唯一
        HelloWorld helloBean1 = (HelloWorld) applicationContext.getBean("helloWorld");
        helloBean1.hello();

        // 通过xml定义的bean类型创建，但是只能有一个该类型的bean，否则报错
        HelloWorld helloBean2 = applicationContext.getBean(HelloWorld.class);
        helloBean2.hello();

        // 嵌套bean
        People people = (People) applicationContext.getBean("people");
        people.hi();

    }
}
