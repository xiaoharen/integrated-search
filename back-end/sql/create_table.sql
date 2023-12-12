create database if not exists xhr_blog;

use xhr_blog;

create table if not exists essay
(
    id           bigint auto_increment comment 'bid' primary key,
    title        varchar(256)                           not null comment 'title',
    label        varchar(256)                           not null comment 'label',
    content      text                                   null comment 'content',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'createTime',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'updateTime',
    isDelete     tinyint      default 0                 not null comment 'isDelete'
)comment 'essay' collate = utf8mb4_unicode_ci;

create table if not exists book
(
    id           bigint auto_increment comment 'bid' primary key,
    bookName     varchar(256)                           not null comment 'title',
    author       varchar(256)                           not null comment 'label',
    eid          bigint                                 not null comment 'essay id',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'createTime',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'updateTime',
    isDelete     tinyint      default 0                 not null comment 'isDelete'
)comment 'book' collate = utf8mb4_unicode_ci;

create table if not exists footprint
(
    id           bigint auto_increment comment 'bid' primary key,
    place     varchar(256)                           not null comment 'title',
    happenTime       varchar(256)                           not null comment 'label',
    eid          bigint                                 not null comment 'essay id',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'createTime',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'updateTime',
    isDelete     tinyint      default 0                 not null comment 'isDelete'
)comment 'footprint' collate = utf8mb4_unicode_ci;

create table if not exists coding
(
    id           bigint auto_increment comment 'bid' primary key,
    skillName       varchar(256)                           not null comment 'Name',
    skillLevel       varchar(256)                           not null comment 'Level',
    skillDescribe     varchar(512)                                 not null comment 'Describe',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment 'createTime',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment 'updateTime',
    isDelete     tinyint      default 0                 not null comment 'isDelete'
)comment 'coding' collate = utf8mb4_unicode_ci;

