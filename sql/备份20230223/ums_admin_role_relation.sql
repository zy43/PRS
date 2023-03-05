create table ums_admin_role_relation
(
    id            bigint auto_increment
        primary key,
    admin_id      bigint                     null,
    role_id       bigint                     null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '后台用户和角色关系表' charset = utf8;

INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (26, 3, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (27, 6, 1, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (28, 7, 2, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (29, 1, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (30, 4, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (31, 8, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (34, 12, 6, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (38, 13, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (39, 10, 8, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (47, 16, 5, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (48, 16, 8, null, null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364914126872576, 1364909252878336, 5, '2022-10-19 04:49:00', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364914137546752, 1364909556760576, 5, '2022-10-19 04:49:13', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364914149351424, 1364909645873152, 5, '2022-10-19 04:49:27', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364914166792192, 1364909556760576, 5, '2022-10-19 04:49:49', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364914232639488, 1364909252878336, 5, '2022-10-19 04:51:09', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364916962435072, 1364916962410496, 9, '2022-10-19 05:46:41', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364917205835776, 1364909556760576, 5, '2022-10-19 05:51:39', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364917210693632, 1364909556760576, 5, '2022-10-19 05:51:44', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364917213356032, 1364909645873152, 5, '2022-10-19 05:51:48', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364982471753728, 1364982471729152, 10, '2022-10-20 11:59:29', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1364982482976768, 1364982482960384, 8, '2022-10-20 11:59:43', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366550210068480, 1366550210060288, 10, '2022-11-11 15:35:12', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551046406144, 1366551046397952, 9, '2022-11-11 15:52:13', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551137411072, 1366551137402880, 9, '2022-11-11 15:54:04', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551171923968, 1366551171907584, 9, '2022-11-11 15:54:46', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551215783936, 1366551215767552, 9, '2022-11-11 15:55:40', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551249371136, 1366551249354752, 9, '2022-11-11 15:56:21', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366551291478016, 1366551291461632, 9, '2022-11-11 15:57:12', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366557974896640, 1366551137402880, 9, '2022-11-11 18:13:10', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909527990272, 1366909527973888, 9, '2022-11-16 17:25:32', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909545111552, 1366909545095168, 9, '2022-11-16 17:25:53', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909550919680, 1366909550903296, 9, '2022-11-16 17:26:00', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909726687232, 1366909726670848, 9, '2022-11-16 17:29:35', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909731774464, 1366909731758080, 9, '2022-11-16 17:29:41', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366909789372416, 1366909789356032, 9, '2022-11-16 17:30:51', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366910520115200, 1366910520098816, 9, '2022-11-16 17:45:44', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366910530600960, 1366910530584576, 9, '2022-11-16 17:45:56', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366911297314816, 1366911297298432, 9, '2022-11-16 18:01:32', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366911892529152, 1366911892512768, 9, '2022-11-16 18:13:39', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1366911899951104, 1366911899934720, 9, '2022-11-16 18:13:48', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368388715454464, 1368388715438080, 10, '2022-12-07 14:59:41', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368388863598592, 1368388863590400, 9, '2022-12-07 15:02:42', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368388922433536, 1368388922417152, 10, '2022-12-07 15:03:54', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368390327271424, 1368390327255040, 9, '2022-12-07 15:32:29', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368390629908480, 1368390629892096, 10, '2022-12-07 15:38:38', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368390866944000, 1368390866919424, 10, '2022-12-07 15:43:28', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368394673373184, 1368390327255040, 9, '2022-12-07 17:00:54', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1368518505242624, 1368390866919424, 10, '2022-12-09 11:00:16', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1369439343140864, 1368390327255040, 20, '2022-12-22 11:14:46', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1369447610073088, 1368390327255040, 30, '2022-12-22 14:02:57', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373331482025984, 1373331396820992, 30, '2023-02-15 11:00:32', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373345660125184, 1373331396820992, 32, '2023-02-15 15:48:59', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373347289923584, 1373331396820992, 32, '2023-02-15 16:22:09', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373347481526272, 1373347417432064, 32, '2023-02-15 16:26:02', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373347510657024, 1373347417432064, 32, '2023-02-15 16:26:38', null, 0);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373347607699456, 1373347607683072, 9, '2023-02-15 16:28:36', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373347905929216, 1373347607683072, 34, '2023-02-15 16:34:40', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373350234701824, 1373347607683072, 35, '2023-02-15 17:22:03', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373350743212032, 1373347607683072, 36, '2023-02-15 17:32:24', null, 1);
INSERT INTO linglingbo.ums_admin_role_relation (id, admin_id, role_id, create_time, modified_time, deleted) VALUES (1373350876708864, 1373347607683072, 10, '2023-02-15 17:35:07', null, 0);
