package club.cser.springroad.jdbc.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration // 创建bean
@EnableTransactionManagement
@PropertySource("classpath:db.properties") // 读取properties文件
public class JdbcTemplateBean {

    @Autowired
    Environment env;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setJdbcUrl(env.getProperty("jdbc.jdbcUrl"));
        try {
            dataSource.setDriverClass(env.getProperty("jdbc.driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("jdbc.initPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("jdbc.maxPoolSize")));
        return dataSource;
    }

//    the bean name will be the same as the method name
//    如果不设置name的话，bean的名字就是getJdbcTemplate
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean(name = "transactionManager")
    public TransactionManager getTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(getDataSource());
        return dataSourceTransactionManager;
    }
}
