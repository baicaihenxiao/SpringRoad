package club.cser.springroad.beans.service;

import org.springframework.stereotype.Service;

// 默认bean的名字是addressServiceV2Impl
@Service
public class AddressServiceV2Impl implements AddressService {

    public AddressServiceV2Impl() {
        System.out.println("create AddressServiceVVV222Impl...");
    }


    @Override
    public String getAddressInfo() {
        System.out.println("club.cser.springroad.beans.service.AddressServiceVVV222Impl.getAddressInfo...");
        return null;
    }
}
