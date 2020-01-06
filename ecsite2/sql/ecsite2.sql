set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite2;

create database if not exists ecsite2;
use ecsite2;

create table login_user(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
status tinyint(1),
insert_date datetime,
updated_date datetime
);

create table item_info(
id int not null primary key auto_increment,
item_name varchar(30),
item_price int,
item_stock int,
image varchar(100),
release_date varchar(16),
release_company varchar(30),
insert_date datetime,
update_date datetime
);

create table user_info(
id int not null primary key auto_increment,
item_transaction_id int not null,
foreign key(item_transaction_id) references item_info(id),
user_master_id int not null,
foreign key(user_master_id) references login_user(id),
user_id varchar(16),
item_name varchar(16),
total_count int,
item_price int,
size varchar(1),
payment varchar(16),
total_price int,
first_name varchar(16),
last_name varchar(16),
mail varchar(32),
phone_num varchar(16),
user_address varchar(30),
image varchar(100),
deleted tinyint default 0,
insert_date datetime,
delete_date datetime
);

create table cart_info(
id int not null primary key auto_increment,
user_id varchar(16),
item_name varchar(30),
item_price int,
item_count int,
total_price int,
image varchar(100),
size varchar(1),
insert_date datetime,
update_date datetime
);

create table user_address_info(
id int not null primary key auto_increment,
user_id varchar(16),
first_name varchar(16),
last_name varchar(16),
mail varchar(32),
phone_num varchar(16),
user_address varchar(30),
insert_date datetime
);

INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("komono",2500,50,"./image/t1.jpg","12/12/2019","KAI OSHIMA");
INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("apple,banana,DVD",3000,50,"./image/t2.jpg","12/12/2019","KAI OSHIMA");
INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("sampler",1500,50,"./image/t3.jpg","12/12/2019","KAI OSHIMA");
INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("blue",1000,50,"./image/t4.jpg","12/12/2019","KAI OSHIMA");
INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("tetsuori",2000,50,"./image/t5.jpg","12/12/2019","KAI OSHIMA");
INSERT INTO item_info(item_name,item_price,item_stock,image,release_date,release_company)VALUES("hondana",1700,50,"./image/t6.jpg","12/12/2019","KAI OSHIMA");

INSERT INTO login_user(login_id,login_pass,user_name,status)VALUES("kai","kai","kai",1);
INSERT into login_user(login_id,login_pass,user_name,status)VALUES("guest","guest","guest",1);
