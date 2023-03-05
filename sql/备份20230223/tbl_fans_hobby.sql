create table tbl_fans_hobby
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    streamer_id   bigint(19)                 not null comment '抖音ID',
    nick_name     varchar(64)                null comment '播主名称',
    fans_hobby    varchar(64)                null comment '粉丝兴趣',
    proportion    double(3, 0)               null comment '占比',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (1, 1364916962402304, '毛毛光', '惊悚', 4, '2023-02-12 13:58:46', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (2, 1366909789347840, '周云熙', '搞笑', 1, '2023-02-12 17:23:49', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (3, 1366910520090624, '田小野', '电影', 2, '2023-02-12 03:48:29', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (4, 1366910530576384, '川香秋月', '惊悚', 4, '2023-02-12 06:05:51', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (5, 1366911297290240, '黄志远', '惊悚', 1, '2023-02-12 23:19:47', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (6, 1366911892504576, '城七日记', '惊悚', 2, '2023-02-12 23:13:28', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (7, 1366911899926528, 'boos何', '电视剧', 3, '2023-02-12 13:39:21', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (8, 1368388863582208, '小康总', '电视剧', 4, '2023-02-12 00:29:42', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (9, 1368390327246848, '吃不饱三人组', '搞笑', 3, '2023-02-12 15:27:36', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (10, 1372999360520192, '周海平', '惊悚', 3, '2023-02-12 12:59:29', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (11, 1372999360520193, '邵子涛', '惊悚', 2, '2023-02-12 20:43:13', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (12, 1372999360520194, '冯宇宁', '惊悚', 2, '2023-02-12 22:09:00', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (13, 1372999360520195, '月老板', '搞笑', 2, '2023-02-12 23:40:31', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (14, 1372999360520196, '魏晓明', '电影', 3, '2023-02-12 00:44:16', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (15, 1372999360520197, '苏璐', '电视剧', 4, '2023-02-12 16:00:04', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (16, 1364916962402304, '毛毛光', '英雄联盟', 4, '2023-02-12 04:16:17', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (17, 1366909789347840, '周云熙', '王者荣耀', 1, '2023-02-12 12:23:02', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (18, 1366910520090624, '田小野', '穿越火线', 1, '2023-02-12 08:18:19', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (19, 1366910530576384, '川香秋月', '王者荣耀', 3, '2023-02-12 20:57:47', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (20, 1366911297290240, '黄志远', '英雄联盟', 1, '2023-02-12 19:27:24', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (21, 1366911892504576, '城七日记', '王者荣耀', 3, '2023-02-12 14:01:47', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (22, 1366911899926528, 'boos何', '王者荣耀', 4, '2023-02-12 07:27:09', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (23, 1368388863582208, '小康总', 'PUBG', 2, '2023-02-12 18:46:41', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (24, 1368390327246848, '吃不饱三人组', '穿越火线', 2, '2023-02-12 02:59:34', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (25, 1372999360520192, '周海平', '王者荣耀', 3, '2023-02-12 04:29:44', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (26, 1372999360520193, '邵子涛', 'PUBG', 2, '2023-02-12 00:29:41', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (27, 1372999360520194, '冯宇宁', '穿越火线', 2, '2023-02-12 04:08:21', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (28, 1372999360520195, '月老板', '穿越火线', 2, '2023-02-12 01:21:45', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (29, 1372999360520196, '魏晓明', '王者荣耀', 3, '2023-02-12 20:18:42', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (30, 1372999360520197, '苏璐', 'PUBG', 3, '2023-02-12 22:28:44', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (31, 1364916962402304, '毛毛光', '跳舞', 3, '2023-02-12 15:28:07', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (32, 1366909789347840, '周云熙', '带货', 1, '2023-02-12 23:52:16', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (33, 1366910520090624, '田小野', '唱歌', 3, '2023-02-12 15:09:03', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (34, 1366910530576384, '川香秋月', '唱歌', 3, '2023-02-12 22:38:40', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (35, 1366911297290240, '黄志远', '带货', 3, '2023-02-12 01:02:27', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (36, 1366911892504576, '城七日记', 'vlog', 1, '2023-02-12 10:53:35', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (37, 1366911899926528, 'boos何', '唱歌', 1, '2023-02-12 08:22:52', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (38, 1368388863582208, '小康总', '唱歌', 4, '2023-02-12 05:39:06', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (39, 1368390327246848, '吃不饱三人组', '带货', 2, '2023-02-12 11:58:31', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (40, 1372999360520192, '周海平', '唱歌', 3, '2023-02-12 23:53:50', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (41, 1372999360520193, '邵子涛', '跳舞', 1, '2023-02-12 12:16:42', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (42, 1372999360520194, '冯宇宁', '唱歌', 1, '2023-02-12 15:46:49', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (43, 1372999360520195, '月老板', '带货', 3, '2023-02-12 02:31:36', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (44, 1372999360520196, '魏晓明', '带货', 1, '2023-02-12 10:57:56', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (45, 1372999360520197, '苏璐', '带货', 2, '2023-02-12 16:43:08', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (46, 1364916962402304, '毛毛光', '海洋', 3, '2023-02-12 15:18:13', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (47, 1366909789347840, '周云熙', '猫', 3, '2023-02-12 07:56:48', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (48, 1366910520090624, '田小野', '宠物', 2, '2023-02-12 20:33:22', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (49, 1366910530576384, '川香秋月', '宠物', 2, '2023-02-12 10:16:15', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (50, 1366911297290240, '黄志远', '海洋', 2, '2023-02-12 01:34:54', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (51, 1366911892504576, '城七日记', '宠物', 2, '2023-02-12 04:24:09', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (52, 1366911899926528, 'boos何', '宠物', 3, '2023-02-12 21:23:28', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (53, 1368388863582208, '小康总', '猫', 3, '2023-02-12 20:16:40', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (54, 1368390327246848, '吃不饱三人组', '猫', 2, '2023-02-12 01:02:11', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (55, 1372999360520192, '周海平', '海洋', 3, '2023-02-12 11:53:58', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (56, 1372999360520193, '邵子涛', '猫', 2, '2023-02-12 16:09:52', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (57, 1372999360520194, '冯宇宁', '宠物', 3, '2023-02-12 12:28:45', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (58, 1372999360520195, '月老板', '狗', 2, '2023-02-12 19:43:41', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (59, 1372999360520196, '魏晓明', '海洋', 1, '2023-02-12 03:34:02', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (60, 1372999360520197, '苏璐', '宠物', 2, '2023-02-12 02:44:48', null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (61, 1364982471729152, '库里', '唱歌', 1, null, null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (62, 1364982471729152, '库里', '跳舞', 0, null, null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (63, 1364982471729152, '库里', '狗', 0, null, null, 0);
INSERT INTO linglingbo.tbl_fans_hobby (id, streamer_id, nick_name, fans_hobby, proportion, create_time, modified_time, deleted) VALUES (64, 1364982471729152, '库里', '王者荣耀', 0, null, null, 0);
