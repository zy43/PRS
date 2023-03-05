create table tbl_fans_activetime
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    streamer_id   bigint(19)                 not null comment '抖音ID',
    nick_name     varchar(64)                null comment '播主名称',
    active_time   varchar(64)                null comment '粉丝活跃时间段',
    proportion    double                     null comment '占比',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (1, 1364982471729152, '库里1', '00:00', 0.1, null, null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (2, 1364982471729152, '库里2', '01:00', 0.2, null, null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (3, 1364982471729152, '库里3', '02:00', 0.3, null, null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (4, 1364982471729152, '库里', '03:00', 0.15, null, null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (5, 1364982471729152, '库里', '04:00', 0.05, null, null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (6, 1364916962402304, '毛毛光', '15:23:47', 0.26, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (7, 1366909789347840, '周云熙', '14:55:41', 0.93, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (8, 1366910520090624, '田小野', '09:08:25', 0.34, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (9, 1366910530576384, '川香秋月', '10:57:28', 0.91, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (10, 1366911297290240, '黄志远', '11:37:23', 0.46, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (11, 1366911892504576, '城七日记', '09:55:46', 0.12, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (12, 1366911899926528, 'boos何', '16:33:53', 0.5, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (13, 1368388863582208, '小康总', '11:56:03', 0.01, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (14, 1368390327246848, '吃不饱三人组', '17:52:08', 0.47, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (15, 1372999360520192, '周海平', '12:13:40', 0.83, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (16, 1372999360520193, '邵子涛', '14:25:58', 0.75, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (17, 1372999360520194, '冯宇宁', '12:18:02', 0.84, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (18, 1372999360520195, '月老板', '09:12:14', 0.76, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (19, 1372999360520196, '魏晓明', '12:42:31', 0.51, '2023-02-12 21:57:15', null, 0);
INSERT INTO linglingbo.tbl_fans_activetime (id, streamer_id, nick_name, active_time, proportion, create_time, modified_time, deleted) VALUES (20, 1372999360520197, '苏璐', '13:04:58', 0.2, '2023-02-12 21:57:15', null, 0);
