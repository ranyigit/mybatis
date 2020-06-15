CREATE TABLE role(
id int(11) PRIMARY key not null comment '编号',
role_name VARCHAR(30) DEFAULT null,
role_desc VARCHAR(60) DEFAULT null
) ENGINE=INNODB default CHARSET=utf8

insert into role (id,role_name,role_desc) VALUES (1,'院长','管理整个学院');
insert into role (id,role_name,role_desc) VALUES (2,'总裁','管理整个公司');
insert into role (id,role_name,role_desc) VALUES (3,'校长','管理整个学校');


create table user_role(
uid int(11) not null,
rid int(11) not null
)ENGINE=INNODB default CHARSET=utf8

insert into user_role(uid,rid) values (1,1);
insert into user_role(uid,rid) values (5,1);
insert into user_role(uid,rid) values (7,2);