package club.cser.springroad.jdbc.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HelloDaoConfig.class)
public class HelloDaoTest {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    HelloDao helloDao;

    @Test
    public void updateNameByIdTest() {
        Assert.assertNotNull(helloDao);
        Assert.assertNotNull(jdbcTemplate);

        String name  = "spring kkkkkkkk";
        Integer id = 1;

        Assert.assertTrue(helloDao.updateNameById(name, id));
    }


}
