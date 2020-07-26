package club.cser.springroad.hibernate.client;

import club.cser.springroad.hibernate.entity.Computer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration // 创建bean
@EnableTransactionManagement
@PropertySource("classpath:db.properties") // 读取properties文件
@ComponentScan("club.cser.springroad.hibernate")
public class AppConfig {
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

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(getDataSource());

        Properties props=new Properties();
        props.put("hibernate.show_sql", true);
        props.put("hibernate.format_sql", true);
        // props.put("hibernate.hbm2ddl.auto", "update"); // 这个update实测是第一次创建表，后面即使entity变了也不会改表
        props.put("hibernate.dialect.storage_engine", "innodb");
        factoryBean.setHibernateProperties(props);

        factoryBean.setAnnotatedClasses(Computer.class);
//        factoryBean.setAnnotatedPackages("");
        return factoryBean;
    }

    @Bean(name = "transactionManager")
    public TransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}
