create table tbl_industry
(
    id            bigint(19) auto_increment comment '主键'
        primary key,
    name          varchar(50)                not null comment '行业名称',
    description   varchar(255)               null comment '描述',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
);

INSERT INTO linglingbo.tbl_industry (id, name, description, create_time, modified_time, deleted) VALUES (9, '通用', '通用分类指可以分析各个行业，而不只是分析单一固定行业的模型', null, null, 0);
INSERT INTO linglingbo.tbl_industry (id, name, description, create_time, modified_time, deleted) VALUES (10, '医疗', '医疗', null, null, 0);
INSERT INTO linglingbo.tbl_industry (id, name, description, create_time, modified_time, deleted) VALUES (11, '教育', '教育', null, null, 0);
INSERT INTO linglingbo.tbl_industry (id, name, description, create_time, modified_time, deleted) VALUES (12, '服务1', '服务1', null, null, 0);
INSERT INTO linglingbo.tbl_industry (id, name, description, create_time, modified_time, deleted) VALUES (13, '服务2', '服务2', null, null, 0);
