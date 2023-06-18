drop table if exists t_admin;

create table t_admin(
    id int primary key auto_increment,
    nick_name varchar(32),
    account varchar(32),
    password varchar(32)
)charset=utf8;

insert into t_admin values (1, "超级管理员", 'admin', '123456');
insert into t_admin values (2, "用户管理员", 'admin1', '123456');
insert into t_admin values (3, "视频管理员", 'admin2', '123456');

drop table if exists t_video_type;

create table t_video_type(
    id int primary key auto_increment,
    name varchar(32),
    description text
)charset=utf8;

insert into t_video_type values (1, "动作", '武打动作');
insert into t_video_type values (2, "动画", '小孩子看的');
insert into t_video_type values (3, "科幻", '科幻科幻');

drop table if exists t_video;

create table t_video(
    -- 主键
    id int primary key auto_increment,
    -- 名称
    name varchar(32),
    -- 导演
    director varchar(32),
    -- 主演
    roles varchar(64),
    -- 时长(分钟)
    minute_length int,
    -- 上线
    product_date date,
    -- 地域
    area varchar(32),
    -- 描述
    description text,
    -- 类型
    type_id int,
    -- 图片
    image_path varchar(128),
    -- 视频
    video_path varchar(128)
)charset=utf8;

insert into t_video values (1,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');
insert into t_video values (2,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');
insert into t_video values (3,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');
insert into t_video values (4,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');
insert into t_video values (5,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');
insert into t_video values (6,'流浪地球2','郭帆','吴京、刘德华',173,'2023-01-22','内地','科幻灾难冒险电影',3,'lldq2.png','lldq2.mp4');

drop table if exists t_user;

create table t_user(
                        id int primary key auto_increment,
                        nick_name varchar(32),
                        account varchar(32),
                        password varchar(32)
)charset=utf8;

insert into t_admin values (1, "用户1", 'user', '123456');

drop table if exists t_history;

create table t_history(
                       id int primary key auto_increment,
                       video_id int,
                       video_name varchar(32),
                       user_id int,
                       user_name varchar(32),
                       watch_date date
)charset=utf8;

