-- Interface 
/*
 * 1. User login
 *    URL: user/login
 *    Method: POST
 *    Request: 
 *       {
 *         loginName : 'admin',
 *         pwd : 'admin'
 *       }
 *    Response: 
 *       {
 *         statusCode : 200,
 *         statusMessage: 'OK',
 *         data : { 
 *                  useID : 12312,
 *                  loginName : 'admin',
 *                  nickName: 'admin'
 *                }
 *       }
 * 2. User regist
 *    URL: user/regist
 *    Method: POST
 *    Request: 
 *       {
 *         nickName: 'admin',
 *         loginName : 'admin',
 *         pwd : 'admin'
 *       }
 *    Response: 
 *       {
 *         statusCode : 200,
 *         statusMessage: 'OK',
 *         data : { 
 *                  useID : 12312,
 *                  loginName : 'admin',
 *                  nickName: 'admin'
 *                }
 *       }
 */
-- User login
SELECT user_id,
	   login_name,
	   nick_name
  FROM aiur_users
 WHERE login_name = ''
   AND password = '';

INSERT INTO aiur_users (
	login_name,
	nick_name,
	password,
	create_time,
	update_time
)values(
	#login_name:VARCHAR#,
	#login_name:VARCHAR#,
	#password:VARCHAR#,
	now(),
	now()
);

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


 
