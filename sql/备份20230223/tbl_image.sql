create table tbl_image
(
    id            bigint                     not null comment '主键',
    image_id      bigint                     not null comment '图片id',
    image_name    varchar(64)                null comment '图片名称',
    image_url     varchar(1000)              null comment '图片相对路径',
    bucket_name   varchar(32)                null comment 'minio桶名称',
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '图片信息表';

INSERT INTO linglingbo.tbl_image (id, image_id, image_name, image_url, bucket_name, create_time, modified_time, deleted) VALUES (1373205629181952, 1373205628682240, '1676276402215GLE3KYJJPB.jpg', 'http://124.222.217.61:9091/00bo-test/1676276402215GLE3KYJJPB.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20230213%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20230213T082002Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=f19f074654f734db40e0b658e4423cb4624884807fc0ec58a904cafc31a5b26d', '00bo-test', '2023-02-13 16:20:03', null, 0);
