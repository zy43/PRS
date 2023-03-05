create table tbl_task_streamer
(
    id                  bigint                        not null comment '主键'
        primary key,
    task_id             bigint                        null comment '任务id，对应tbl_task的id属性',
    auditor_owner_id    bigint(19)                    null comment '承接审核人id(品牌商)',
    streamer_id         bigint                        null comment '主播的用户id',
    streamer_name       varchar(60)                   null comment '播主的用户名',
    commission_percent  decimal(8, 2)                 null comment '播主佣金比例',
    fee                 decimal(8, 2)                 null comment '播主坑位费金额',
    operate_info        varchar(100)                  null comment '播主运营信息',
    remark              varchar(255)                  null comment '备注',
    settle_money        decimal(8, 2)    default 0.00 null comment '结算金额',
    settle_remark       varchar(100)                  null comment '结算备注',
    complete_num        int(10)          default 0    null comment '播主完成量',
    platform_commission decimal(8, 2)    default 0.00 null comment '平台佣金金额',
    task_detail_status  tinyint(3)       default 1    null comment '任务状态：1.待承接 2.承接审核中 3.承接审核失败 4.履约中 5. 结算审核中 6. 结算审核失败 7. 已完成',
    create_time         datetime                      null comment '创建时间',
    modified_time       datetime                      null comment '修改时间',
    deleted             tinyint unsigned default 0    null comment '逻辑删除标识（0为否，1为是）'
)
    comment '任务承接结算表';

INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368534108585984, 1368534096035840, 1364982471720960, 1364982471720960, 'zyzyzy', 1.00, null, '1', '1', 1.00, '1', 1, 1.00, 5, '2022-12-09 16:17:43', '2022-12-09 16:18:06', 1);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368536044380160, 1368536034598912, 1364982471720960, 1364982471720960, 'zyzyzy', 1.00, null, '1', '1', 1.00, '', 1, 1.00, 5, '2022-12-09 16:57:06', '2022-12-09 16:57:30', 1);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368540025651200, 1368540014804992, 1364982471720960, 1364982471720960, 'zyzyzy', 1.00, null, '1', null, 1.00, '', 1, 0.00, 7, '2022-12-09 18:18:06', '2022-12-09 18:44:10', 1);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908928, 1368731016765440, 1364982471720960, 1364982471720960, 'zyzyzy', 10.00, null, '1111111', null, 10.00, '', 10, 0.01, 7, '2022-12-12 11:08:01', '2022-12-12 11:08:38', 1);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908929, 1368540014804993, 1364982471720960, 1364916962402304, 'streamer001', 0.63, 1096.91, 'If your Internet Service Provider (ISP) does                    ', 'Secure Sockets Layer(SSL) is a protocol for transmitting private documents via the Internet. The Navigation pane employs tree structure which allows you to take action upon the database               ', 19426.83, '结算无误', 989, 66.88, 7, '2016-06-03 14:56:18', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908930, 1368540014804994, 1364982471720960, 1364916962402304, 'streamer001', 0.93, 830.43, 'All journeys have secret destinations of which                  ', 'Difficult circumstances serve as a textbook of life for people. A comfort zone is a beautiful place, but nothing ever grows there.', 18634.94, '结算无误', 921, 9.16, 7, '2004-01-26 18:32:18', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908931, 1368540014804995, 1364982471720960, 1364916962402304, 'streamer001', 0.23, 1821.05, 'HTTP Tunneling is a method for connecting to                    ', 'Creativity is intelligence having fun. Export Wizard allows you to export data from tables, collections, views, or query results to any available formats.', 19005.51, '结算无误', 783, 335.34, 7, '2013-07-24 11:38:58', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908932, 1368540014804996, 1364982471720960, 1364916962402304, 'streamer001', 0.86, 890.09, 'Success consists of going from failure to failure               ', 'It collects process metrics such as CPU load, RAM usage, and a variety of other resources over SSH/SNMP. Navicat Data Modeler enables you to build high-quality conceptual, logical and                 ', 10315.07, '结算无误', 963, 154.21, 7, '2014-05-18 12:33:02', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908933, 1368540014804997, 1364982471720960, 1364916962402304, 'streamer001', 0.22, 1122.83, 'It can also manage cloud databases such as Amazon               ', 'In the Objects tab, you can use the List List, Detail Detail and ER Diagram ER Diagram buttons to change the object view. The first step is as good as half over. To open a query using                 ', 12260.06, '结算无误', 668, 83.40, 7, '2008-07-15 09:23:31', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908934, 1368540014804998, 1364982471720960, 1364916962402304, 'streamer001', 0.45, 1814.27, 'Navicat is a multi-connections Database Administration          ', 'Navicat Data Modeler is a powerful and cost-effective database design tool which helps you build high-quality conceptual, logical and physical data models.', 15858.67, '结算无误', 756, 62.36, 7, '2021-08-18 12:07:04', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908935, 1368540014804999, 1364982471720960, 1364916962402304, 'streamer001', 0.44, 1843.51, 'Instead of wondering when your next vacation                    ', 'You must be the change you wish to see in the world. If the Show objects under schema in navigation pane option is checked at the Preferences window, all database objects are also displayed           ', 13027.04, '结算无误', 737, 42.80, 7, '2014-12-11 10:34:05', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908936, 1368540014805000, 1364982471720960, 1364916962402304, 'streamer001', 0.65, 1059.67, 'Navicat provides a wide range advanced features,                ', 'Creativity is intelligence having fun. Actually it is just in an idea when feel oneself can achieve and cannot achieve.', 10524.33, '结算无误', 638, 226.72, 4, '2003-11-17 10:12:39', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908937, 1368540014805001, 1364982471720960, 1364916962402304, 'streamer001', 0.52, 1729.14, 'To get a secure connection, the first thing you                 ', 'Anyone who has never made a mistake has never tried anything new. Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon                  ', 13856.21, '结算无误', 677, 259.40, 4, '2021-06-08 00:10:32', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908938, 1368540014805002, 1364982471720960, 1364916962402304, 'streamer001', 0.71, 1331.79, 'Typically, it is employed as an encrypted version of Telnet.', 'It provides strong authentication and secure encrypted communications between two hosts, known as SSH Port Forwarding (Tunneling), over an insecure network. In the Objects tab, you                    ', 15491.87, '结算无误', 719, 372.33, 4, '2006-01-28 07:12:21', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908939, 1368540014805003, 1364982471720960, 1364916962402304, 'streamer001', 0.81, 1438.98, 'To successfully establish a new connection to                   ', 'Monitored servers include MySQL, MariaDB and SQL Server, and compatible with cloud databases like Amazon RDS, Amazon Aurora, Oracle Cloud, Google Cloud and Microsoft Azure.                            ', 15763.59, '结算无误', 959, 266.81, 4, '2015-09-13 22:21:31', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908940, 1368540014805004, 1364982471720960, 1364916962402304, 'streamer001', 0.29, 1689.47, 'The Main Window consists of several toolbars                    ', 'All journeys have secret destinations of which the traveler is unaware. The repository database can be an existing MySQL, MariaDB, PostgreSQL, SQL Server, or Amazon RDS instance.                      ', 16676.86, '结算无误', 742, 398.85, 4, '2009-11-23 16:49:08', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908941, 1368540014805005, 1364982471720960, 1364916962402304, 'streamer001', 0.02, 1315.52, 'To start working with your server in Navicat,                   ', 'All journeys have secret destinations of which the traveler is unaware. The reason why a great man is great is that he resolves to be a great man. To start working with your server                    ', 10159.68, '结算无误', 833, 475.80, 4, '2005-03-09 02:44:48', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908942, 1368540014805006, 1364982471720960, 1364916962402304, 'streamer001', 0.79, 1455.39, 'Always keep your eyes open. Keep watching. Because              ', 'Secure SHell (SSH) is a program to log in into another computer over a network, execute commands on a remote server, and move files from one machine to another. Navicat Monitor requires               ', 12211.65, '结算无误', 892, 268.93, 4, '2018-09-09 18:07:18', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1368731222908943, 1368540014805007, 1364982471720960, 1364916962402304, 'streamer001', 0.78, 1468.55, 'SQL Editor allows you to create and edit SQL                    ', 'In the middle of winter I at last discovered that there was in me an invincible summer. Export Wizard allows you to export data from tables, collections, views, or query results to                    ', 11267.71, '结算无误', 611, 358.62, 4, '2005-06-25 13:24:12', null, 0);
INSERT INTO linglingbo.tbl_task_streamer (id, task_id, auditor_owner_id, streamer_id, streamer_name, commission_percent, fee, operate_info, remark, settle_money, settle_remark, complete_num, platform_commission, task_detail_status, create_time, modified_time, deleted) VALUES (1373204431822848, 1373204400717824, 1364982471720960, 1364982471720960, 'zyzyzy', 1.00, null, '111', null, 0.00, null, 0, 0.00, 4, '2023-02-13 15:55:41', '2023-02-13 15:55:59', 0);
