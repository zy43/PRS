create table tbl_streamer_daylog
(
    id            bigint(19)                 not null
        primary key,
    log_date      date                       not null comment '日期',
    streamer_id   bigint(19)                 not null comment '抖音id',
    day_fans      bigint(19)                 null,
    day_videos    bigint(19)                 null,
    day_likes     bigint(19)                 null,
    day_comments  bigint(19)                 null,
    day_shares    bigint(19)                 null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (1, '2023-02-21', 1364916962402304, 111, 11, 111, 111, 111, '2022-12-17 20:40:25', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (2, '2023-02-20', 1364916962402304, 222, 22, 222, 222, 222, '2022-12-17 20:45:04', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (3, '2022-12-02', 1111111, 3333, 3333, 3333, 3333, 3333, '2022-12-17 20:46:30', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (4, '2022-12-17', 1234567, 33311, 22, 1122, 11111, 1111, '2022-12-17 20:46:50', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (5, '2022-12-12', 1234567, 11, 21, 11111, 55555, 1111, '2022-12-17 20:47:26', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (6, '2022-12-13', 7654321, 123, 12, 22222, 1111, 2222, '2022-12-17 20:47:28', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (7, '2022-12-01', 1111111, 321, 6, 33333, 2222, 333, '2022-12-17 20:47:31', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (8, '2022-12-15', 1234567, 12345, 22, 4444, 3333, 11111, '2022-12-17 20:47:33', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (9, '2023-02-12', 7654321, 123456, 478, 35464523, 1315, 1232, '2023-02-12 03:52:30', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (10, '2023-02-12', 1234567, 15654, 5465, 56465465, 1321, 123, '2023-02-12 03:52:51', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (11, '2023-02-12', 1111111, 3215, 16546, 54546, 999, 1333, '2023-02-12 03:52:59', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (12, '2023-02-12', 7654321, 123, 5613, 13546, 9884, 1234567, '2023-02-12 03:54:01', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (13, '2023-01-19', 1234567, 1347, 1572, 1546, 5635163, 78613, '2023-02-12 03:54:28', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (14, '2023-01-24', 1234567, 854, 35465, 35465, 2313544, 213, '2023-02-12 03:55:24', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (15, '2022-11-04', 1111111, 54645, 156456, 354648, 546, 1354, '2023-02-12 03:56:00', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (16, '2022-12-12', 1234567, 111, 11, 111, 111, 111, '2022-12-17 20:40:25', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (17, '2022-12-14', 7654321, 222, 22, 222, 222, 222, '2022-12-17 20:45:04', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (18, '2022-12-02', 1111111, 3333, 3333, 3333, 3333, 3333, '2022-12-17 20:46:30', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (19, '2022-12-17', 1234567, 33311, 22, 1122, 11111, 1111, '2022-12-17 20:46:50', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (20, '2022-12-12', 1234567, 11, 21, 11111, 55555, 1111, '2022-12-17 20:47:26', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (21, '2022-12-13', 7654321, 123, 12, 22222, 1111, 2222, '2022-12-17 20:47:28', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (22, '2022-12-01', 1111111, 321, 6, 33333, 2222, 333, '2022-12-17 20:47:31', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (23, '2022-12-15', 1364982471729152, 10, 22, 4444, 3333, 11111, '2022-12-17 20:47:33', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (24, '2022-12-17', 1364982471729152, 20, 10, 14, 123, 123, '2022-12-17 16:08:56', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (25, '2022-12-16', 1364982471729152, 11, 12, 13, 513, 163, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (26, '2022-12-18', 1364982471729152, 35, 135, 158, 153, 153, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (27, '2022-12-19', 1364982471729152, 23, 56, 592, 235, 234, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (28, '2022-12-20', 1364982471729152, 16, 115, 894, 26, 123, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (29, '2022-12-21', 1364982471729152, 13, 48, 43, 13, 1, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (30, '2022-12-22', 1364982471729152, 15, 61, 894, 1, 6, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (31, '2022-12-22', 81234567, 513, 1513, 153, 813, 1538, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (32, '2022-12-22', 67654321, 653, 59, 26, 29, 26, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (33, '2022-12-23', 51234567, 135, 153, 51, 153, 1, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (34, '2022-12-22', 41234567, 26, 262, 9523, 92, 13, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (35, '2022-12-22', 31111111, 13, 15, 81, 81, 3, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (36, '2022-12-22', 7654321, 51, 61, 81, 34, 13, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (37, '2022-12-22', 1234567, 513, 451, 138, 138, 13, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (38, '2022-12-15', 1364909252878336, 10, 22, 4444, 3333, 11111, '2022-12-17 20:47:33', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (39, '2022-12-17', 1364909252878336, 20, 10, 14, 123, 123, '2022-12-17 16:08:56', null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (40, '2022-12-16', 1364909252878336, 11, 12, 13, 513, 163, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (41, '2022-12-18', 1364909252878336, 35, 135, 158, 153, 153, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (42, '2022-12-19', 1364909252878336, 23, 56, 592, 235, 234, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (43, '2022-12-20', 1364909252878336, 16, 115, 894, 26, 123, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (44, '2022-12-21', 1364909252878336, 13, 48, 43, 13, 1, null, null, 0);
INSERT INTO linglingbo.tbl_streamer_daylog (id, log_date, streamer_id, day_fans, day_videos, day_likes, day_comments, day_shares, create_time, modified_time, deleted) VALUES (45, '2022-12-22', 1364909252878336, 15, 61, 894, 1, 6, null, null, 0);
