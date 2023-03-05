create table tbl_video_daylog
(
    id                 bigint(19)                 not null
        primary key,
    log_date           date                       not null comment '日期',
    video_id           bigint(19)                 not null comment '视频id',
    video_day_likes    bigint(19)                 null,
    video_day_comments bigint(19)                 null,
    video_day_shares   bigint(19)                 null,
    create_time        datetime                   null comment '创建时间',
    modified_time      datetime                   null comment '修改时间',
    deleted            tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (1, '2022-12-16', 1111, 807, 797, 232, '2022-12-17 22:49:19', null, 0);
INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (2, '2022-12-02', 2222, 288, 692, 32, '2022-12-17 14:19:02', null, 0);
INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (3, '2022-12-15', 3333, 770, 105, 726, '2022-12-17 07:02:02', null, 0);
INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (4, '2022-12-07', 4444, 596, 356, 754, '2022-12-17 10:42:40', null, 0);
INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (5, '2022-12-13', 1111, 178, 37, 450, '2022-12-17 03:06:09', null, 0);
INSERT INTO linglingbo.tbl_video_daylog (id, log_date, video_id, video_day_likes, video_day_comments, video_day_shares, create_time, modified_time, deleted) VALUES (6, '2022-12-04', 5555, 942, 850, 501, '2022-12-17 15:10:36', null, 0);
