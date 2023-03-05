create table tbl_video_viewers_sex
(
    id                bigint(19) auto_increment
        primary key,
    video_id          bigint(19)                 not null,
    male_proportion   double(3, 2)               not null,
    female_proportion double(3, 2)               not null,
    sex_max           varchar(20)                not null,
    create_time       datetime                   null comment '创建时间',
    modified_time     datetime                   null comment '修改时间',
    deleted           tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_viewers_sex (id, video_id, male_proportion, female_proportion, sex_max, create_time, modified_time, deleted) VALUES (1, 1111, 0.25, 0.75, '#男性#', null, null, 0);
