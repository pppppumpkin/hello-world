--考虑到平时提供图书和作者的查找功能，建立索引：
alter table authors add unique index uniq_author_id(author_id);
alter table books add unique index uniq_bood_id(book_id);
alter table authors add index idx_author_name(author_name);
alter table books add index idx_book_name(book_name);
--针对获奖情况提供的相关查找，建立索引：
alter table cups add index idx_cup_type_author_id(cup_type, author_id);
alter table authors add index idx_author_id_author_name(author_id, author_name);
alter table cups add index idx_cup_type_book_id(cup_type, book_id);
alter table cups add index idx_cup_time_author_id(cup_time, author_id);
