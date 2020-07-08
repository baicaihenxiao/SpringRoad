package club.cser.springroad.beans.dao;

import org.springframework.stereotype.Repository;

/*
这里不用写@Repository，可以写，但是BaseService<T>里一定要用@Autowired注入，不能用@Resource，否则按名字注入，子类永远注入的都是BaseRepository。
    @Autowired
    private BaseRepository<T> baseRepository;
 */
public class BaseRepository<T> {

}
