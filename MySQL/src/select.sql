--1. 查询姓王的作者有多少
select count(*) from authors where author_name like '王%';
--2. 查询获奖作者总人数
select count(distinct(author_id)) from cups;
--3. 查询同时获得过金奖、银奖的作者姓名
select author_name from authors where author_id in(select DISTINCT a.author_id from cups a inner join cups b
where a.author_id=b.author_id and a.cup_type='金奖' and b.cup_type='银奖');
--4. 查询获得过金奖的图书有多少本，银奖的有多少本
select cup_type, count(*) from cups where cup_type in ('金奖', '银奖') group by cup_type;
--select count(*) from cups where cup_type = '金奖';
--select count(*) from cups where cup_type = '银奖';
--5. 查询最近一年内获过奖的作者姓名
select author_name from authors where author_id in(select distinct(author_id) from cups
where cup_time >= date_sub(now(), interval 1 year));
