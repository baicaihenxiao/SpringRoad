package club.cser.springroad.beans.client;

import club.cser.springroad.beans.controller.AddressController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotation.xml");

        AddressController addressController = (AddressController)ctx.getBean("addressControllerrrrr");
        AddressController addressController1 = ctx.getBean(AddressController.class);

        System.out.println(addressController == addressController1);

    }
}
