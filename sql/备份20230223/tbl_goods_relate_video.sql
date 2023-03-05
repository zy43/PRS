create table tbl_goods_relate_video
(
    id             bigint(19) auto_increment comment '主键 20200721 sanrenhe'
        primary key,
    goods_id       bigint(19)                 null comment '商品id 20200721 sanrnehe',
    video_id       bigint(19)                 null comment '视频id 20200721 sanrnehe',
    streamer_id    bigint(19)                 null comment '关联主播id 20200723 sanrenhe',
    sales          bigint           default 0 null comment '销量',
    video_category varchar(60)                null comment '视频类型 20200721 sanrnehe',
    digg_count     bigint                     null comment '点赞量 20200721 sanrnehe',
    create_time    datetime                   null comment '创建时间',
    modified_time  datetime                   null comment '修改时间',
    deleted        tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_goods_relate_video (id, goods_id, video_id, streamer_id, sales, video_category, digg_count, create_time, modified_time, deleted) VALUES (1, 1373092437704704, 1111, 1364982471729152, 20, '穿搭', 20, '2023-02-13 16:30:59', null, 0);
INSERT INTO linglingbo.tbl_goods_relate_video (id, goods_id, video_id, streamer_id, sales, video_category, digg_count, create_time, modified_time, deleted) VALUES (2, 1373092536532992, 2222, 1364982471729152, 30, '美食', 60, '2023-02-13 16:31:05', null, 0);
INSERT INTO linglingbo.tbl_goods_relate_video (id, goods_id, video_id, streamer_id, sales, video_category, digg_count, create_time, modified_time, deleted) VALUES (3, 1373092544888832, 4444, 1364982471729152, 40, '美妆', 120, '2023-02-13 16:31:08', null, 0);
INSERT INTO linglingbo.tbl_goods_relate_video (id, goods_id, video_id, streamer_id, sales, video_category, digg_count, create_time, modified_time, deleted) VALUES (4, 1373092644986880, 5555, 1364982471729152, 11, '美食', 90, '2023-02-13 16:31:12', null, 0);
INSERT INTO linglingbo.tbl_goods_relate_video (id, goods_id, video_id, streamer_id, sales, video_category, digg_count, create_time, modified_time, deleted) VALUES (5, 1373205629198336, 3333, 1364982471729152, 85, '美食', 1000, '2023-02-13 16:31:15', null, 0);
