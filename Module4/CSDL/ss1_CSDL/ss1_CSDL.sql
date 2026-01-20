Create database  School;
use School;
create table Student(
id int primary key,
name varchar(50)
);
create table teacher(
id int primary key,
name varchar(50),
age int,
country varchar(50)
);
insert into Student values(1,"Nguyen Tri Truong");
insert into teacher values(1,"Truong Tan Hai",30,"Quang Ngai");
select * from Student;
select * from teacher;