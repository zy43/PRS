create table tbl_goods_daylog
(
    id                    bigint(19)                 not null
        primary key,
    log_date              date                       not null comment '日期',
    goods_id              bigint(19)                 not null comment '商品id',
    increase_day_playback bigint(19)                 null comment '商品日浏览量增量',
    increase_day_sales    bigint(19)                 null comment '日销量增量',
    increase_day_revideo  bigint(19)                 null comment '每日增长关联视频数',
    increase_day_relabro  bigint(19)                 null comment '每日增长关联博主数',
    create_time           datetime                   null comment '创建时间',
    modified_time         datetime                   null comment '修改时间',
    deleted               tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (1, '2022-12-12', 2222, 158, 759, 419, 434, '2022-12-17 05:05:07', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (2, '2022-12-03', 3333, 429, 859, 608, 473, '2022-12-17 04:06:08', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (3, '2022-12-17', 3333, 993, 214, 670, 546, '2022-12-17 20:31:57', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (4, '2022-12-09', 4444, 115, 607, 410, 544, '2022-12-17 13:27:48', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (5, '2022-12-10', 5555, 482, 104, 764, 517, '2022-12-17 16:18:45', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (6, '2022-12-10', 1111, 21, 18, 490, 479, '2022-12-17 21:29:47', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (7, '2022-12-10', 4444, 191, 162, 297, 182, '2022-12-17 17:24:39', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (8, '2022-12-01', 2222, 782, 383, 917, 189, '2022-12-17 08:15:44', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (9, '2022-12-08', 3333, 907, 882, 255, 705, '2022-12-17 15:03:59', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (10, '2022-12-01', 8888, 735, 664, 656, 963, '2022-12-17 13:22:09', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (11, '2023-02-21', 2222, 735, 564, 45645, 888, '2023-02-12 03:14:23', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (12, '2023-02-12', 8888, 546, 733, 15468, 654231, '2023-02-12 03:14:53', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (13, '2023-02-12', 3333, 712, 564, 546456, 456465, '2023-02-12 03:15:21', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (14, '2023-02-12', 8888, 54654, 214, 546546, 6521, '2023-02-12 03:15:46', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (15, '2023-02-12', 2222, 564, 484564, 1354354, 564654, '2023-02-12 03:16:10', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (16, '2023-02-10', 1111, 21, 18, 469, 548, '2023-02-11 03:16:32', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (17, '2023-02-02', 3333, 116, 179, 189, 4023, '2023-02-12 03:16:56', null, 0);
INSERT INTO linglingbo.tbl_goods_daylog (id, log_date, goods_id, increase_day_playback, increase_day_sales, increase_day_revideo, increase_day_relabro, create_time, modified_time, deleted) VALUES (18, '2023-02-04', 8888, 1231235, 54654, 189, 483, '2023-02-12 03:17:23', null, 0);
