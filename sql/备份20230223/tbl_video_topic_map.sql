create table tbl_video_topic_map
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    video_id      bigint(19)                 not null comment '视频ID',
    topic_name    varchar(64)                not null comment '话题',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_topic_map (id, video_id, topic_name, create_time, modified_time, deleted) VALUES (1, 1111, '抖音小助手', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic_map (id, video_id, topic_name, create_time, modified_time, deleted) VALUES (2, 1111, '网红', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic_map (id, video_id, topic_name, create_time, modified_time, deleted) VALUES (3, 2222, '合拍', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic_map (id, video_id, topic_name, create_time, modified_time, deleted) VALUES (4, 3333, '合拍', null, null, 0);
