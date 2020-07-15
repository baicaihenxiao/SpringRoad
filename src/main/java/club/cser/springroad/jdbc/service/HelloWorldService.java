package club.cser.springroad.jdbc.service;

import club.cser.springroad.jdbc.dao.HelloDao;
import club.cser.springroad.jdbc.dao.WorldDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class HelloWorldService {


    @Resource
    HelloDao helloDao;

    @Resource
    WorldDao worldDao;

    @Transactional
    public void updateHelloWorld(String city, String name, Integer id, Boolean rollback) {

        helloDao.updateNameById(name, id);

        if (rollback) {
            throw new RuntimeException("rolllllbaaackkk");
        }

        worldDao.updateCityById(city, id);

    }

}
