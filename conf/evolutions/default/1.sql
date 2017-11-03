# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tbl_users (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  password                  varchar(255),
  name                      varchar(255),
  created_on                datetime,
  constraint pk_tbl_users primary key (id))
;

create table tbl_users_test (
  id                        bigint auto_increment not null,
  username                  varchar(255),
  name                      varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_tbl_users_test primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table tbl_users;

drop table tbl_users_test;

SET FOREIGN_KEY_CHECKS=1;

