package club.cser.springroad.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
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

        Address addr1 = (Address) applicationContext.getBean("addr1");
        Address addr2 = (Address) applicationContext.getBean("addr2");
        Address addr3 = (Address) applicationContext.getBean("addr3"); // bean继承
        Address addr4 = (Address) applicationContext.getBean("addr4"); // 读取文件
        Address addr5 = (Address) applicationContext.getBean("addr5"); // SpEl

        System.out.println(addr1);
        System.out.println(addr2);
        System.out.println(addr3);
        System.out.println(addr4);
        System.out.println(addr5);
    }
}
