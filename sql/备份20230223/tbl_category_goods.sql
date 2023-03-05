create table tbl_category_goods
(
    id            bigint                     not null comment '主键'
        primary key,
    category_name varchar(64)                not null comment '带货商品分类名',
    category_desc varchar(255)               null comment '商品分类描述',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '带货商品分类表';

INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1, 'test', 'test', null, '2022-10-25 13:50:34', 1);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (2, '分类1-2', null, null, '2022-11-16 14:16:28', 1);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (3, '分类1-3', null, null, '2022-11-16 14:17:05', 1);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (4, '分类2', null, null, '2022-11-16 14:17:30', 1);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341598605312, '东北特色', '炖锅', '2022-10-25 13:45:56', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341607936000, '书籍', '金瓶梅', '2022-10-25 13:46:08', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341623779328, '手机数码', 'iphone17', '2022-10-25 13:46:27', '2022-11-16 15:24:14', 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341630332928, '护肤', '自然堂', '2022-10-25 13:46:35', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341637877760, '玩具', '奥特曼', '2022-10-25 13:46:44', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341647224832, '珠宝首饰', '钻戒', '2022-10-25 13:46:55', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341684768768, '童装', 'Adidas', '2022-10-25 13:47:41', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1365341692575744, '男装', '花花公子', '2022-10-25 13:47:51', null, 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1366900834910208, '笔记本电脑', '温故而知新。', '2022-11-16 14:28:41', '2022-11-16 15:24:26', 0);
INSERT INTO linglingbo.tbl_category_goods (id, category_name, category_desc, create_time, modified_time, deleted) VALUES (1366900922572800, '手机', '众恶之，必察焉；众好之，必察焉。', '2022-11-16 14:30:28', null, 0);
