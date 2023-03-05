create table tbl_topic_user_industry
(
    id            bigint(19)                 not null
        primary key,
    topic_name    varchar(64)                not null,
    industry      varchar(64)                null,
    proportion    double(3, 2)               null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_topic_user_industry (id, topic_name, industry, proportion, create_time, modified_time, deleted) VALUES (1, '抖音小助手', '教育', 0.3, null, null, 0);
INSERT INTO linglingbo.tbl_topic_user_industry (id, topic_name, industry, proportion, create_time, modified_time, deleted) VALUES (2, '抖音小助手', '体育', 0.1, null, null, 0);
INSERT INTO linglingbo.tbl_topic_user_industry (id, topic_name, industry, proportion, create_time, modified_time, deleted) VALUES (3, '抖音小助手', '网红', 0.05, null, null, 0);
