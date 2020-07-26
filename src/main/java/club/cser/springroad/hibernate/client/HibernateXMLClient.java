package club.cser.springroad.hibernate.client;

import club.cser.springroad.hibernate.service.PhoneService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Date;

public class HibernateXMLClient {
    public static void main(String[] args) throws SQLException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("springHibernate.xml");
        ComboPooledDataSource dataSource = (ComboPooledDataSource) ctx.getBean("dataSource");
        SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        PhoneService phoneService = (PhoneService) ctx.getBean("phoneService");
        System.out.println(dataSource.getConnection());
        System.out.println(sessionFactory);
        System.out.println("phoneService.getManufactureById(1)=" + phoneService.getManufactureById(1));
        System.out.println("phoneService.getSaleDateById(1)=" + phoneService.getSaleDateById(1));
/*        System.out.println("phoneService.updateManufactureById(1)=" + phoneService.updateManufactureById("cccody", 1));
        System.out.println("phoneService.addPhone=" + phoneService.addPhone("nnewphone", "nnncity"));*/
//        phoneService.addPhone1("nnewphone22", "nnncity22");

        phoneService.testTransaction("manu"+new Date(), "city"+new Date(), 1);
    }
}
