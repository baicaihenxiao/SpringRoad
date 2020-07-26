package club.cser.springroad.hibernate.service;


import club.cser.springroad.hibernate.dao.ComputerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ComputerService {

    @Resource
    private ComputerDao computerDao;

    public boolean addComputer(String brand, String city) {
        return computerDao.addComputer(brand, city);
    }


}
