show databases;
create database school;
use school;
create table login(username varchar(25),password varchar(25));
insert into login values("Admin","12345");
select * from login;

show databases;
use school;
create table student (name varchar(40), fname varchar(40), rollno varchar(20), dob varchar(40), address varchar(100), phone varchar(40), email varchar(40), std varchar(40), branch varchar(40));
select * from student;
create table Teacher (name varchar(40), fname varchar(40), empID varchar(20), dob varchar(40), address varchar(100), phone varchar(40), email varchar(40), class_x varchar(20), class_xii varchar(20), course varchar(20), subject varchar(40));
select * from Teacher;
drop table Teacher;

create table subject(rollno varchar(20),std varchar(30),subject1 varchar(50),subject2 varchar(50),subject3 varchar(50),subject4 varchar(50),subject5 varchar(50));
select*from subject;
create table marks(rollno varchar(20),std varchar(30),marks1 varchar(50),marks2 varchar(50),marks3 varchar(50),marks4 varchar(50),marks5 varchar(50));
select*from marks;

create table studentleave(rollno varchar(20), dob varchar(50), duration varchar(20));
select * from studentleave;


create table teacherleave(empId varchar(30), date varchar(50), duration varchar(20));
select * from teacherleave;

# fee structure

create table fee(course varchar(20),std1 varchar(20), std2 varchar(20), std3 varchar(20), stdr4 varchar(20), std5 varchar(20), std6 varchar(20), std7 varchar(20), std8 varchar(20), std9 varchar(20), std10 varchar(20)); 

select * from teacher;