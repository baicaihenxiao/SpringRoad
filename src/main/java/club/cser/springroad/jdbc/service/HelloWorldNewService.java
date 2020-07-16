package club.cser.springroad.jdbc.service;

import club.cser.springroad.jdbc.dao.HelloDao;
import club.cser.springroad.jdbc.dao.HouseDao;
import club.cser.springroad.jdbc.dao.WorldDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
public class HelloWorldNewService {

    @Resource
    private HelloDao helloDao;

    @Resource
    private WorldDao worldDao;

    @Resource
    private HouseDao houseDao;

    @Resource
    private HelloWorldService helloWorldService;

    @Transactional
    public void transactionNewHelloWorld(String city, String name, Integer id, Boolean rollback) {

//        helloWorldService.updateHelloWorld("helloWorldService111" + city, "helloWorldService111" + name, id, rollback);

        System.out.println("111");


//        helloDao.updateNameById("helloDao" + name, id); 会死锁

        houseDao.updateNameById("houseDao" + name, id);

        System.out.println("222");

        helloWorldService.updateHelloWorld("helloWorldService222" + city, "helloWorldService222" + name, id, true);


//        try {
//
//        } catch (RuntimeException e) {
//            System.out.println("eeeeeee1" + Arrays.toString(e.getStackTrace()));
//        }

        System.out.println("333");

    }
}
