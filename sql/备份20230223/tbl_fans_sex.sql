create table tbl_fans_sex
(
    id                bigint(19)                 not null comment '博主唯一编号（UUID自动生成）'
        primary key,
    streamer_id       bigint(19)                 not null comment '抖音ID',
    nick_name         varchar(64)                not null comment '博主名称',
    male_proportion   double                     null,
    female_proportion double                     null,
    create_time       datetime                   null comment '创建时间',
    modified_time     datetime                   null comment '修改时间',
    deleted           tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (1, 1234567, '库里', 0.2, 0.8, null, null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (2, 1546546, '库外', 0.3, 0.7, null, null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (3, 1364916962402304, '毛毛光', 0.97, 0.92, '2023-02-12 22:17:42', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (4, 1366909789347840, '周云熙', 0.29, 0.28, '2023-02-12 11:07:22', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (5, 1366910520090624, '田小野', 0.35, 0.37, '2023-02-12 18:30:39', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (6, 1366910530576384, '川香秋月', 0.97, 0.95, '2023-02-12 11:08:47', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (7, 1366911297290240, '黄志远', 0.86, 0.95, '2023-02-12 13:33:18', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (8, 1366911892504576, '城七日记', 0.85, 0.33, '2023-02-12 20:03:40', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (9, 1366911899926528, 'boos何', 0.63, 0.46, '2023-02-12 17:11:33', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (10, 1368388863582208, '小康总', 0.54, 0.46, '2023-02-12 17:09:21', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (11, 1368390327246848, '吃不饱三人组', 0.88, 0.98, '2023-02-12 19:44:07', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (12, 1372999360520192, '周海平', 0.19, 0.23, '2023-02-12 13:22:23', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (13, 1372999360520193, '邵子涛', 0.67, 0.08, '2023-02-12 19:23:59', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (14, 1372999360520194, '冯宇宁', 0.46, 0.49, '2023-02-12 13:08:47', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (15, 1372999360520195, '月老板', 0.51, 0.78, '2023-02-12 15:13:32', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (16, 1372999360520196, '魏晓明', 0.95, 0.02, '2023-02-12 05:56:56', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (17, 1372999360520197, '苏璐', 0.24, 0.98, '2023-02-12 19:05:36', null, 0);
INSERT INTO linglingbo.tbl_fans_sex (id, streamer_id, nick_name, male_proportion, female_proportion, create_time, modified_time, deleted) VALUES (18, 1364982471729152, '库里', 0.2, 0.8, null, null, 0);
