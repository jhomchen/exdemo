CREATE DATABASE `sms_demo` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `songs_detail` (
  `s_id` int NOT NULL,
  `s_name` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `s_ablum` varchar(100) COLLATE utf8mb3_bin NOT NULL,
  `s_link` varchar(200) COLLATE utf8mb3_bin NOT NULL,
  `s_cate` varchar(45) COLLATE utf8mb3_bin NOT NULL COMMENT '分类',
  `s_desc` varchar(100) COLLATE utf8mb3_bin DEFAULT NULL,
  `s_date` datetime NOT NULL,
  PRIMARY KEY (`s_id`),
  UNIQUE KEY `s_id_UNIQUE` (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin COMMENT='歌曲表';
