create database test;
use test;
show variables like '%character%';
alter database test character set utf8;

create table books(
id int unsigned not null auto_increment primary key,
book_id varchar(20) not null,
author_id varchar(20) not null,
book_name varchar(50) not null,
pages int unsigned,
press varchar(50),
publication_date datetime,
price decimal(6, 2)
);

create table cups(
id int unsigned not null auto_increment primary key,
book_id varchar(20) not null,
author_id varchar(20) not null,
cup_type varchar(20) not null,
cup_time timestamp not null
);

create table authors(
id int unsigned not null auto_increment primary key,
author_id varchar(20) not null,
author_name varchar(50) not null,
content varchar(255)
);