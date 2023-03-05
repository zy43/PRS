create table tbl_task_settle
(
    id            bigint                     not null comment '主键'
        primary key,
    goods_id      bigint                     null comment '商品id，对应tbl_goods的id属性',
    streamer_id   bigint                     null comment '播主id',
    task_id       bigint                     null comment '任务id',
    goods_name    varchar(60)                null comment '商品名称',
    sale_num      int(10)          default 0 null comment '商品带货数量',
    goods_price   decimal(8, 2)              null comment '商品售价',
    goods_spec    varchar(100)               null comment '商品规格',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '任务结算商品销量表';

INSERT INTO linglingbo.tbl_task_settle (id, goods_id, streamer_id, task_id, goods_name, sale_num, goods_price, goods_spec, create_time, modified_time, deleted) VALUES (1368541306789888, 1366889459245056, 1364982471720960, 1368540014804998, '百亿补贴：美特斯邦威 男士羽绒服 229432', 10000, 100.00, 'xl', '2022-12-09 18:44:10', null, 0);
INSERT INTO linglingbo.tbl_task_settle (id, goods_id, streamer_id, task_id, goods_name, sale_num, goods_price, goods_spec, create_time, modified_time, deleted) VALUES (1368731240898560, 1366889751158784, 1364982471720960, 1368540014804998, 'NIKE 耐克 Zoom Pulse 男/女运动鞋 CT1629', 10000, 100.00, 'xl', '2022-12-12 11:08:23', null, 0);
INSERT INTO linglingbo.tbl_task_settle (id, goods_id, streamer_id, task_id, goods_name, sale_num, goods_price, goods_spec, create_time, modified_time, deleted) VALUES (1368731252883456, 1366889751158784, 1364982471720960, 1368731016765440, 'NIKE 耐克 Zoom Pulse 男/女运动鞋 CT1629', 1, 100.00, 'xl', '2022-12-12 11:08:38', null, 0);
