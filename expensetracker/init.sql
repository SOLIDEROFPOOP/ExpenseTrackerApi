CREATE TABLE `tbl_users` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `age` bigint DEFAULT NULL,
                             `created_at` datetime(6) NOT NULL,
                             `email` varchar(255) DEFAULT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `password` varchar(255) DEFAULT NULL,
                             `updated_at` datetime(6) DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `UK_j562wwmipqt96rkoqbo0jc34` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_expenses` (
                                `id` bigint NOT NULL AUTO_INCREMENT,
                                `expense_amount` decimal(38,2) NOT NULL,
                                `category` varchar(255) DEFAULT NULL,
                                `created_at` datetime(6) NOT NULL,
                                `date` date NOT NULL,
                                `description` varchar(255) DEFAULT NULL,
                                `expense_name` varchar(255) DEFAULT NULL,
                                `updated_at` datetime(6) DEFAULT NULL,
                                `user_id` bigint NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `FKaogtcbm8nm6qdgq36q29m947v` (`user_id`),
                                CONSTRAINT `FKaogtcbm8nm6qdgq36q29m947v` FOREIGN KEY (`user_id`) REFERENCES `tbl_users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


