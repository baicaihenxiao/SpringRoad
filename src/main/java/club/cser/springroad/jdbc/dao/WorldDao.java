package club.cser.springroad.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class WorldDao {
    @Resource
    JdbcTemplate jdbcTemplate;


    public boolean updateCityById(String city, Integer id) {
        String sql = "UPDATE world SET city = ? WHERE id = ?";
        return jdbcTemplate.update(sql, city, id) == 1;
    }
}
