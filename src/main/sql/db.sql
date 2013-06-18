drop database if exists cruddb;
create database cruddb;
GRANT ALL PRIVILEGES ON cruddb.* TO cruduser@localhost IDENTIFIED BY 'crud123';
FLUSH PRIVILEGES;
