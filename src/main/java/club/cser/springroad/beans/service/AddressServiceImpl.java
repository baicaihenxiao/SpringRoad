package club.cser.springroad.beans.service;


import org.springframework.stereotype.Service;

@Service(value = "addressService00000")
public class AddressServiceImpl implements AddressService {

    public AddressServiceImpl() {
        System.out.println("create AddressServiceImpl...");
    }

    @Override
    public String getAddressInfo() {

        System.out.println("club.cser.springroad.beans.service.AddressServiceImpl.getAddressInfo...");
        return null;
    }
}
