create table tbl_goods_hotwords
(
    id             bigint(19)                 not null
        primary key,
    goods_id       bigint(19)                 not null,
    goods_hotwords varchar(64)                not null,
    heat_degree    double(11, 2)              null,
    create_time    datetime                   null comment '创建时间',
    modified_time  datetime                   null comment '修改时间',
    deleted        tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (1, 1111, '金州', 0.3, null, null, 0);
INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (2, 1111, '勇士', 0.1, null, null, 0);
INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (3, 2222, '克利夫兰', 0.2, null, null, 0);
INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (4, 2222, '骑士', 0.05, null, null, 0);
INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (5, 3333, '巴萨', 0.4, null, null, 0);
INSERT INTO linglingbo.tbl_goods_hotwords (id, goods_id, goods_hotwords, heat_degree, create_time, modified_time, deleted) VALUES (6, 3333, '红蓝', 0.15, null, null, 0);
