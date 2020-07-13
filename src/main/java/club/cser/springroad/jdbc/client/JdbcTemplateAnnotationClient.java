package club.cser.springroad.jdbc.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateAnnotationClient {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("club.cser.springroad.jdbc.dao");
        ctx.refresh();

        DataSource dataSource = ctx.getBean(DataSource.class);
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");

        System.out.println(dataSource);
        System.out.println(jdbcTemplate);

        String sql = "UPDATE hello SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, "spring 33333", 1);

    }
}
