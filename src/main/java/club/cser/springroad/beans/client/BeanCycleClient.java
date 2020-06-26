package club.cser.springroad.beans.client;

import club.cser.springroad.beans.entity.BeanLifeCycle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanCycleClient {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");


        BeanLifeCycle cycle1 = (BeanLifeCycle) applicationContext.getBean("cycle1");
        System.out.println(cycle1);

        ((ConfigurableApplicationContext)applicationContext).close();
    }
}
