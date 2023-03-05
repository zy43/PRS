create table tbl_video_topic
(
    topic_id         bigint(19)                 not null
        primary key,
    topic_name       varchar(255)               not null,
    participants     bigint                     null,
    playback_volume  bigint                     null,
    topic_comments   bigint                     null,
    topic_shares     bigint                     null,
    topic_day_people bigint                     null,
    trend            int(3)                     null,
    topic_image_url  varchar(255)               null,
    create_time      datetime                   null comment '创建时间',
    modified_time    datetime                   null comment '修改时间',
    deleted          tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (1, '抖音小助手', 111111111, 11111111, 11111111, 1111111, 11, 1, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (2, '网红', 222222222, 22222222, 22222222, 2222222, 22, 0, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (3, '热门', 333333333, 33333333, 33333333, 3333333, 33, 1, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (4, '合拍', 444444444, 44444444, 44444444, 4444444, 44, 0, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (5, '合拍', 555555555, 55555555, 55555555, 5555555, 55, 1, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (6, '抖音小助手', 666666666, 66666666, 66666666, 6666666, 66, 1, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
INSERT INTO linglingbo.tbl_video_topic (topic_id, topic_name, participants, playback_volume, topic_comments, topic_shares, topic_day_people, trend, topic_image_url, create_time, modified_time, deleted) VALUES (7, '抖音小助手', 777777777, 77777777, 77777777, 77777777, 77, 0, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_xiaomi.png', null, null, 0);
