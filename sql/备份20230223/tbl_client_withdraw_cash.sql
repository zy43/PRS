create table tbl_client_withdraw_cash
(
    id               bigint                     not null comment '主键'
        primary key,
    client_id        bigint                     null comment '主播/品牌商id',
    company_name     varchar(30)                null comment '所属企业名称(主播可不填，也可以填主播账号名称)',
    withdraw_amount  decimal(8, 2)              null comment '提现金额',
    card_num         varchar(40)                null comment '提现卡号',
    bank             varchar(60)                null comment '开户行',
    person_name      varchar(20)                null comment '提现人姓名',
    remark           varchar(60)                null comment '备注描述',
    withdraw_status  int(10)          default 1 null comment '状态 1: 审核中2: 已完成 3: 提现失败',
    auditor_admin_id bigint                     null comment '审核人id(管理员)',
    create_time      datetime                   null comment '创建时间',
    modified_time    datetime                   null comment '修改时间',
    deleted          tinyint unsigned default 0 null comment '逻辑删除标识（0为否，1为是）',
    role_id          bigint                     null comment '9.主播 10.品牌商'
)
    comment '主播/品牌商提现表';

INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1368975103983616, 1364982471720960, null, 1.00, null, null, null, null, 2, 1, '2022-12-15 21:49:47', '2023-02-14 10:16:22', 0, 10);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1369720911036416, 1364982471720960, null, 10.00, '6222023522828012225', '北京', '罗亦菲', '主播提现', 1, null, '2022-12-26 10:43:16', null, 0, 5);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1369721088163840, 1364982471720960, null, 10.00, '6222023522828012225', '北京', '曹艳', '', 1, null, '2022-12-26 10:46:53', null, 0, 5);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1370721199882240, 1364982471720960, null, 123.00, '62232701234567892', '打大', '大神', '', 1, null, '2023-01-09 13:54:12', null, 0, 5);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1372424653578240, 1364982471720960, null, 123.00, '6226310123456780', 'sdad', '姜熙涵', '', 1, null, '2023-02-02 15:31:03', null, 0, 5);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1372482720243712, 1364982471720960, null, 2000.00, '6223330123456781', '等等', '等等', '', 2, null, '2023-02-03 11:12:26', null, 0, 5);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1372482720243713, 1364916962402304, null, 2000.00, '6222023522828012226', '中国银行', '吴京', '主播提现', 2, 1364982482960384, '2023-02-11 21:54:41', null, 0, 9);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1373207209426944, 1364916962402304, null, 133.00, '5440330123456780', 'aaa', '文佳琪', 'ddd', 1, null, '2023-02-13 16:52:12', null, 0, 9);
INSERT INTO linglingbo.tbl_client_withdraw_cash (id, client_id, company_name, withdraw_amount, card_num, bank, person_name, remark, withdraw_status, auditor_admin_id, create_time, modified_time, deleted, role_id) VALUES (1373259071537152, 1364916962402304, null, 1111.00, '5440330123456780', '11', '郝敏', '', 1, null, '2023-02-14 10:27:20', null, 0, 9);
