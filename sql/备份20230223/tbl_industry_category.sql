create table tbl_industry_category
(
    id            bigint                     not null comment '主键'
        primary key,
    industry_name varchar(64)                null comment '行业分类名称',
    industry_desc varchar(255)               null comment '行业描述',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '行业分类表' charset = utf8;

INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365331957374976, '计算机', '计算机行业', '2022-10-25 10:29:47', '2022-10-25 10:42:49', 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365331993206784, '机械', '机械自动化', '2022-10-25 10:30:31', null, 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365332002349056, '土木', '土木工程', '2022-10-25 10:30:42', null, 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365332013907968, '服装', '服装制作', '2022-10-25 10:30:56', null, 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365332044800000, '餐饮', '重庆小面', '2022-10-25 10:31:34', null, 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1365332050034688, '餐饮', '麻辣香锅', '2022-10-25 10:31:40', '2022-10-25 13:39:46', 1);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1366904500830208, '新闻', '先天下之忧而忧，后天下之乐而乐。', '2022-11-16 15:43:16', '2022-11-16 15:56:51', 1);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1366904527896576, '农业', '君子喻于义，小人喻于利。11111', '2022-11-16 15:43:49', '2022-11-16 15:56:37', 1);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1366906393247744, '汽车', '学而不厌，诲人不倦。', '2022-11-16 16:21:46', null, 0);
INSERT INTO linglingbo.tbl_industry_category (id, industry_name, industry_desc, create_time, modified_time, deleted) VALUES (1366906407747584, '出租', '子曰：君子周而不比，小人比而不周。', '2022-11-16 16:22:04', null, 0);
