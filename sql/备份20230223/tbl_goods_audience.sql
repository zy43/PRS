create table tbl_goods_audience
(
    id            bigint(19)                 not null comment '唯一编号（UUID自动生成）'
        primary key,
    goods_id      bigint(19)                 not null comment '商品ID',
    p_male        double(3, 0)               null comment '商品用户男性占比',
    p_female      double(3, 0)               null comment '商品用户女性占比',
    p_age6_17     double(3, 0)               null comment '用户年龄段（6-17岁）占比',
    p_age18_24    double(3, 0)               null comment '用户年龄段（18-24岁）占比',
    p_age25_30    double(3, 0)               null comment '用户年龄段（25-30岁）占比',
    p_age31_35    double(3, 0)               null comment '用户年龄段（31-35岁）占比',
    p_age36_40    double(3, 0)               null comment '用户年龄段（36-40岁）占比',
    p_age41       double(3, 0)               null comment '用户年龄段（41岁以上）占比',
    p_province    varchar(64)                null comment '商品用户所在省份',
    p_city        varchar(64)                null comment '商品用户所在城市',
    p_proportion  double(3, 0)               null comment '占比',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_goods_audience (id, goods_id, p_male, p_female, p_age6_17, p_age18_24, p_age25_30, p_age31_35, p_age36_40, p_age41, p_province, p_city, p_proportion, create_time, modified_time, deleted) VALUES (1, 3333, 42, 58, 5, 32, 41, 12, 7, 3, '浙江省4.68%', '杭州市42.36%', null, null, null, 0);
