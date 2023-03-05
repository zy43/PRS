create table tbl_video_viewers_age
(
    id            bigint(19)                 not null
        primary key,
    video_id      bigint(19)                 not null,
    group6_17     double(3, 2)               null,
    group18_24    double(3, 2)               null,
    group25_30    double(3, 2)               null,
    group31_35    double(3, 2)               null,
    group36_40    double(3, 2)               null,
    group41       double(3, 2)               null,
    age_max       varchar(20)                null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_viewers_age (id, video_id, group617, group1824, group2530, group3135, group3640, group41, age_max, create_time, modified_time, deleted) VALUES (1, 1111, 0.1, 0.2, 0.3, 0.3, 0.05, 0.05, '#18-24#', null, null, 0);
