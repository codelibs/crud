DROP TABLE IF EXISTS `crud_table` ;
create table crud_table(id bigint not null auto_increment, name varchar(20), value varchar(50), sort_order int, created_time timestamp, primary key(id));
