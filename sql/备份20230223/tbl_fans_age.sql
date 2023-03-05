create table tbl_fans_age
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    streamer_id   bigint(19)                 not null comment '抖音ID',
    group6_17     double(3, 2)               null,
    group18_24    double(3, 2)               null comment '粉丝年龄段',
    group25_30    double(3, 2)               null comment '占比',
    group31_35    double(3, 2)               null,
    group36_40    double(3, 2)               null,
    group41       double(3, 2)               null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (1, 1364916962402304, 0.32, 0.28, 0.15, 0.05, 0.1, 0.1, '2023-02-12 07:24:41', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (2, 1366909789347840, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 15:17:21', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (3, 1366910520090624, 0.32, 0.28, 0.15, 0.05, 0.1, 0.1, '2023-02-12 20:09:35', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (4, 1366910530576384, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 00:37:13', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (5, 1366911297290240, 0.32, 0.28, 0.15, 0.05, 0.1, 0.1, '2023-02-12 07:48:54', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (6, 1366911892504576, 0.11, 0.49, 0.32, 0.05, 0.02, 0.01, '2023-02-12 00:13:52', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (7, 1366911899926528, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 07:29:51', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (8, 1368388863582208, 0.32, 0.28, 0.15, 0.05, 0.1, 0.1, '2023-02-12 10:24:05', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (9, 1368390327246848, 0.11, 0.49, 0.32, 0.05, 0.02, 0.01, '2023-02-12 05:50:30', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (10, 1372999360520192, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 13:16:33', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (11, 1372999360520193, 0.11, 0.49, 0.32, 0.05, 0.02, 0.01, '2023-02-12 02:50:00', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (12, 1372999360520194, 0.32, 0.28, 0.15, 0.05, 0.1, 0.1, '2023-02-12 16:05:49', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (13, 1372999360520195, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 15:27:39', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (14, 1372999360520196, 0.11, 0.49, 0.32, 0.05, 0.02, 0.01, '2023-02-12 20:12:23', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (15, 1372999360520197, 0.22, 0.38, 0.14, 0.06, 0.09, 0.11, '2023-02-12 04:30:23', null, 0);
INSERT INTO linglingbo.tbl_fans_age (id, streamer_id, group6_17, group18_24, group25_30, group31_35, group36_40, group41, create_time, modified_time, deleted) VALUES (16, 1364982471729152, 0.3, 0.2, 0.15, 0.05, 0.15, 0.15, '2023-02-13 16:47:38', null, 0);
