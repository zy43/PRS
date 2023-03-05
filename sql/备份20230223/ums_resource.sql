create table ums_resource
(
    id            bigint auto_increment
        primary key,
    create_time   datetime                   null comment '创建时间',
    name          varchar(200)               null comment '资源名称',
    url           varchar(200)               null comment '资源URL',
    description   varchar(500)               null comment '描述',
    category_id   bigint                     null comment '资源分类ID',
    modified_time datetime                   null comment '修改时间',
    deleted       tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）'
)
    comment '后台资源表' charset = utf8;

INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (2, '2020-02-04 17:05:35', '商品分类管理', '/category/goods/**', null, 1, '2022-10-25 14:16:20', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (5, '2020-02-04 17:09:16', '商品管理', '/goods/**', null, 1, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (25, '2020-02-07 16:47:34', '后台用户管理', '/admin/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (26, '2020-02-07 16:48:24', '后台用户角色管理', '/role/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (27, '2020-02-07 16:48:48', '后台菜单管理', '/menu/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (28, '2020-02-07 16:49:18', '后台资源分类管理', '/resourceCategory/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (29, '2020-02-07 16:49:45', '后台资源管理', '/resource/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364763873550336, '2022-10-17 01:52:05', '行业分类管理', '/category/industry/**', '', 1, '2022-10-25 14:16:52', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764033875968, '2022-10-17 01:55:21', '品牌商管理', '/owner/**', '', 1364763385634816, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764072247296, '2022-10-17 01:56:08', '播主管理', '/streamer/**', '', 1364763385634816, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764108660736, '2022-10-17 01:56:52', '任务管理-品牌方', '/task/owner/**', '', 1364763164188672, '2022-10-20 03:36:51', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764507725824, '2022-10-17 02:04:59', '任务管理-播主', '/task/streamer/**', '', 1364763164188672, '2022-10-20 03:41:25', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764534751232, '2022-10-17 02:05:32', '任务管理-运营人员', '/task/operator/**', '', 1364763164188672, '2022-10-20 03:41:51', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764823814144, '2022-10-17 02:11:25', '任务发布审核', '/examine/task/**', '', 1364763393245184, '2022-10-20 03:42:00', 1);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364764972646400, '2022-10-17 02:14:27', '组织机构管理', '/department/**', '', 4, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364765009125376, '2022-10-17 02:15:12', '图片上传', '/oss/**', '', 1364764990332928, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364849805377536, '2022-10-18 07:00:23', '审核管理-品牌方', '/audit/owner/**', '', 1364763393245184, '2022-10-18 07:07:26', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364849855004672, '2022-10-18 07:01:23', '审核管理-运营人员', '/audit/operator/**', '', 1364763393245184, '2022-10-18 07:02:51', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364849910964224, '2022-10-18 07:02:31', '提现审核', '/audit/withdraw/**', '', 1364763393245184, '2022-10-20 03:44:47', 1);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850221801472, '2022-10-18 07:08:51', '保证金管理', '/account/deposit/**', '', 1364763424997376, '2022-10-19 09:07:49', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850299772928, '2022-10-18 07:10:26', '收益/收入', '/account/income/**', '', 1364763424997376, '2022-10-18 07:12:07', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850371919872, '2022-10-18 07:11:54', '提现记录', '/account/withdrawRecord/**', '', 1364763424997376, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850464333824, '2022-10-18 07:13:47', '个人中心', '/user/Info/**', '', 1364763414249472, '2022-10-18 07:15:17', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850531729408, '2022-10-18 07:15:09', '实名认证审核', '/user/infoExamine/**', '', 1364763414249472, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850565226496, '2022-10-18 07:15:50', '个人设置', '/user/setting/**', '', 1364763414249472, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850751111168, '2022-10-18 07:19:37', '登录', '/login/**', '', 6, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850770911232, '2022-10-18 07:20:01', '注册', '/register/**', '', 6, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364850802933760, '2022-10-18 07:20:40', '首页工作台', '/platform/**', '', 6, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851008716800, '2022-10-18 07:24:52', '搜索页面', '/streamer/searchPage/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851032096768, '2022-10-18 07:25:20', '搜索列表', '/streamer/searchList/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851097837568, '2022-10-18 07:26:40', '主播详细', '/streamer/detail/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851137036288, '2022-10-18 07:27:28', '主播排行榜', '/streamer/rank/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851168141312, '2022-10-18 07:28:06', '星图热榜', '/streamer/starChart/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851206561792, '2022-10-18 07:28:53', '抖音号对比', '/streamer/streamerCompare/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851226083328, '2022-10-18 07:29:17', 'MCN媒体库', '/streamer/MCN/**', '', 1364850862768128, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851264036864, '2022-10-18 07:30:03', '我的抖音号', '/monitor/accountList/**', '', 1364850874744832, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851299868672, '2022-10-18 07:30:47', '我的授权', '/monitor/authorize/**', '', 1364850874744832, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851335880704, '2022-10-18 07:31:31', '我的收藏', '/monitor/collection/**', '', 1364850874744832, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364851351740416, '2022-10-18 07:31:50', '带货能力诊断', '/monitor/saleCheck/**', '', 1364850874744832, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926290870272, '2022-10-19 08:56:29', '商品搜索', '/analysis/goodsSearch/**', '', 1364850884575232, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926326693888, '2022-10-19 08:57:12', '热门带货视频', '/analysis/video/**', '', 1364850884575232, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926392999936, '2022-10-19 08:58:33', '电商视频排行', '/analysis/videoRank/**', '', 1364850884575232, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926457298944, '2022-10-19 08:59:52', '电商商品排行', '/analysis/productRank/**', '', 1364850884575232, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926513152000, '2022-10-19 09:01:00', '明星达人销售榜', '/analysis/saleRank/**', '', 1364850884575232, null, 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926592032768, '2022-10-19 09:02:36', '电商品牌排行', '/brand/rank/**', '', 1364850890481664, '2022-10-19 09:03:16', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926648254464, '2022-10-19 09:03:45', '品牌精准搜索', '/brand/research/**', '', 1364850890481664, '2022-12-29 15:16:01', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1364926673190912, '2022-10-19 09:04:15', '品牌多维对比', '/brand/compare/**', '', 1364850890481664, '2022-12-29 15:16:03', 0);
INSERT INTO linglingbo.ums_resource (id, create_time, name, url, description, category_id, modified_time, deleted) VALUES (1368960561422336, '2022-12-15 16:53:55', 'myInfo', '/myInfo', null, null, null, 0);
