package club.cser.springroad.hibernate.service;

import club.cser.springroad.hibernate.dao.PhoneDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class PhoneService {
    @Resource
    private PhoneDao phoneDao;

    public String getManufactureById(Integer id) {
        return phoneDao.getManufactureById(id);
    }

    public Date getSaleDateById(Integer id) {
        return phoneDao.getSaleDateById(id);
    }
}
