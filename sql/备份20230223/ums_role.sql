create table ums_role
(
    id            bigint auto_increment
        primary key,
    name          varchar(100)               null comment '名称',
    description   varchar(500)               null comment '描述',
    admin_count   int                        null comment '后台用户数量',
    status        int(1)           default 1 null comment '启用状态：0->禁用；1->启用',
    sort          int              default 0 null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '后台用户角色表' charset = utf8;

INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (5, '超级管理员', '享有最高权限', 0, 1, 0, null, null, 0);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (8, '运营人员', '负责审核和权限模块操作', 0, 1, 0, null, null, 0);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (9, '播主', '主播/MCN', 0, 1, 0, null, null, 0);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (10, '品牌方', '品牌商/政府', 0, 1, 0, null, null, 0);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (20, '吕天昊', '子温而厉，威而不猛，恭而安。', 0, 1, 0, '2022-11-10 17:14:47', '2022-12-22 11:17:23', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (21, '董忠林', '子曰：君子周而不比，小人比而不周。', 0, 1, 0, '2022-11-10 17:16:19', '2022-12-22 11:17:22', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (22, '金芳', '夷狄之有君，不如诸夏之无也。', 0, 1, 0, '2022-11-10 17:17:30', '2022-11-10 18:24:14', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (23, '金芳', '夷狄之有君，不如诸夏之无也。', 0, 1, 0, '2022-11-10 17:17:39', '2022-12-22 11:17:20', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (24, '钱佳琪', '夫子温、良、恭、俭、让。', 0, 1, 0, '2022-11-10 17:18:03', '2022-12-22 11:17:18', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (25, '卢运昊', '弟子入则孝，出则悌，谨而信，泛爱众而亲仁，行有余力，则以学文。', 0, 1, 0, '2022-11-10 17:20:06', '2022-11-10 17:52:59', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (26, '邵益辰', '自古皆有死，民无信不立。', 0, 1, 0, '2022-11-10 17:44:23', '2022-11-10 17:52:59', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (27, 'string', 'hhhhhhhh', 0, 0, 0, '2022-11-10 18:08:58', '2022-12-22 11:17:15', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (28, '高尚', '道不同，不相为谋。', 0, 1, 0, '2022-11-10 18:25:49', '2022-12-22 11:17:05', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (29, '吕佳玉', '爱之欲其生，恶之欲其死。', 0, 1, 0, '2022-11-11 11:04:48', '2022-11-14 14:17:36', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (30, '权限测试1', '权限测试1', 0, 1, 0, '2022-12-22 11:18:34', '2023-02-15 16:33:24', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (31, '1', '1', 0, 1, 0, '2022-12-22 11:19:16', '2022-12-22 11:19:19', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (32, '子类测试', '', 0, 1, 0, '2023-02-15 15:48:12', '2023-02-15 16:33:22', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (33, '1', '', 0, 1, 0, '2023-02-15 16:33:26', '2023-02-15 16:33:30', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (34, '主播1', '', 0, 1, 0, '2023-02-15 16:33:36', '2023-02-15 17:30:14', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (35, '111', '', 0, 1, 0, '2023-02-15 17:19:36', '2023-02-15 17:30:16', 1);
INSERT INTO linglingbo.ums_role (id, name, description, admin_count, status, sort, create_time, modified_time, deleted) VALUES (36, '主播1', '', 0, 1, 0, '2023-02-15 17:30:27', null, 0);
