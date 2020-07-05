package club.cser.springroad.beans.controller;

import club.cser.springroad.beans.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AddressControllerImpl implements AddressController {

//    @Resource(name = "addressServiceImpl")
//    @Resource(type = AddressServiceImpl.class)
//    @Resource(type = AddressService.class) 都可以
    @Resource
    AddressService addressService;

    public AddressControllerImpl() {
        System.out.println("create AddressControllerImpl...");
    }

    @Override
    public String getAddressInfo() {

        return addressService.getAddressInfo();
    }
}
