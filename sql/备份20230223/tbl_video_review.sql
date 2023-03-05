create table tbl_video_review
(
    id               bigint(19) auto_increment comment '唯一编号（UUID自动生成）'
        primary key,
    video_id         bigint(19)                 not null comment '视频ID',
    comment_user_img varchar(255)               not null comment '评论用户头像 20200720 sanrenhe',
    comment_user     varchar(64)                not null comment '评论用户',
    content          varchar(255)               not null comment '评论内容',
    liked            bigint                     not null comment '被点赞数',
    classification   int(3)                     null,
    price_related    int(3)                     null,
    comment_time     datetime                   not null comment '评论时间',
    influence        int(3)                     null,
    create_time      datetime                   null comment '创建时间',
    modified_time    datetime                   null comment '修改时间',
    deleted          tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    charset = utf8;

INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (1, 1111, '123.jpg', '1ku', '冲冲冲', 1000, 1, 1, '2020-06-03 14:10:08', 88, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (2, 1111, '123.jpg', '2ku', '加油加油', 2000, 2, 0, '2020-06-03 14:10:39', 88, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (3, 1111, '123.jpg', '3ku', '不错不错', 1500, 0, 1, '2020-05-25 14:11:07', 88, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (4, 1111, '123.jpg', '4ku', '有待提高', 2500, 1, 0, '2020-07-09 14:11:30', 88, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (5, 1111, '123.jpg', '5ku', '继续努力', 3000, 1, 1, '2020-02-04 14:12:33', 88, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (6, 1111, '123.jpg', '6ku', '中国最棒', 54, 2, 2, '2021-03-04 14:14:33', 45, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (7, 1111, '123.jpg', '7ku', '你是最棒的', 23, 2, 2, '2021-04-04 14:27:36', 65, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (8, 1111, '123.jpg', '8ku', '我是最棒的', 43, 2, 2, '2021-05-04 14:23:33', 12, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (9, 1111, '123.jpg', '9ku', '向前冲', 56, 2, 2, '2021-06-04 18:19:33', 43, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (10, 1111, '123.jpg', '10ku', '明天星期一', 64, 1, 2, '2021-07-04 19:18:33', 54, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (11, 1111, '123.jpg', '11ku', '不想上学', 24, 1, 1, '2021-08-04 20:15:27', 87, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (12, 1111, '123.jpg', '12ku', '不想上班', 53, 1, 1, '2021-09-04 21:12:29', 65, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (13, 1111, '123.jpg', '13ku', '实名羡慕', 57, 1, 1, '2021-10-04 23:12:12', 87, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (14, 1111, '123.jpg', '14ku', '少点作业少点考试吧', 97, 1, 1, '2022-11-04 09:12:37', 15, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (15, 1111, '123.jpg', '15ku', '视频真不错', 1, 2, 1, '2022-12-04 08:12:56', 3, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (16, 1111, '123.jpg', '16ku', '质量真高', 4, 2, 1, '2023-01-04 07:12:36', 54, null, null, 0);
INSERT INTO linglingbo.tbl_video_review (id, video_id, comment_user_img, comment_user, content, liked, classification, price_related, comment_time, influence, create_time, modified_time, deleted) VALUES (17, 1111, '123.jpg', '17ku', '作者牛逼', 3, 2, 1, '2023-02-04 04:12:45', 87, null, null, 0);
