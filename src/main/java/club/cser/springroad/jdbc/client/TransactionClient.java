package club.cser.springroad.jdbc.client;

import club.cser.springroad.jdbc.service.HelloWorldService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;

public class TransactionClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("club.cser.springroad.jdbc");
        ctx.refresh();

        DataSource dataSource = ctx.getBean(DataSource.class);
        HelloWorldService helloWorldService = (HelloWorldService)ctx.getBean("helloWorldService");

        System.out.println(dataSource);

        helloWorldService.updateHelloWorld("ccity" + new Date().toString(), "nameee" + new Date().toString(), 1, true);

    }
}
