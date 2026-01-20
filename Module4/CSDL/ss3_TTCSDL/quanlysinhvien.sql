create database quanlysinhvien;
use quanlysinhvien;

create table class(
	classID int not null auto_increment primary key ,
    className varchar (60) not null,
    startDate datetime not null,
    status bit
);

create table students (
	stuID int not null auto_increment primary key,
    stuName varchar(30) not null,
    address varchar(50),
    status bit,
    phone varchar(20),
    classID int not null,
    foreign key (classID) references class(classID)
);

create table subjects(
	subID int not null auto_increment primary key,
    subName varchar(30) not null,
    credit tinyint not null default  1 check ( credit >=1),
    status bit default 1
);

create table mark(
	markID int not null auto_increment primary key,
    subID int not null,
    StuID int not null,
    mark float default 0 check( mark between 0  and 100),
    examTimes tinyint default 1,
    unique (subID, stuID),
    foreign key (subID) references subjects (subID),
    foreign key (stuID) references students (stuID)
);


insert into class (className, startDate, status)
values 	("A1","2008-12-20",1),
		("A2","2008-12-22",1),
        ("B3",current_date() ,0);
        
insert into students (stuName,address, status, phone, classID)
values	("Hung","Ha Noi", 1,"0912113113",1),
		("Hoa", "Hai Phong", 1, null,1),
        ("Manh", "HCM", 1,"0123746838",2);
insert into subjects (subName, credit, status)
values	("CF",5,1),
		("C",6,1),
        ("HDJ",5,1),
        ("RDBMS",10,1);

insert into mark(subID, stuID,mark,examTimes)
values	(1,1,8,1),
		(1,2,10,2),
        (2,1,12,1);
        
   select * from students
   where address="HCM";

insert into students (stuName,address, status, phone, classID)
values	("Hung","Ha Noi", 0,"0912113113",1);
update students 
set phone=null
where stuID=4;
#--Hiển thị danh sách tất cả học viên--
select * from students;

# Hiển thị danh sách các học viên đang theo học

	select* from students
	where status=true;

# Hiển thị danh sách các môn học có thời gian học nhỏ hơn 10 giờ

	select * from subjects where credit <10;

# Hiển thị danh sách học viên lớp A1

	select s.stuID, s.stuName, c.className 
	from students s join class c on s.classID= c.classID
	where c.className ="A1";

# Hiển thị điểm môn CF của các học viên

	select s.stuID, s.stuName, sub.subName, m.mark
    from mark m join students s on m.stuID= s.stuID
				join subjects sub on m.subID= sub.subID
    where sub.subName ="CF";
    
# Hiển thị tất cả các sinh viên có tên bắt đầu bằng ký tự "h"

	select * from students
    where stuName like "h%" or "H%";
    
# Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12

	select * from class
    where month(startDate) =12;
    
# Hiển thị các thông tin môn học có credit trong khoảng từ 3-5

	select * from subjects
    where credit between 3 and 5;