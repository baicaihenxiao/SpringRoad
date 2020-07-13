package club.cser.springroad.jdbc.dao;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class HelloDaoTest {

    JdbcTemplate jdbcTemplate;

    HelloDao helloDao;

    @Before
    public void init() {} {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-bean.xml");
        this.jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        this.helloDao = ctx.getBean(HelloDao.class);
        Assert.assertNotNull(this.jdbcTemplate);
        Assert.assertNotNull(this.helloDao);
    }


    @Test
    public void updateNameByIdTest() {
        String name  = "sprin2222g testtt111";
        Integer id = 1;

        Assert.assertTrue(helloDao.updateNameById(name, id));
    }


}
