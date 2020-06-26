package club.cser.springroad.beans.client;

import club.cser.springroad.beans.entity.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factoryBeanTest.xml");
        // 通过xml定义的bean id创建，id需要唯一
        Address addr1 = (Address) applicationContext.getBean("addr1");
        Address addr2 = (Address) applicationContext.getBean("addr1");
        System.out.println(addr1);
        System.out.println(addr2);
        System.out.println(addr1 == addr2);
    }
}
