package club.cser.springroad.beans.client;

import club.cser.springroad.beans.controller.AddressController;
import club.cser.springroad.beans.service.HelloWorldService;
import club.cser.springroad.beans.service.PeopleService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenericDIClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");

        PeopleService peopleService = (PeopleService) ctx.getBean("peopleService");
        peopleService.getRepository();

        HelloWorldService helloworldService = (HelloWorldService) ctx.getBean("helloWorldService");
        helloworldService.getRepository();


    }
}
