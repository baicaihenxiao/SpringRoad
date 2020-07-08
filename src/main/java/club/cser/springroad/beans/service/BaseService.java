package club.cser.springroad.beans.service;

import club.cser.springroad.beans.dao.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 这里不能写 @Service， baseRepository有两个子类，不知道注入哪个
public class BaseService<T> {

    @Autowired
    private BaseRepository<T> baseRepository;

    public void getRepository() {
        System.out.println("getRepository...");
        System.out.println("repository = " + baseRepository);
    }
}
