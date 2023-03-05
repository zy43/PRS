create table tbl_topic
(
    topic         varchar(255)               not null
        primary key,
    participation bigint(19)                 null,
    amount_play   bigint(19)                 null,
    using_trend   varchar(255)               null,
    hot_three     varchar(255)               null,
    most_comments bigint(19)                 null,
    most_shared   bigint(19)                 null,
    create_time   datetime                   null comment '创建时间',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_topic (topic, participation, amount_play, using_trend, hot_three, most_comments, most_shared, create_time, modified_time, deleted) VALUES ('明星1', 1000, 5000, 'up', 'url,url2,url3', 1000, 5000, null, null, 0);
INSERT INTO linglingbo.tbl_topic (topic, participation, amount_play, using_trend, hot_three, most_comments, most_shared, create_time, modified_time, deleted) VALUES ('明星2', 2000, 4000, 'up', 'url,url2,url3', 2000, 4000, null, null, 0);
INSERT INTO linglingbo.tbl_topic (topic, participation, amount_play, using_trend, hot_three, most_comments, most_shared, create_time, modified_time, deleted) VALUES ('明星3', 3000, 3000, 'up', 'url,url2,url3', 3000, 3000, null, null, 0);
INSERT INTO linglingbo.tbl_topic (topic, participation, amount_play, using_trend, hot_three, most_comments, most_shared, create_time, modified_time, deleted) VALUES ('明星4', 4000, 2000, 'up', 'url,url2,url3', 4000, 2000, null, null, 0);
INSERT INTO linglingbo.tbl_topic (topic, participation, amount_play, using_trend, hot_three, most_comments, most_shared, create_time, modified_time, deleted) VALUES ('明星5', 5000, 1000, 'up', 'url,url2,url3', 5000, 1000, null, null, 0);
