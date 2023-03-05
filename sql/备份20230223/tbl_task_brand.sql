create table tbl_task_brand
(
    id            bigint                     not null comment '主键'
        primary key,
    task_id       bigint                     null comment '任务id',
    brand_name    varchar(20)                null comment '品牌商名（已认证）',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '品牌名表';

