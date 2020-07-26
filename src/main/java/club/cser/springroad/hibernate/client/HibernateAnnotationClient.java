package club.cser.springroad.hibernate.client;

import club.cser.springroad.hibernate.service.ComputerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class HibernateAnnotationClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        ComputerService computerService = context.getBean(ComputerService.class);
        computerService.addComputer("brand" + new Date(), "city" + new Date());

    }
}
