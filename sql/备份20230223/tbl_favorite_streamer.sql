create table tbl_favorite_streamer
(
    id            bigint                     not null comment '主键'
        primary key,
    admin_id      bigint(19)                 not null comment '用户ID',
    streamer_id   bigint(19)                 not null comment '主播ID',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '主播收藏表';

INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1369946165362688, 1364909252878336, 1366909789347840, '2022-12-29 15:06:05', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1369946172465152, 1364909252878336, 1366910520090624, '2022-12-29 15:06:14', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1369946177904640, 1364909252878336, 1366910530576384, '2022-12-29 15:06:20', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1373076486135808, 1364909252878336, 1366911297290240, '2023-02-11 20:32:37', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1373076529790976, 1364909252878336, 1366911892504576, '2023-02-11 20:33:31', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1373076538662912, 1364909252878336, 1366911899926528, '2023-02-11 20:33:42', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1373076545650688, 1364909252878336, 1368388863582208, '2023-02-11 20:33:50', null, 0);
INSERT INTO linglingbo.tbl_favorite_streamer (id, admin_id, streamer_id, create_time, modified_time, deleted) VALUES (1373076551958528, 1364909252878336, 1368390327246848, '2023-02-11 20:33:58', null, 0);
