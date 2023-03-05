create table ums_department
(
    id            bigint                     not null comment '主键'
        primary key,
    company_name  varchar(20)                null comment '部门名称',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
);

INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (0, 'test', '2022-11-04 16:34:11', '2022-11-04 16:35:24', 1);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (5, 'test', '2022-11-04 17:17:29', null, 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (9, 'test', '2022-11-04 17:17:35', null, 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (20, '射手座', '2022-11-10 13:48:33', null, 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (50, '河南省蓝竹康波易湘美容有限责任公司', '2022-11-11 17:26:40', '2022-11-11 17:27:30', 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (1366758216564736, 'string', '2022-11-14 14:07:06', null, 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (1366758260432896, 'string', '2022-11-14 14:08:00', null, 0);
INSERT INTO linglingbo.ums_department (id, company_name, create_time, modified_time, deleted) VALUES (1366758294282240, 'hello world', '2022-11-14 14:08:41', null, 0);
