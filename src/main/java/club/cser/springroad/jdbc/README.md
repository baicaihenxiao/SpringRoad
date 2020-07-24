# 学习 Spring 连接数据库， @Transactional

## `JdbcTemplateClient`
xml方式配置dataSource、JdbcTemplate连接数据库

## `JdbcTemplateAnnotationClient`
注释方式, JdbcTemplateBean里配置dataSource、JdbcTemplate连接数据库

## `TransactionClient`
注释方式，JdbcTemplateBean里还配置了transactionManager, 测试 REQUIRED 抛异常回滚

## `TransactionRequiredNewClient`
测试 RequiredNew 抛异常回滚
