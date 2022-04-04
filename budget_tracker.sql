drop database trackerdb;
drop user tracker;

create user tracker with password 'password';
create database trackerdb with template=template0 owner=tracker;
\connect trackerdb;
alter default privileges grant all on tables to tracker;
alter default privileges grant all on sequences to tracker;

create table bt_user {
user_id integer primary key not null,
first_name varchar(20) not null,
last_name varchar(20) not null,
email varchar(20) not null,
password text not null
};

create table bt_category {
category_id integer primary key not null,
user_id integer not null,
title varchar(50) not null,
description varchar(50) not null,
};

alter table bt_category add constrains cat_user_fk
foreign key (user_id) references bt_user(user_id);

create table bt_transactions(
transaction_id integer primary key not null,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(50) not null,
transaction_date bigint not null
);

alter table bt_transactions add constrains trans_cat_fk
foreign key category_id references bt_category(category_id);
alter table bt_transactions add constrains trans_user_fk
foreign key user_id references bt_user(user_id);

create sequence bt_user_seq increment 1 start 1;
create sequence bt_category increment 1 start 1;
create sequence bt_transactions increment 1 start 100;
