create table tbl_favorite_goods
(
    id            bigint                     not null comment '主键'
        primary key,
    admin_id      bigint(19)                 not null comment '用户ID',
    goods_id      bigint(19)                 not null comment '商品ID',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '商品收藏表';

INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1369943358087168, 1364909252878336, 1368039110565888, '2022-12-29 14:08:58', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1369946112540672, 1364909252878336, 1368039029825536, '2022-12-29 15:05:01', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1369946122559488, 1364909252878336, 1367952345071616, '2022-12-29 15:05:13', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1369946128752640, 1364909252878336, 1367819676016640, '2022-12-29 15:05:20', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1369946135388160, 1364909252878336, 1366890975518720, '2022-12-29 15:05:29', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1373076614709248, 1364909252878336, 1366890482737152, '2023-02-11 20:35:14', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1373076621869056, 1364909252878336, 1366889751158784, '2023-02-11 20:35:23', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1373907550273536, 1364909252878336, 1366889751158784, '2023-02-23 14:20:40', null, 0);
INSERT INTO linglingbo.tbl_favorite_goods (id, admin_id, goods_id, create_time, modified_time, deleted) VALUES (1373907579314176, 1364909252878336, 1366889751158784, '2023-02-23 14:21:16', null, 0);
