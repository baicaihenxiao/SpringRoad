package club.cser.springroad.beans.controller;

import club.cser.springroad.beans.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

// 默认创建bean的名字叫 addressControllerImpl, 这里改成 addressControllerrrrr
@Controller(value = "addressControllerrrrr")
public class AddressControllerImpl implements AddressController {

//    @Resource(name = "addressServiceImpl")
//    @Resource(type = AddressServiceImpl.class)
//    @Resource(type = AddressService.class) 都可以
    @Resource(name = "addressServiceV2Impl") // 注入bean的名字是addressServiceV2Impl
    AddressService addressService;

    AddressService addressService2;

//    @Resource(name = "addressServiceImpl")
    @Resource // 按照参数名addressService00000匹配bean的名字
    public void setAddressService2(AddressService addressService00000) {
        this.addressService2 = addressService00000;
    }

    public AddressControllerImpl() {
        System.out.println("create AddressControllerImpl...");
    }

    @Override
    public String getAddressInfo() {

        return addressService.getAddressInfo();
    }
}
