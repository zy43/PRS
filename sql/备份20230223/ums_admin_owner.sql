create table ums_admin_owner
(
    id              bigint auto_increment
        primary key,
    owner_name      varchar(64)                       null comment '品牌商/政府机构名称',
    real_name       varchar(18)                       null comment '法人姓名',
    id_card         varchar(18)                       null comment '身份证号',
    certification   varchar(18)      default '未认证' null comment '认证状态（审核中、已认证、未认证）',
    image_id        bigint                            null comment '图片id',
    account_balance decimal(8, 2)    default 0.00     not null comment '账户余额',
    industry        varchar(64)                       null comment '所属行业',
    contact_name    varchar(18)                       null comment '联系人姓名',
    contact_tel     varchar(18)                       null comment '联系人手机号',
    company_name    varchar(18)                       null comment '所属企业名称',
    deposit_status  varchar(18)      default '未缴费' null comment '保证金缴纳状态（未缴费、已缴费、余额不足）',
    owner_desc      varchar(255)                      null comment '品牌商描述',
    create_time     datetime                          null comment '创建时间',
    modified_time   datetime                          null comment '修改时间',
    deleted         tinyint unsigned default 0        null comment '逻辑删除标识（0为否，1为是）'
)
    comment '品牌商/政府机构表' charset = utf8;

INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720960, 'owner001', null, null, '已认证', null, 19998.00, null, null, null, '天津理工大学', '未缴费', null, '2022-10-20 11:59:29', '2022-11-08 16:00:49', 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720961, '', '', '', '', 0, 0.00, '', '卢汝鑫', '19134182962', '天津理工大学', '未缴费', null, '2022-11-08 14:40:03', '2022-11-08 16:00:58', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720962, '湖北省昌爱泽俊情房地产普通合伙', '', '', '未认证', 0, 0.00, '', '卢汝鑫', '19134182962', '天津理工大学', '未缴费', null, '2022-11-08 16:03:45', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720963, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', '', '', '已认证', 0, 0.00, '', '文晶滢', '17819545268', '新疆师范大学', '未缴费', null, '2022-11-08 16:04:22', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720964, '新疆维吾尔自治区星泰垒斯蓝德服务普通合伙', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:04:53', '2022-11-08 16:20:17', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720965, '台州市烂网公司', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:07:29', '2022-11-08 16:19:55', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720966, '杭州市好网分公司', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:20:39', '2022-11-08 16:20:53', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720967, '湖北省娃哈哈有限品牌', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:22:46', '2023-02-10 17:53:05', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720968, '江苏省迅电有限品牌公司', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:22:48', '2022-11-08 16:23:00', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1364982471720969, '台州市安全有限公司', '', '', '审核中', 0, 0.00, '', '谢润莎', '17775988945', '吉林建筑大学', '未缴费', null, '2022-11-08 16:22:50', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1366550210052096, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-11-11 15:35:12', null, 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1366887164248064, '', null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-11-16 09:50:33', '2023-02-10 17:52:39', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1367541916024832, '新疆维吾尔自治区阳成霖平锐教育有限公司', null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-11-25 15:51:30', '2023-02-10 17:53:02', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1367541933981696, '新疆维吾尔自治区阳成霖平锐教育有限公司', null, null, '未认证', null, 0.00, '计算机', null, null, '宁夏大学', '未缴费', '君子食无求饱，居无求安，敏于事而慎于言，就有道而正焉，可谓好学也已。', '2022-11-25 15:51:52', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1368388715421696, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-12-07 14:59:41', null, 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1368388922400768, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-12-07 15:03:54', '2023-02-10 17:52:56', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1368390629883904, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-12-07 15:38:38', '2023-02-10 17:52:54', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1368390866911232, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2022-12-07 15:43:27', '2023-02-10 17:52:48', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998180904960, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 17:59:30', '2023-02-10 18:06:32', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998323912704, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 18:02:25', '2023-02-10 18:06:33', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998336864256, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 18:02:40', '2023-02-10 18:06:27', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998351134720, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 18:02:58', '2023-02-10 18:06:30', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998427860992, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 18:04:32', '2023-02-10 18:06:18', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1372998534725632, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-10 18:06:42', '2023-02-10 18:09:55', 1);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1373494069919744, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-17 18:08:23', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1373494102335488, '123123', null, null, '未认证', null, 0.00, '服装', null, null, '卢静', '未缴费', '学如不及，犹恐失之。', '2023-02-17 18:09:03', null, 0);
INSERT INTO linglingbo.ums_admin_owner (id, owner_name, real_name, id_card, certification, image_id, account_balance, industry, contact_name, contact_tel, company_name, deposit_status, owner_desc, create_time, modified_time, deleted) VALUES (1373494306070528, null, null, null, '未认证', null, 0.00, null, null, null, null, '未缴费', null, '2023-02-17 18:13:12', null, 0);
