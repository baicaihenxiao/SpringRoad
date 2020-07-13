package club.cser.springroad.jdbc.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration // 不加 @Configuration 也可以，但是不知道为什么都加了
@ComponentScan("club.cser.springroad.jdbc.dao")
public class HelloDaoConfig {
}
