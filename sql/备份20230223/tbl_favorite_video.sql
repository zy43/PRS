create table tbl_favorite_video
(
    id            bigint                     not null comment '主键'
        primary key,
    admin_id      bigint(19)                 not null comment '用户ID',
    video_id      bigint(19)                 not null comment '视频ID',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '视频收藏表';

INSERT INTO linglingbo.tbl_favorite_video (id, admin_id, video_id, create_time, modified_time, deleted) VALUES (1369946214293504, 1364909252878336, 1111, '2022-12-29 15:07:05', null, 0);
INSERT INTO linglingbo.tbl_favorite_video (id, admin_id, video_id, create_time, modified_time, deleted) VALUES (1369946221051904, 1364909252878336, 2222, '2022-12-29 15:07:13', null, 0);
INSERT INTO linglingbo.tbl_favorite_video (id, admin_id, video_id, create_time, modified_time, deleted) VALUES (1373076950614016, 1364909252878336, 3333, '2023-02-11 20:42:04', null, 0);
INSERT INTO linglingbo.tbl_favorite_video (id, admin_id, video_id, create_time, modified_time, deleted) VALUES (1373076980719616, 1364909252878336, 4444, '2023-02-11 20:42:41', null, 0);
INSERT INTO linglingbo.tbl_favorite_video (id, admin_id, video_id, create_time, modified_time, deleted) VALUES (1373076983185408, 1364909252878336, 5555, '2023-02-11 20:42:44', null, 0);
