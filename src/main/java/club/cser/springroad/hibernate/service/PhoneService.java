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

    public boolean updateManufactureById(String manufacture, Integer id) {
        return phoneDao.updateManufactureById(manufacture, id);
    }

    public boolean addPhone(String manufacture, String city) {
        return phoneDao.addPhone(manufacture, city);
    }

    public void addPhone1(String manufacture, String city) {
        phoneDao.addPhone1(manufacture, city);
    }

    public void testTransaction(String manufacture, String city, Integer id) {

        phoneDao.addPhone(manufacture, city);

        if (id == 1) {
            throw new IllegalArgumentException("测试transaction");
        }

        phoneDao.updateManufactureById(manufacture, id);

    }
}
