drop database if exists `chen`;
create database `chen`;
use chen;

# 用户表
DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `user`
(
    `id`             int(5)       NOT NULL AUTO_INCREMENT comment '唯一id',
    `username`       varchar(256) NOT NULL default '' comment '用户名',
    `password`       varchar(64)           DEFAULT NULL default '123456' comment '用户密码',
    `name`           varchar(256)          DEFAULT NULL default '' comment '用户名字',
    `user_type`      int(2)       NOT NULL DEFAULT '0' comment '用户类别：0-教师，1-专家，2-领导，3-管理员',
    `level`          int(2)       NOT NULL DEFAULT '0' comment '用户级别：0-院级，1-校级',
    `sex`            varchar(4)   not null default '男' comment '用户性别',
    `create_time`    timestamp             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp             DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_AREA` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4;

# 公告表
drop table if exists `announcement`;
create table `announcement`
(
    `id`             int(5)        not null auto_increment comment '唯一id',
    `content`        varchar(2048) not null default '' comment '公告内容',
    `title`          varchar(256)  not null default '' comment '公告标题',
    `create_time`    timestamp              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    `flag`           int(1)                 default 0 comment '是否发布，0-不发布，1-发布',
    primary key (`id`)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;

# 评价表
drop table if exists `appraise`;
create table `appraise`
(
    `id`             int(5)        not null auto_increment comment '唯一id',
    `leader_id`      int(5)        not null comment '领导id',
    `teacher_id`     int(5)        not null comment '教师id',
    `content`        varchar(1024) not null default '' comment '评价内容',
    `create_time`    timestamp              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;

# 课程表
drop table if exists `course`;
create table `course`
(
    `id`             int(5)        not null auto_increment comment '唯一id',
    `teacher_id`     int(5)        not null comment '教师id',
    `capacity`       int(5)        not null comment '课程容量',
    `course_name`    varchar(256)  not null default '' comment '课程名',
    `place`          varchar(256)  not null default '' comment '上课地点',
    `college`        varchar(256)  not null default '' comment '所属学院',
    `content`        varchar(1024) not null default '' comment '评价内容',
    `start_time`     timestamp              DEFAULT CURRENT_TIMESTAMP COMMENT '开课时间',
    `end_time`       timestamp              DEFAULT CURRENT_TIMESTAMP COMMENT '结束时间',
    `create_time`    timestamp              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp              DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;

# 选课表
drop table if exists `elective`;
create table `elective`
(
    `id`             int(5) not null auto_increment comment '唯一id',
    `user_id`        int(5) not null comment '选课用户id',
    `course_id`      int(5) not null comment '课程id',
    `finish`         int(1) not null default 0 comment '是否完成：0-未完成，1-完成',
    `create_time`    timestamp       DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;

# 督导表
drop table if exists `supervision`;
create table `supervision`
(
    `id`             int(5) not null auto_increment comment '唯一id',
    `user_id`        int(5) not null comment '选课用户id',
    `amount`         int(5) not null comment '任务总量',
    `finish`         int(5) not null default 0 comment '完成数量',
    `create_time`    timestamp       DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;

# 问卷
drop table if exists `questionnaire`;
create table `questionnaire`
(
    `id`             int(5) not null auto_increment comment '问卷唯一id',
    `user_id`        int(5) not null comment '评价用户id',
    `teacher_id`     int(5) not null comment '教师id',
    `course_id`      int(5) not null comment '课程id',
    `attitude`       int(5) not null default 0 comment '教学态度',
    `content`        int(5) not null default 0 comment '教学内容',
    `skill`          int(5) not null default 0 comment '教学技巧',
    `effect`         int(5) not null default 0 comment '教学效果',
    `feature`        int(5) not null default 0 comment '教学特点',
    `total`          int(5) not null default 0 comment '总分',
    `create_time`    timestamp       DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_edit_time` timestamp       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    primary key (id)
) engine = InnoDB
  auto_increment = 1
  default charset = utf8mb4;