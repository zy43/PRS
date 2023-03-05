create table tbl_video_classification
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    video_id      bigint(19)                 not null comment '视频ID',
    tag           varchar(10)                not null comment '标签名称',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0否1是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_classification (id, video_id, tag, create_time, modified_time, deleted) VALUES (1, 3305042, '搞笑', '2020-06-02 20:04:12', '2020-06-03 20:04:20', 0);
INSERT INTO linglingbo.tbl_video_classification (id, video_id, tag, create_time, modified_time, deleted) VALUES (2, 3353012, '网红美女', '2020-06-01 20:07:20', '2020-06-03 20:07:25', 0);
INSERT INTO linglingbo.tbl_video_classification (id, video_id, tag, create_time, modified_time, deleted) VALUES (3, 2365788, '游戏', '2020-05-30 20:08:06', '2020-06-03 20:08:18', 0);
INSERT INTO linglingbo.tbl_video_classification (id, video_id, tag, create_time, modified_time, deleted) VALUES (4, 6532287, '动漫', '2020-05-31 20:09:14', '2020-06-03 20:09:20', 0);
INSERT INTO linglingbo.tbl_video_classification (id, video_id, tag, create_time, modified_time, deleted) VALUES (5, 3659542, '宠物', '2020-05-30 20:09:56', '2020-06-03 20:10:07', 0);
