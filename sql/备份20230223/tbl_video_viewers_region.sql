create table tbl_video_viewers_region
(
    id               bigint(19) auto_increment
        primary key,
    video_id         bigint(19)                 not null,
    viewers_province varchar(64)                null,
    viewers_city     varchar(64)                null,
    proportion       double(3, 2)               null,
    city_max         varchar(20)                null,
    province_max     varchar(20)                null,
    create_time      datetime                   null comment '创建时间',
    modified_time    datetime                   null comment '修改时间',
    deleted          tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_viewers_region (id, video_id, viewers_province, viewers_city, proportion, city_max, province_max, create_time, modified_time, deleted) VALUES (1, 1111, '浙江', '杭州', 0.15, '#杭州#', '#浙江#', null, null, 0);
INSERT INTO linglingbo.tbl_video_viewers_region (id, video_id, viewers_province, viewers_city, proportion, city_max, province_max, create_time, modified_time, deleted) VALUES (2, 2222, '浙江', '宁波', 0.1, '#杭州#', '#浙江#', null, null, 0);
INSERT INTO linglingbo.tbl_video_viewers_region (id, video_id, viewers_province, viewers_city, proportion, city_max, province_max, create_time, modified_time, deleted) VALUES (3, 3333, '浙江', '温州', 0.05, '#杭州#', '#浙江#', null, null, 0);
INSERT INTO linglingbo.tbl_video_viewers_region (id, video_id, viewers_province, viewers_city, proportion, city_max, province_max, create_time, modified_time, deleted) VALUES (4, 4444, '江苏', '南京', 0.11, '#杭州#', '#浙江#', null, null, 0);
INSERT INTO linglingbo.tbl_video_viewers_region (id, video_id, viewers_province, viewers_city, proportion, city_max, province_max, create_time, modified_time, deleted) VALUES (5, 5555, '江苏', '扬州', 0.05, '#杭州#', '#浙江#', null, null, 0);
