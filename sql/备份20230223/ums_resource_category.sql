create table ums_resource_category
(
    id            bigint auto_increment
        primary key,
    create_time   datetime                   null comment '创建时间',
    name          varchar(200)               null comment '分类名称',
    sort          int(4)                     null comment '排序',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '资源分类表' charset = utf8;

INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1, '2020-02-05 10:21:44', '商品模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (4, '2020-02-05 10:23:04', '权限模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (6, '2020-02-07 16:35:49', '其他模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364763164188672, '2022-10-17 01:37:39', '任务模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364763385634816, '2022-10-17 01:42:10', '客户模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364763393245184, '2022-10-17 01:42:19', '审核模块', 0, '2022-10-20 03:24:07', 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364763414249472, '2022-10-17 01:42:45', '个人中心模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364763424997376, '2022-10-17 01:42:58', '账户中心模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364764990332928, '2022-10-17 02:14:49', '图片管理模块', 0, null, 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364850862768128, '2022-10-18 07:21:53', '主播查找模块', 0, '2022-10-18 07:22:45', 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364850874744832, '2022-10-18 07:22:08', '数据监测模块', 0, '2022-10-18 07:22:52', 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364850884575232, '2022-10-18 07:22:20', '电商分析模块', 0, '2022-10-18 07:22:58', 0);
INSERT INTO linglingbo.ums_resource_category (id, create_time, name, sort, modified_time, deleted) VALUES (1364850890481664, '2022-10-18 07:22:27', '品牌推广模块', 0, '2022-10-18 07:23:04', 0);
