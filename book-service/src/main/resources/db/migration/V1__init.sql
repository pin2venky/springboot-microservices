DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` bigint NOT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `published_year` smallint NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `emal` varchar(255) DEFAULT NULL,
  `mobile_no` smallint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `book` VALUES (1,'Venkatesh',2018,'Master Java'),(2,'Shanvika',2019,'Be Happy');