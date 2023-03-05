create table tbl_goods
(
    id            bigint                     not null comment '主键'
        primary key,
    owner_id      bigint                     null comment '品牌商id，对应owner的id属性',
    goods_name    varchar(60)                null comment '商品名称',
    goods_num     int(10)          default 0 null comment '商品数量',
    goods_price   decimal(8, 2)              null comment '商品售价',
    is_shelf      tinyint unsigned default 1 null comment '是否上架 1: 已上架 2: 已下架',
    image_id      bigint                     null comment '图片id',
    goods_brand   varchar(64)                null comment '商品品牌',
    category_id   bigint                     not null comment '商品所属分类',
    goods_desc    varchar(255)               null comment '商品描述',
    goods_spec    varchar(100)               null comment '商品规格',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '商品表';

INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (0, 1364909252878336, 'string', 0, 0.00, 1, 0, '', 6, 'string', 'string', '2022-11-07 18:16:55', '2023-02-10 17:39:52', 1);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366547574513664, 1364909252878336, '山东交通大学', 100, 100.00, 1, 0, '江西省州庭展欧安房地产有限公司', 0, '生死有命，富贵在天。', '1', '2022-11-11 14:41:35', null, 1);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366761785212928, 1364982471720960, null, 0, null, 1, null, null, 0, null, null, '2022-11-14 15:19:42', '2022-12-02 14:52:06', 1);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366889424224256, 1364982471720960, 'LI-NING 李宁 男子运动羽绒服 AYMR017', 10000, 259.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 1365341637877760, '以约失之者鲜矣。', 'xl', '2022-11-16 10:36:32', '2022-12-01 14:38:35', 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366889459245056, 1364982471720960, '百亿补贴：美特斯邦威 男士羽绒服 229432', 10, 100.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 1365341598605312, '以约失之者鲜矣。', 'xl', '2022-11-16 10:37:14', '2022-12-02 10:58:39', 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366889751158784, 1364982471720960, 'NIKE 耐克 Zoom Pulse 男/女运动鞋 CT1629', 10, 100.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 1365341598605312, '以约失之者鲜矣。', 'xl', '2022-11-16 10:43:11', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366890482737152, 1364982471720960, '361° 潮戈 男子运动板鞋 117554', 10, 10.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 1365341630332928, '10', '10', '2022-11-16 10:58:04', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1366890975518720, 1364982471720960, 'Lanchey 86底盒修复神器 两只装', 10, 10.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 2, '10', '10', '2022-11-16 11:08:05', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1367819676016640, 1364982471720960, 'PLUS会员：Bear 小熊 QZG-E13E5 空气炸锅 6.5L', 50, 50.00, 1, null, '湖北省昌爱泽俊情房地产普通合伙', 1365341607936000, '今之孝者，是谓能养，至于犬马，皆能有养，不敬，何以别乎。', '10', '2022-11-29 14:02:33', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1367952345071616, 1364982471720960, 'PLUS会员：breo 倍轻松 back1 颈椎按摩枕头', 50, 100.00, 1, null, '新疆维吾尔自治区阳成霖平锐教育有限公司', 1365341598605312, '弟子入则孝，出则悌，谨而信，泛爱众而亲仁，行有余力，则以学文。', '个', '2022-12-01 11:01:42', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1368039029825536, 1364982471720960, '限地区：JRC Z2T 铝合金笔记本电脑支架', 500, 10.00, 1, null, '新疆维吾尔自治区阳成霖平锐教育有限公司', 1366900834910208, '善人，吾不得而见之矣，得见有恒者，斯可矣，亡而为有，虚而为盈，约而为泰，难乎有恒矣。', '个 ', '2022-12-02 16:25:19', '2022-12-27 17:28:42', 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1368039110565888, 1364982471720960, 'Gap 盖璞 男女款抓绒卫衣 627533', 10, 500.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1365341630332928, '已矣乎！吾未见好德如好色者也。', '件', '2022-12-02 16:26:57', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1368039110565971, 1364982471720960, '苹果手机12', 100, 7999.00, 2, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1365341623779328, '苹果12改变时代', '个', '2023-02-12 01:29:33', '2023-02-13 10:23:55', 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1368039110565999, 1364982471720960, '苹果手机x', 120, 3999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1365341623779328, '苹果手机非常好用', '个', '2023-02-12 01:26:22', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1368039110567963, 1364982471720960, '苹果手机13', 130, 8999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1365341623779328, '苹果13非常nice', '个', '2023-02-12 01:31:00', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1372997604171776, 1364982471720960, '露得清 深层净痘水杨酸洁面乳 100g', 100, 100.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1365341623779328, '
温和清洁，减少皮脂腺活跃，改善肌肤大量出油问题～露得清是来自美国的保养品品牌，是强生旗下的生活用品品牌。其产品涉及护肤，身体护理，护发，彩妆等领域，跨越护', '件', '2023-02-10 17:47:46', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092170776576, 1364982471720960, 'iphone8', 123, 2000.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '苹果公司', '早期产品', '2023-02-12 01:51:44', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092212883456, 1364982471720960, 'iphoneSE', 100, 2333.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '苹果公司', '早期产品', '2023-02-12 01:52:35', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092437704704, 1364982471720960, 'iphoneSE', 299, 6999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '华为产品', '华为产品', '2023-02-12 01:57:10', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092536532992, 1364982471720960, 'huaweiMate20', 299, 6999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '华为产品', '华为产品', '2023-02-12 01:59:10', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092544888832, 1364982471720960, 'huaweiMate30', 399, 8999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '华为产品', '华为产品', '2023-02-12 01:59:20', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373092644986880, 1364982471720960, 'huaweiMate40', 199, 5999.00, 1, null, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', 1366900922572800, '华为产品', '华为产品', '2023-02-12 02:01:23', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373205629198336, 1364982471720960, '1', 1, 1.00, 1, 1373205628682240, 'owner001', 1365341607936000, '1', '1', '2023-02-13 16:20:03', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373492338163713, 1364982471720960, '213123', 213, 12312.00, 1, 1373492338163712, '123123', 123123, '213123', '123', '2023-02-17 17:33:09', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373492399063041, 1364982471720960, '213123', 213, 12312.00, 1, 1373492399063040, '谢欣源', 123123, '213123', '123', '2023-02-17 17:34:24', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373492418871297, 1364982471720960, '213123', 213, 12312.00, 1, 1373492418871296, '谢欣源', 123123, '213123', '123', '2023-02-17 17:34:48', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373492611809281, 1364982471720960, '123', 123123, 123123.00, 1, 1373492611809280, '湖北省昌爱泽俊情房地产普通合伙', 1365341607936000, '12312', '12321', '2023-02-17 17:38:43', null, 0);
INSERT INTO linglingbo.tbl_goods (id, owner_id, goods_name, goods_num, goods_price, is_shelf, image_id, goods_brand, category_id, goods_desc, goods_spec, create_time, modified_time, deleted) VALUES (1373492853145601, 1364982471720960, '张冰洁', 1, 1.00, 1, 1373492853145600, 'owner001', 1365341607936000, '1', '1', '2023-02-17 17:43:38', null, 0);
