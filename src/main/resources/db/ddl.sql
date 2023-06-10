CREATE DATABASE `spring_boot_web_starter`;

CREATE TABLE user
(
    id                BIGINT AUTO_INCREMENT COMMENT '用户ID',
    create_time       DATETIME COMMENT '创建时间',
    update_time       DATETIME COMMENT '更新时间',
    deleted           TINYINT(1)   DEFAULT false COMMENT '删除标记',
    username          VARCHAR(255) COMMENT '用户名',
    password          VARCHAR(255) COMMENT '密码',
    email             VARCHAR(255) COMMENT '电子邮件',
    phone             VARCHAR(255) COMMENT '手机号码',
    nick_name         VARCHAR(255) COMMENT '昵称',
    registration_date DATETIME COMMENT '注册日期',
    last_login_date   DATETIME COMMENT '最后登录日期',
    last_login_ip     VARCHAR(255) DEFAULT '' COMMENT '最后登录IP',
    user_type         INT          DEFAULT 0 COMMENT '用户类型',
    status            INT          DEFAULT 0 COMMENT '用户状态',
    PRIMARY KEY (id)
) COMMENT ='用户表';
