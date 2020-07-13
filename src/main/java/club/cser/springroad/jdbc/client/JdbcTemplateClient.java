package club.cser.springroad.jdbc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateClient {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-bean.xml");

        DataSource dataSource = ctx.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");

        System.out.println(dataSource);
        System.out.println(jdbcTemplate);

        String sql = "UPDATE hello SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "spring kkkkkjdbc", 1);

    }
}
