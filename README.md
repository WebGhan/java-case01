```mysql
-- 部门表
create table dept
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    name        varchar(10) not null comment '部门名称',
    create_time datetime    not null comment '创建时间',
    update_time datetime    not null comment '更新时间',
    constraint name
        unique (name)
)
    comment '部门表';

-- 员工表
create table emp
(
    id          int unsigned auto_increment comment 'ID'
        primary key,
    username    varchar(20)                  not null comment '用户名',
    password    varchar(32) default '123456' null comment '密码',
    name        varchar(10)                  not null comment '姓名',
    gender      tinyint unsigned             not null comment '性别，1男，2女',
    image       varchar(300)                 null comment '图像',
    job         tinyint unsigned             null comment '职位',
    entrydate   date                         null comment '入职时间',
    dept_id     int unsigned                 null comment '部门ID',
    create_time datetime                     not null comment '创建时间',
    update_time datetime                     not null comment '更新时间',
    constraint username
        unique (username)
)
    comment '员工表';
```

```mysql
-- 插入部门数据
insert into dept
    (name, create_time, update_time)
values ('学工部', now(), now()),
       ('教研部', now(), now()),
       ('咨询部', now(), now()),
       ('就业部', now(), now()),
       ('人事部', now(), now());

-- 插入员工数据
insert into emp
(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)
values ('lishiming', '李世民', 1, '1.jpg', 4, '2020-01-01', 2, now(), now()),
       ('libai', '李白', 1, '2.jpg', 2, '2021-01-01', 2, now(), now()),
       ('zhangsan', '张三', 1, '3.jpg', 4, '2012-01-01', 2, now(), now()),
       ('zhangwuji', '张无忌', 1, '4.jpg', 1, '2008-01-01', 2, now(), now()),
       ('zhangsanfeng', '张三丰', 1, '5.jpg', 1, '2010-01-01', 1, now(), now()),
       ('zhangfei', '张飞', 1, '6.jpg', 4, '2020-01-01', 1, now(), now()),
       ('wuzetian', '武则天', 2, '7.jpg', 5, '2021-01-01', 1, now(), now()),
       ('liqingzhao', '李清照', 2, '8.jpg', 2, '2022-01-01', 1, now(), now()),
       ('guofurong', '郭芙蓉', 2, '9.jpg', 3, '2015-01-01', 3, now(), now()),
       ('lilongji', '李隆基', 1, '10.jpg', 1, '2018-01-01', 3, now(), now()),
       ('yangguo', '杨过', 1, '11.jpg', 4, '2023-01-01', 3, now(), now()),
       ('lishishi', '李师师', 2, '12.jpg', 4, '2023-01-01', 3, now(), now()),
       ('zhaoyun', '赵云', 1, '13.jpg', 4, '2023-01-01', 3, now(), now()),
       ('guanyunchang', '关云长', 1, '14.jpg', 4, '2023-01-01', 3, now(), now()),
       ('liubei', '刘备', 1, '15.jpg', 4, '2023-01-01', 3, now(), now()),
       ('caocao', '曹操', 1, '16.jpg', 4, '2023-01-01', 3, now(), now()),
       ('wangzhaojun', '王昭君', 2, '17.jpg', 4, '2023-01-01', 3, now(), now()),
       ('caiwenji', '蔡文姬', 2, '18.jpg', 4, '2023-01-01', 3, now(), now()),
       ('wusangui', '吴三桂', 1, '19.jpg', 4, '2023-01-01', 3, now(), now());
```