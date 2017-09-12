--1. 如何查看表的结构信息？
show create table books;
describe books;
--2. 联合索引中的字段顺序应该如何设计？
查询较为频繁的应该靠前，作为左前缀是有序的
--3. int(10)和varchar(10)两个字段的(10)有什么区别？
int是整数类型，占4个字节，加不加(10)是没有区别的
varchar是可变长字符串类型，varchar(10)代表存储长度最大为10
--4. 以下查询如何创建索引能够实现覆盖索引优化？（请给出具体SQL）
select invalid_time_flag from pushtoken_android_62 where uid = 'AC54E24E-FB73-3981-C4BC-CED8D69407F8' and pid = '10010';
create index idx_uid_pid_invalid_time_flag on pushtoken_android_62(uid,pid,invalid_time_flag);
select count(*) from pushtoken_android_62 where uid = 'AC54E24E-FB73-3981-C4BC-CED8D69407F8' and pid = '10010';
create index idx_uid_pid on pushtoken_android_62(uid,pid);