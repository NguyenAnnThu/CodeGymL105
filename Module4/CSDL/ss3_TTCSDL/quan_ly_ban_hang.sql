create database quan_ly_ban_hang;
use quan_ly_ban_hang;

create table customers(
	cID int auto_increment primary key,
    name varchar(25) ,
    cAge tinyint 
);

create table orders(
	oID int auto_increment primary key,
    cID int,
    oDate Datetime ,
    oTotalPrice int,
    foreign key (cID) references customers(cID)
);

create table products(
	pID int auto_increment primary key,
    pName varchar(25),
    pPrice int
);
create table orderDetail(
	oID int ,
    pID int,
    odQty int,
    primary key(oID,pID),
    foreign key (oID) references orders(oID),
    foreign key (pID) references products(pID)
);

insert into customers (name, cAge)
values 	("Minh Quan",10),
		("Ngoc Oanh",20),
        ("Hong Ha",50);
        
insert into orders (cID,oDate,oTotalPrice)
values	(1,"2006-3-21",null),
		(2,'2006-3-23',null),
        (1,'2006-3-16',null);

insert into products(pName,pPrice)
values	('May Giat',3),
		('Tu Lanh',5),
        ('Dieu Hoa',7),
        ('Quat',1),
        ('Bep Dien',2);
        
insert into orderDetail(oID,pID,odQty)
values	(1,1,3),
		(1,3,7),
        (1,4,2),
        (2,1,1),
        (3,1,8),
        (2,5,4),
        (2,3,3);
        
-- Hien thi tat ca
select * from customers;
select * from orders;
select * from products;
select * from orderDetail;

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
    Select oID, oDate,oTotalPrice 
    from orders;

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
	select c.*,p.pName as product_name
    from customers c
    join orders o on c.cID= o.cID
    join orderDetail od on o.oID=od.oID
    join products p on od.pID= p.pID;

-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
	select c.name
    from customers c
    left join orders o on c.cID= o.cID
    left join orderDetail od on o.oID= od.oID
    where od.oID is null;
    
/* Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng 
tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)*/
	select o.oID,o.oDate, sum(od.odQty * p.pPrice) as oTotalPrice
    from orders o
    join orderDetail od on o.oID= od.oID
    join products p on od.pID= p.pID
    group by o.oID, o.oDate;
    