create table tbl_cate_goods_relation
(
    id            bigint                      not null
        primary key,
    object_id     bigint                      null comment '业务对象id（task_id，streamer_id，owner_id）',
    cate_goods_id bigint                      null comment '商品分类id',
    client_type   varchar(20) charset utf8mb4 null comment 'id 类型(streamer,owner,task)',
    create_time   datetime                    null comment '创建时间',
    modified_time datetime                    null comment '修改时间',
    deleted       tinyint unsigned default 0  null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_cate_goods_relation (id, object_id, cate_goods_id, client_type, create_time, modified_time, deleted) VALUES (1373494102343680, 1373494102335488, 1365341607936000, 'owner', '2023-02-17 18:09:03', null, 0);
