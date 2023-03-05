create table tbl_fans_region
(
    id            bigint(19) auto_increment
        primary key,
    streamer_id   bigint(19)                 not null comment '抖音ID',
    fans_province varchar(64)                null comment '粉丝地域',
    fans_city     varchar(255)               null,
    proportion    double(3, 2)               null comment '占比',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (1, 1364916962402304, '浙江', '杭州', 2.39, 0, '2023-02-12 19:54:57', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (2, 1364916962402304, '江苏', '南京', 3.96, 0, '2023-02-12 02:24:36', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (3, 1364916962402304, '上海', '上海', 2.29, 0, '2023-02-12 17:55:05', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (4, 1364916962402304, '浙江', '宁波', 1.31, 0, '2023-02-12 03:20:28', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (5, 1366909789347840, '浙江', '杭州', 1.54, 0, '2023-02-12 21:51:51', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (6, 1366909789347840, '江苏', '南京', 3.6, 0, '2023-02-12 19:27:38', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (7, 1366909789347840, '上海', '上海', 3.66, 0, '2023-02-12 06:59:16', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (8, 1366909789347840, '浙江', '宁波', 2.16, 0, '2023-02-12 15:16:30', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (9, 1366910520090624, '浙江', '杭州', 3.04, 0, '2023-02-12 02:15:55', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (10, 1366910520090624, '江苏', '南京', 3.53, 0, '2023-02-12 21:24:50', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (11, 1366910520090624, '上海', '上海', 1.47, 0, '2023-02-12 11:18:09', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (12, 1366910520090624, '浙江', '宁波', 1.59, 0, '2023-02-12 15:49:26', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (13, 1366910530576384, '浙江', '杭州', 3.1, 0, '2023-02-12 04:32:35', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (14, 1366910530576384, '江苏', '南京', 1.53, 0, '2023-02-12 10:12:14', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (15, 1366910530576384, '上海', '上海', 1.1, 0, '2023-02-12 11:15:55', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (16, 1366910530576384, '浙江', '宁波', 3.17, 0, '2023-02-12 06:14:06', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (17, 1366911297290240, '浙江', '杭州', 3.27, 0, '2023-02-12 19:11:42', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (18, 1366911297290240, '江苏', '南京', 2.56, 0, '2023-02-12 12:23:12', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (19, 1366911297290240, '上海', '上海', 3.59, 0, '2023-02-12 09:35:20', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (20, 1366911297290240, '浙江', '宁波', 1.75, 0, '2023-02-12 12:55:51', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (21, 1366911892504576, '浙江', '杭州', 1.64, 0, '2023-02-12 10:21:49', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (22, 1366911892504576, '江苏', '南京', 1.76, 0, '2023-02-12 18:46:57', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (23, 1366911892504576, '上海', '上海', 1.09, 0, '2023-02-12 21:54:00', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (24, 1366911892504576, '浙江', '宁波', 3.22, 0, '2023-02-12 08:07:46', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (25, 1366911899926528, '浙江', '杭州', 2.43, 0, '2023-02-12 09:40:37', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (26, 1366911899926528, '江苏', '南京', 1.6, 0, '2023-02-12 00:37:15', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (27, 1366911899926528, '上海', '上海', 2.23, 0, '2023-02-12 05:38:02', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (28, 1366911899926528, '浙江', '宁波', 3.29, 0, '2023-02-12 09:22:54', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (29, 1368388863582208, '浙江', '杭州', 1.65, 0, '2023-02-12 12:02:22', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (30, 1368388863582208, '江苏', '南京', 1.5, 0, '2023-02-12 08:18:15', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (31, 1368388863582208, '上海', '上海', 2.65, 0, '2023-02-12 03:19:27', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (32, 1368388863582208, '浙江', '宁波', 1.74, 0, '2023-02-12 18:41:43', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (33, 1368390327246848, '浙江', '杭州', 1.81, 0, '2023-02-12 19:12:50', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (34, 1368390327246848, '江苏', '南京', 1.68, 0, '2023-02-12 23:49:45', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (35, 1368390327246848, '上海', '上海', 2.66, 0, '2023-02-12 14:05:10', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (36, 1368390327246848, '浙江', '宁波', 2.58, 0, '2023-02-12 10:25:31', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (37, 1372999360520192, '浙江', '杭州', 1.2, 0, '2023-02-12 04:58:37', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (38, 1372999360520192, '江苏', '南京', 3.85, 0, '2023-02-12 10:26:16', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (39, 1372999360520192, '上海', '上海', 3.69, 0, '2023-02-12 21:54:26', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (40, 1372999360520192, '浙江', '宁波', 3.12, 0, '2023-02-12 03:23:41', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (41, 1372999360520193, '浙江', '杭州', 2.15, 0, '2023-02-12 12:28:27', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (42, 1372999360520193, '江苏', '南京', 3.24, 0, '2023-02-12 07:47:42', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (43, 1372999360520193, '上海', '上海', 3.28, 0, '2023-02-12 12:36:50', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (44, 1372999360520193, '浙江', '宁波', 3.63, 0, '2023-02-12 22:57:30', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (45, 1372999360520194, '浙江', '杭州', 3.2, 0, '2023-02-12 14:54:41', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (46, 1372999360520194, '江苏', '南京', 3.01, 0, '2023-02-12 03:27:19', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (47, 1372999360520194, '上海', '上海', 1.18, 0, '2023-02-12 04:07:07', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (48, 1372999360520194, '浙江', '宁波', 2.77, 0, '2023-02-12 20:58:21', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (49, 1372999360520195, '浙江', '杭州', 1.44, 0, '2023-02-12 21:17:20', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (50, 1372999360520195, '江苏', '南京', 2.05, 0, '2023-02-12 06:45:13', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (51, 1372999360520195, '上海', '上海', 3, 0, '2023-02-12 14:49:40', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (52, 1372999360520195, '浙江', '宁波', 1.79, 0, '2023-02-12 07:07:03', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (53, 1372999360520196, '浙江', '杭州', 1.47, 0, '2023-02-12 05:48:44', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (54, 1372999360520196, '江苏', '南京', 1.01, 0, '2023-02-12 08:22:06', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (55, 1372999360520196, '上海', '上海', 2.26, 0, '2023-02-12 13:22:31', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (56, 1372999360520196, '浙江', '宁波', 1.36, 0, '2023-02-12 17:17:17', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (57, 1372999360520197, '浙江', '杭州', 1.61, 0, '2023-02-12 07:21:39', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (58, 1372999360520197, '江苏', '南京', 3.25, 0, '2023-02-12 16:09:25', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (59, 1372999360520197, '上海', '上海', 3.56, 0, '2023-02-12 01:50:39', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (60, 1372999360520197, '浙江', '宁波', 3.57, 0, '2023-02-12 06:23:21', null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (61, 1364982471729152, '浙江', '杭州', 0.22, 0, null, null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (62, 1364982471729152, '江苏', '南京', 0.11, 0, null, null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (63, 1364982471729152, '上海', '上海', 0.1, 0, null, null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (64, 1364982471729152, '浙江', '宁波', 0.12, 0, null, null);
INSERT INTO linglingbo.tbl_fans_region (id, streamer_id, fans_province, fans_city, proportion, deleted, create_time, modified_time) VALUES (65, 1364982471729152, '江苏', '扬州', 0.05, 0, null, null);
