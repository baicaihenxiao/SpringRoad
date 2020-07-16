package club.cser.springroad.jdbc.client;

import club.cser.springroad.jdbc.service.HelloWorldNewService;
import club.cser.springroad.jdbc.service.HelloWorldService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.util.Date;

public class TransactionRequiredNewClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("club.cser.springroad.jdbc");
        ctx.refresh();

        DataSource dataSource = ctx.getBean(DataSource.class);
        HelloWorldNewService helloWorldNewService = (HelloWorldNewService)ctx.getBean("helloWorldNewService");

        System.out.println(dataSource);

        helloWorldNewService.transactionNewHelloWorld("tianjjjj" + new Date().toString(), "kaka" + new Date().toString(), 1, false);


    }
}
