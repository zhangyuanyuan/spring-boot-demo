insert into `person` (`name`, `age`, `address`)  VALUES ('zzz', 22, '上海');
insert into `person` (`name`, `age`, `address`)  VALUES ('xxx', 23, '上海');
insert into `person` (`name`, `age`, `address`) VALUES ('ccc', 26, '南京');
insert into `person` (`name`, `age`, `address`)  VALUES ('vvv', 32, '上海');
insert into `person` (`name`, `age`, `address`) VALUES ('bbb', 42, '北京');
insert into `person` (`name`, `age`, `address`) VALUES ('nnn', 29, '上海');

insert into `sys_user` (`id`, `username`, `password`) VALUES (1, 'quanquan', 'quanquan');
insert into `sys_user` (`id`, `username`, `password`) VALUES (2, 'haha', 'haha');

insert into `sys_role` (`id`, `name` ) VALUES (1, 'ROLE_ADMIN');
insert into `sys_role` (`id`, `name`) VALUES (2, 'ROLE_USER');

insert into `sys_user_roles` (`sys_user_id`, `roles_id`) VALUES (1, 1);
insert into `sys_user_roles` (`sys_user_id`, `roles_id`) VALUES (2, 2);

