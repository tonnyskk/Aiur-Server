TRUNCATE TABLE aiur_users;
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (200, 'admin', 'DJia', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (201, 'guest', 'G.P', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (202, 'T202', 'T202', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (203, 'T203', 'T203', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (204, 'T204', 'T204', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (205, 'T205', 'T205', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (206, 'T206', 'T206', 'MTIzNA==', NOW(), NOW());
INSERT INTO aiur_users(user_id, login_name, nick_name, password, create_time, update_time) VALUES (207, 'T207', 'T207', 'MTIzNA==', NOW(), NOW());

TRUNCATE TABLE aiur_groups;
INSERT INTO aiur_groups(group_id, group_name, group_desc, owner_id, create_time, update_time) VALUES (100, 'AIUR', 'First group in test', 200, NOW(), NOW());
INSERT INTO aiur_groups(group_id, group_name, group_desc, owner_id, create_time, update_time) VALUES (101, 'ACRD', 'Second group in test', 201, NOW(), NOW());
INSERT INTO aiur_groups(group_id, group_name, group_desc, owner_id, create_time, update_time) VALUES (105, 'TOMY', 'Second group in test', 202, NOW(), NOW());
INSERT INTO aiur_groups(group_id, group_name, group_desc, owner_id, create_time, update_time) VALUES (103, 'CURY', 'Second group in test', 203, NOW(), NOW());
INSERT INTO aiur_groups(group_id, group_name, group_desc, owner_id, create_time, update_time) VALUES (104, 'SAMD', 'Second group in test', 204, NOW(), NOW());

TRUNCATE TABLE aiur_rel_user_group;
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (200, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (201, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (202, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (203, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (204, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (205, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (206, 100,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (207, 100,'JOINED', NOW(), NOW());

INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (200, 101,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (201, 101,'JOINED', NOW(), NOW());

INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (202, 105,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (204, 105,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (205, 105,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (206, 105,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (207, 105,'JOINED', NOW(), NOW());

INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (203, 103,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (204, 103,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (204, 104,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (206, 104,'JOINED', NOW(), NOW());
INSERT INTO aiur_rel_user_group(user_id, group_id, status, create_time, update_time) VALUES (207, 104,'JOINED', NOW(), NOW());

TRUNCATE TABLE aiur_user_incomming;
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (200, 100, 300.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (201, 100, 300.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (202, 100, 300.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (203, 100, 400.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (204, 100, 800.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (205, 100, 500.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (206, 100, 600.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (207, 100, 700.00, 'OK', NOW(), NOW());

INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (200, 101, 300.00, 'OK', NOW(), NOW());
INSERT INTO aiur_user_incomming(user_id, group_id, money, status, create_time, update_time) VALUES (201, 101, 800.00, 'OK', NOW(), NOW());

TRUNCATE TABLE aiur_group_consume;
INSERT INTO aiur_group_consume(consume_id, group_id, request_user_id, description, money, status, create_time, update_time) VALUES (100, 100, 200, 'TESTDATA', 1000.00, 'OK', NOW(), NOW());
INSERT INTO aiur_group_consume(consume_id, group_id, request_user_id, description, money, status, create_time, update_time) VALUES (101, 101, 200, 'TESTDATA', 300.00, 'OK', NOW(), NOW());

TRUNCATE TABLE aiur_user_consume_detail;
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 200, 10, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 201, 100, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 202, 200, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 203, 30, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 204, 400, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 205, 100, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (100, 206, 160, NOW(), NOW());

INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (101, 200, 100, NOW(), NOW());
INSERT INTO aiur_user_consume_detail (consume_id, user_id, money, create_time, update_time ) VALUES (101, 201, 200, NOW(), NOW());