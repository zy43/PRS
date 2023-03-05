create table tbl_owner_append
(
    owner_id              bigint(19)                 not null comment '品牌商ID'
        primary key,
    owner_name            varchar(255)               null,
    industry              varchar(64)                null comment '品牌分类',
    label                 varchar(64)                null comment '标签',
    introduction          varchar(64)                null comment '品牌商简介',
    come_from             varchar(32)                null comment '来源',
    blue_v                int(3)                     null,
    total_fans            bigint(19)                 null comment '总粉丝数',
    total_videos          bigint(19)                 null comment '总视频数',
    total_likes           bigint(19)                 null comment '总点赞数',
    total_shares          bigint(19)                 null comment '总分享数',
    total_comments        bigint(19)                 null comment '总评论数',
    star_index            decimal(20, 2)             null,
    percent_man           decimal(20, 2)             null comment '男生比例, 10.50 表示 10.5%',
    blue_v_rank_rise      bigint(19)                 null comment '蓝V排行上升 正为上升 负为下降 20200719 sanrenhe',
    region_rank_rise      bigint(19)                 null comment '地区排行上升 正为上升 负为下降 20200719 sanrenhe',
    fans_rank_rise        bigint(19)                 null comment '涨粉排行上升 正为上升 负为下降 20200719 sanrenhe',
    industry_rank_rise    bigint(19)                 null comment '行业排行上升 正为上升 负为下降 20200719 sanrenhe',
    month_digg_rank_rise  bigint(19)                 null comment '近30天点赞增量 正为上升 负为下降 20200719 sanrenhe',
    month_works           bigint(19)                 null comment '近30天作品数  20200722 sanrenhe',
    month_fans_rank_rise  bigint(19)                 null comment '近30天粉丝增量 正为上升 负为下降 20200722 sanrenhe',
    portrait_province     varchar(60)                null comment '粉丝画像主要地域（省级行政区） 20200720 sanrenhe',
    portrait_city         varchar(60)                null comment '粉丝画像主要地域（地级市） 20200720 sanrenhe ',
    portrait_age          int(3)                     null comment '粉丝画像主要年龄 20200720 sanrenhe',
    portrait_sex          int(3)                     null comment '粉丝画像主要性别 （1-男、2-女） 20200720 sanrenhe',
    live_sales            bigint                     null comment '直播销量',
    frequency             int(5)                     null,
    hot_words             varchar(1023)              null comment '品牌热词，用英文逗号分隔',
    heat                  int(5)                     null comment '热度',
    heat_rise             decimal(20, 2)             null comment '热度涨幅',
    relate_videos         bigint(19)                 null comment '关联视频数',
    relate_lives          bigint(19)                 null comment '关联直播场次',
    relate_streamers      bigint(19)                 null comment '关联播主数',
    relate_live_streamers bigint(19)                 null comment '关联直播播主数',
    relate_fans_top       bigint(19)                 null comment '关联人数峰值',
    relate_goods_douyin   bigint(19)                 null comment '抖音商品数',
    create_time           datetime                   null comment '创建时间',
    modified_time         datetime                   null comment '修改时间',
    deleted               tinyint unsigned default 0 null comment '逻辑删除标识(0为否，1为是)'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720963, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', '美食', '美食', '美食', '厨房', null, 666, 555, 444, 432, 121, null, 61.20, 12, 122, 12, 23, 21, 1132, 324, '浙江省', '杭州市', 25, 1, 43, null, '辣条,饼干', 1, 1.00, 32, 21, 123, 21, 4432, 21, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720964, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', '数码', '数码', '数码', '公司', null, 777, 666, 333, 222, 1546, null, 12.30, 11, 134, 12, 14, 25, 100, 213, '浙江省', '台州市', 16, 1, 22, null, '手机', 1, 2.10, 22, 18, 174, 20, 2243, 18, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720965, '台州市烂网公司', '数码', '数码', '数码', '公司', null, 5654, 179, 222, 171, 4648, null, 13.22, 15, 16, 16, 17, 5, 61, 345, '浙江省', '台州市', 22, 1, 34, null, '电脑', 1, 1.30, 17, 17, 166, 66, 67968, 112, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720966, '杭州市好网分公司', '美食', '美食', '美食', '厨房', null, 13123, 141241, 787, 252, 89465, null, 22.10, 12, 12, 13, 5, 98, 9, 43, '浙江省', '杭州市', 11, 1, 25, null, '蛋糕', 1, 1.00, 1, 354, 13546, 3546, 5465, 5465, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720967, '湖北省娃哈哈有限品牌', '美食', '美食', '美食', '厨房', null, 455465, 6487322, 35456, 54654, 564645, null, 11.30, 386, 6431, 456, 546543, 54678, 54, 22, '湖北省', '襄阳市', 22, 2, 17, null, '饮料', 1, 0.32, 1, 22, 1231, 1231, 1231, 222, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720968, '江苏省迅电有限品牌公司', '数码', '数码', '数码', '公司', null, 1323, 11, 135, 123, 1258, null, 2.22, 137, 1212, 2131, 55, 163, 3455, 11, '江苏省', '南京市', 11, 2, 11, null, '电脑', 1, 0.15, 1, 13123, 121, 1235, 645, 456, null, null, 0);
INSERT INTO linglingbo.tbl_owner_append (owner_id, owner_name, industry, label, introduction, come_from, blue_v, total_fans, total_videos, total_likes, total_shares, total_comments, star_index, percent_man, blue_v_rank_rise, region_rank_rise, fans_rank_rise, industry_rank_rise, month_digg_rank_rise, month_works, month_fans_rank_rise, portrait_province, portrait_city, portrait_age, portrait_sex, live_sales, frequency, hot_words, heat, heat_rise, relate_videos, relate_lives, relate_streamers, relate_live_streamers, relate_fans_top, relate_goods_douyin, create_time, modified_time, deleted) VALUES (1364982471720969, '台州市安全有限公司', '数码', '数码', '数码', '公司', null, 54654654, 35433453, 135435, 54354876, 5453, null, 1.28, 123645, 13546, 35435, 53435, 135465, 544, 118, '浙江省', '台州市', 12, 1, 566, null, '网络安全', 1, 0.88, 2, 5631, 1354, 54354, 546, 545, null, null, 0);
