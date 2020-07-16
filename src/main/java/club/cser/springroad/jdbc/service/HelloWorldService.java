package club.cser.springroad.jdbc.service;

import club.cser.springroad.jdbc.dao.HelloDao;
import club.cser.springroad.jdbc.dao.WorldDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class HelloWorldService {


    @Resource
    private HelloDao helloDao;

    @Resource
    private WorldDao worldDao;

    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateHelloWorld(String city, String name, Integer id, Boolean rollback) {

        helloDao.updateNameById(name, id);

/*        try {
            if (rollback) {
                throw new RuntimeException("rolllllbaaackkk");
            }
        } catch (RuntimeException e) {
            System.out.println("eeeeeee");
        }*/

        if (rollback) {
            throw new RuntimeException("rolllllbaaackkk");
        }

        worldDao.updateCityById(city, id);

    }

}
