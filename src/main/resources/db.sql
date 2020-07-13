CREATE TABLE `hello` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `location` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT (_utf8mb4''),
  `date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;