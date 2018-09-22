-- 用户表 --
CREATE TABLE user(
   uid int auto_increment COMMENT '用户uid',
   username VARCHAR(20) COMMENT '用户名', 
   password VARCHAR(50) COMMENT '用户密码',
   userstate int(2) COMMENT '用户状态',
   create_time datetime default NOW() COMMENT '创建时间',
   update_time datetime default NOW() COMMENT '更新时间',
   PRIMARY KEY(uid),
   unique(username)
)ENGINE = INNODB CHARSET = UTF8;
-- 角色表 -- 
create table roles(
   rid int auto_increment COMMENT '角色rid',
   rname VARCHAR(20) COMMENT '角色名称',
   create_time datetime default NOW() COMMENT '创建时间',
   update_time datetime default NOW() COMMENT '更新时间',
   PRIMARY KEY(rid),
   unique(rname)
)ENGINE = INNODB CHARSET = UTF8;

-- 权限表 --
create TABLE permissions(
   pid int auto_increment COMMENT '权限pid',
   pname varchar(20) COMMENT '权限名称',
   create_time datetime default NOW() COMMENT '创建时间',
   update_time datetime default NOW() COMMENT '更新时间',
   PRIMARY key(pid),
   unique(pname)
)ENGINE = INNODB charset = utf8;

-- 用户角色表 --
create table user_roles(
   uid INT COMMENT '用户uid',
   rid int COMMENT '角色rid',
   index index_uid(uid),
   index index_rid(rid)
)ENGINE = INNODB CHARSET = utf8;

-- 角色权限表 --
create table roles_permissions(
   rid INT COMMENT '角色rid',
   pid INT COMMENT '权限pid',
   index index_rid(rid),
   index index_pid(pid)
)ENGINE = INNODB CHARSET = utf8;
