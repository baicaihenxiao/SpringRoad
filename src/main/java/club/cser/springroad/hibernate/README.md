

# `club.cser.springroad.hibernate.client.HibernateXMLClient`
xml方式配置Hibernate连接数据库

```sql
CREATE TABLE `phone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `manufacture` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `city` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `sale_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```

# `club.cser.springroad.hibernate.client.HibernateAnnotationClient`
注释方式配置Hibernate连接数据库

```sql
CREATE TABLE `computer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `brand` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `city` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `buy_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
```