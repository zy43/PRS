create table tbl_goods_relate_streamer
(
    id                bigint(19) auto_increment comment '主键 20200721 sanrenhe'
        primary key,
    goods_id          bigint(19)                 null comment '商品id 20200721 sanrnehe',
    streamer_id       bigint(19)                 null comment '播主id 20200721 sanrenhe',
    streamer_category varchar(60)                null comment '播主分类 20200721 sanrenhe',
    create_time       datetime                   null comment '创建时间',
    modified_time     datetime                   null comment '修改时间',
    deleted           tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (1, 3333, 1234567, '数码', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (2, 3333, 7654321, '穿搭', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (3, 3333, 1111111, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (4, 1373092536532992, 1372999360520192, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (5, 1366890975518720, 1364916962402304, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (6, 1367952345071616, 1372999360520192, '数码', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (7, 1366890482737152, 1372999360520194, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (8, 1366889459245056, 1368390327246848, '数码', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (9, 1366761785212928, 1368388863582208, '数码', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (10, 1368039110565888, 1372999360520195, '美食', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (11, 1368039110567963, 1372999360520196, '数码', null, null, 0);
INSERT INTO linglingbo.tbl_goods_relate_streamer (id, goods_id, streamer_id, streamer_category, create_time, modified_time, deleted) VALUES (12, 1366761785212928, 1366911297290240, '数码', null, null, 0);
