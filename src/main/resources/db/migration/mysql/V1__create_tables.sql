DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`        bigint                    NOT NULL AUTO_INCREMENT,
    `name`      varchar(255)              NOT NULL,
    `surname`   varchar(255) DEFAULT NULL,
    `username`  varchar(255)              NOT NULL,
    `password`  varchar(255)              NOT NULL,
    `user_type` enum ('MANAGER','WAITER') NOT NULL,
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `cafe_table`;

CREATE TABLE `cafe_table`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `number`       int    NOT NULL,
    `chairs_count` int    NOT NULL,
    `waiter_id`    bigint NOT NULL,
    PRIMARY KEY (`id`),
    KEY `waiter_id` (`waiter_id`),
    CONSTRAINT `cafe_table_ibfk_1` FOREIGN KEY (`waiter_id`) REFERENCES `user` (`id`)
);


DROP TABLE IF EXISTS `cafe_order`;

CREATE TABLE `cafe_order`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `name`          varchar(255) NOT NULL,
    `order_status`  enum ('OPEN','CANCELLED','CLOSED','') DEFAULT NULL,
    `cafe_table_id` bigint       NOT NULL,
    PRIMARY KEY (`id`),
    KEY `cafe_table_id` (`cafe_table_id`),
    CONSTRAINT `cafe_order_ibfk_1` FOREIGN KEY (`cafe_table_id`) REFERENCES `cafe_table` (`id`)
);


DROP TABLE IF EXISTS `product`;

CREATE TABLE `product`
(
    `id`    bigint       NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) NOT NULL,
    `price` double       NOT NULL,
    PRIMARY KEY (`id`)
);



DROP TABLE IF EXISTS `product_in_order`;

CREATE TABLE `product_in_order`
(
    `id`                      bigint                      NOT NULL AUTO_INCREMENT,
    `amount`                  int                         NOT NULL,
    `product_in_order_status` enum ('ACTIVE','CANCELLED') NOT NULL,
    `cafe_order_id`           bigint                      NOT NULL,
    `product_id`              bigint                      NOT NULL,
    PRIMARY KEY (`id`),
    KEY `cafe_order_id` (`cafe_order_id`),
    KEY `product_id` (`product_id`),
    CONSTRAINT `product_in_order_ibfk_1` FOREIGN KEY (`cafe_order_id`) REFERENCES `cafe_order` (`id`),
    CONSTRAINT `product_in_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
);






