create table employee_info(
  id int unsigned not null auto_increment primary key,
  employee_id int unsigned not null unique,
  qtalk_id varchar(20) not null unique,
  employee_name varchar(20) not null default '',
  phone_number varchar(20) not null default '',
  work_place tinyint unsigned not null default 0,
  sex tinyint unsigned not null default 2,
  active boolean not null default true
);