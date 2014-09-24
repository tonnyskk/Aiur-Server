-- User login
SELECT user_id,
	   login_name,
	   nick_name
  FROM aiur_users
 WHERE login_name = ''
   AND password = '';

-- Get user group infor
SELECT g.group_id,
       g.group_name,
       r.user_id == g.owner_id  as is_owner
  FROM aiur_groups g,
       aiur_rel_user_group r
 WHERE g.group_id = r.group_id
   AND r.user_id = 1100;

-- Get group activity for user
SELECT g.description,
       g.group_id,
       g.money,
       g.status
  FROM aiur_group_consume g,
       aiur_user_consume_detail u
 WHERE g.consume_id = u.consume_id
   AND u.user_id = 1100
 ORDER BY g.update_time DESC


 
