create table tbl_industry_classification
(
    id            bigint(19)                 not null comment '唯一编号'
        primary key,
    tag           varchar(10)                not null comment '标签名称',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (1, '网红美女', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (2, '网红帅哥', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (3, '搞笑', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (4, '情感', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (5, '剧情', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (6, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (7, '美妆', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (8, '种草', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (9, '穿搭', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (10, '明星', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (11, '影视娱乐', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (12, '游戏', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (13, '宠物', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (14, '音乐', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (15, '舞蹈', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (16, '萌娃', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (17, '生活', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (18, '健康', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (19, '体育', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (20, '旅行', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (21, '动漫', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (22, '创意', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (23, '时尚', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (24, '母婴', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (25, '教育', null, null, 0);
INSERT INTO linglingbo.tbl_industry_classification (id, tag, create_time, modified_time, deleted) VALUES (26, '职场', null, null, 0);
