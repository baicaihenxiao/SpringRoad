package club.cser.springroad.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class HelloDao {

    @Resource
    JdbcTemplate jdbcTemplate;


    public boolean updateNameById(String name, Integer id) {
        String sql = "UPDATE hello SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, name, id) == 1;
    }

}
