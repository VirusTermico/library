CREATE TABLE member(
id int auto_increment primary key,
name varchar(255) not null,
email varchar(255) not null unique,
mobile varchar(255) not null unique);