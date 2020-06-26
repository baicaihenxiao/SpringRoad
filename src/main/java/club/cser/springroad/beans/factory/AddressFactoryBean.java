package club.cser.springroad.beans.factory;

import club.cser.springroad.beans.entity.Address;
import org.springframework.beans.factory.FactoryBean;

public class AddressFactoryBean implements FactoryBean {

    private String city;

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Address getObject() throws Exception {
        Address address = new Address();
        address.setCity(city);
        address.setStreet("FactoryBeanStreet");
        address.setCode(9527);
        return address;
    }

    @Override
    public Class<?> getObjectType() {
        return Address.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
