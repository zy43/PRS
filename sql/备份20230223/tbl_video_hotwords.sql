create table tbl_video_hotwords
(
    id             bigint(19)                 not null comment '唯一编号（UUID）自动生成'
        primary key,
    video_id       bigint(19)                 not null comment '视频ID',
    video_hotwords varchar(64)                not null comment '视频热词',
    heat_degree    double(3, 2)               not null comment '热词频率',
    create_time    datetime                   null comment '创建时间',
    modified_time  datetime                   null comment '修改时间',
    deleted        tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (1, 1111, '库里', 0.25, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (2, 1111, '杜兰特', 0.26, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (3, 1111, '汤普森', 0.1, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (4, 1111, '格林', 0.05, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (5, 2222, '乐福', 0.11, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (6, 2222, '泰伦卢', 0.35, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (7, 3333, '猪', 0.11, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (8, 3333, '羊', 0.11, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (9, 4444, '牛', 0.11, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (10, 4444, '兔', 0.11, null, null, 0);
INSERT INTO linglingbo.tbl_video_hotwords (id, video_id, video_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (11, 5555, '马猪', 0.12, null, null, 0);
