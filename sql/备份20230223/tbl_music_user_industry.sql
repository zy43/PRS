create table tbl_music_user_industry
(
    id             bigint(19) auto_increment
        primary key,
    music_name     varchar(64)                null,
    industry       varchar(64)                null,
    heat_degree    double(3, 2)               null,
    use_number     bigint                     not null comment '音乐使用人数',
    user_image_url varchar(255)               null,
    create_time    datetime                   null comment '创建时间',
    modified_time  datetime                   null comment '修改时间',
    deleted        tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_music_user_industry (id, music_name, industry, heat_degree, use_number, user_image_url, create_time, modified_time, deleted) VALUES (1, '稻香', '体育', 0.3, 123000, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_jinzhouyongshi.png', null, null, 0);
INSERT INTO linglingbo.tbl_music_user_industry (id, music_name, industry, heat_degree, use_number, user_image_url, create_time, modified_time, deleted) VALUES (2, '稻香', '教育', 0.25, 156200, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_jinzhouyongshi.png', null, null, 0);
INSERT INTO linglingbo.tbl_music_user_industry (id, music_name, industry, heat_degree, use_number, user_image_url, create_time, modified_time, deleted) VALUES (3, '稻香', '动漫', 0.26, 745521, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_jinzhouyongshi.png', null, null, 0);
INSERT INTO linglingbo.tbl_music_user_industry (id, music_name, industry, heat_degree, use_number, user_image_url, create_time, modified_time, deleted) VALUES (4, '稻香', '明星', 0.14, 321100, 'http://images.cnblogs.com/cnblogs_com/ws0401/1482701/o_jinzhouyongshi.png', null, null, 0);
