create table tbl_task_goods
(
    id            bigint                     not null comment '主键'
        primary key,
    task_id       bigint                     null comment '任务id',
    goods_name    varchar(60)                null comment '商品名称',
    goods_num     int(10)          default 0 null comment '商品数量',
    goods_price   decimal(8, 2)              null comment '商品售价',
    goods_spec    varchar(100)               null comment '商品规格',
    goods_id      bigint                     null comment '商品id',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '任务商品表';

INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (0, 1367812176633856, 'string', 0, 0.00, 'string', 0, '2022-11-07 18:16:55', null, 1);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1366252631891968, 0, '2', 0, 0.00, 'string', 111, '2022-11-07 10:40:57', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1366409125404672, 10, '杜瑾春', 10, 10.00, '111', 31231, '2022-11-09 15:44:49', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1366409156984832, 5, '杜瑾春', 10, 10.00, '111', 31231, '2022-11-09 15:45:28', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1366547574513664, 1367812176633856, '山东交通大学', 100, 100.00, '1', 1366547574513664, '2022-11-11 14:41:35', null, 1);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1366889424224256, 1368540014804993, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 10000, 265.00, 'xl', 1366889424224256, '2022-11-16 10:36:32', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1367954942459904, 1368540014804993, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 265.00, 'l', 1366889424224256, '2022-11-07 18:16:55', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1367961967222784, 1368540014804993, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 265.00, 'l', 1366889424224256, '2022-11-07 18:16:55', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368021512249344, 1368540014804993, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 265.00, 'l', 1366889424224256, '2022-11-07 18:16:55', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368235076583424, 1368540014804993, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368248354267136, 1368540014804994, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368248354275328, 1368540014804994, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 'xl', 1366889751158784, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256383401984, 1368256383393792, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256383418368, 1368256383393792, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 'xl', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256540540928, 1368540014804995, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256540557312, 1368540014804995, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 's', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256588439552, 1368540014804996, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368256588447744, 1368540014804996, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 's', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258443223040, 1368540014804997, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 's', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258443231232, 1368540014804998, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 's', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258762620928, 1368540014804999, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 's', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258762629120, 1368540014804999, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 's', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258801524736, 1368540014805000, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258839379968, 1368540014805000, 'PLUS会员：Bear 小熊 QZG-E13E5 空气炸锅 6.5L', 1000, 50.00, 's', 1367819676016640, '2022-11-29 14:02:33', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368258866176000, 1368540014805001, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368314205765632, 1368540014805001, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368314289881088, 1368540014805002, 'PLUS会员：Bear 小熊 QZG-E13E5 空气炸锅 6.5L', 1000, 50.00, 's', 1367819676016640, '2022-11-29 14:02:33', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368314331127808, 1368540014805002, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368314355318784, 1368540014805003, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368314932510720, 1368540014805003, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368315570782208, 1368540014805004, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368315881799680, 1368540014805004, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368522062274560, 1368540014805005, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368528065503232, 1368540014805005, 'PLUS会员：breo 倍轻松 back1 颈椎按摩枕头', 1000, 100.00, '个', 1367952345071616, '2022-12-01 11:01:42', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368531665428480, 1368540014805006, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 'xl', 1366889424224256, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368534096060416, 1368540014805006, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368536034639872, 1368540014805007, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368536034664448, 1368540014805007, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 'xl', 1366889751158784, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368540014821376, 1368540014805007, '百亿补贴：美特斯邦威 男士羽绒服 229432', 1000, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1368731016781824, 1368540014805007, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 1000, 100.00, 'xl', 1366889751158784, '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_task_goods (id, task_id, goods_name, goods_num, goods_price, goods_spec, goods_id, create_time, modified_time, deleted) VALUES (1373204400734208, 1373204400717824, '百亿补贴：美特斯邦威 男士羽绒服 229432', 10, 100.00, 'xl', 1366889459245056, '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
