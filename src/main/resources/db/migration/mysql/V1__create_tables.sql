DROP TABLE IF EXISTS `user`;

CREATE TABLE `users`
(
    `id`        bigint                    NOT NULL AUTO_INCREMENT,
    `name`      varchar(255)              NOT NULL,
    `surname`   varchar(255) DEFAULT NULL,
    `username`  varchar(255)              NOT NULL unique ,
    `password`  varchar(255)              NOT NULL,
    `user_type` enum ('MANAGER','WAITER') NOT NULL,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `tables`;

CREATE TABLE `tables`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `number`       int    NOT NULL,
    `chairs_count` int    NOT NULL,
    `user_id`    bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    CONSTRAINT `table_c_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
);


DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) NOT NULL,
    `order_status`  enum ('OPEN','CANCELLED','CLOSED','') DEFAULT NULL,
    `table_id` bigint       NOT NULL,
    PRIMARY KEY (`id`),
    KEY `table_id` (`table_id`),
    CONSTRAINT `order_c_1` FOREIGN KEY (`table_id`) REFERENCES `tables` (`id`)
);


DROP TABLE IF EXISTS `products`;

CREATE TABLE `products`
(
    `id`    bigint       NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) NOT NULL,
    `price` double       NOT NULL,
    PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `product_in_orders`;

CREATE TABLE `product_in_orders`
(
    `id`                      bigint                      NOT NULL AUTO_INCREMENT,
    `amount`                  int                         NOT NULL,
    `product_in_order_status` enum ('ACTIVE','CANCELLED') NOT NULL,
    `order_id`           bigint                      NOT NULL,
    `product_id`              bigint                      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `order_id` (`order_id`),
    KEY `product_id` (`product_id`),
    CONSTRAINT `product_in_order_c_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
    CONSTRAINT `product_in_order_c_2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
);






