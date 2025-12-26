create database sale_customer;
use sale_customer;

create table Customer(
	cID int primary key,
    cName varchar(50) not null,
    cAge int not  null
);
create table Sell(
	oID int primary key,
    cID int not null,
    oDate datetime default current_timestamp,
    oTotalPrice decimal (15,2) not null,
    constraint fk_customer foreign key (cID) references Customer(cID)
);

create table Product(
	pID int primary key,
    pName varchar(50) not null,
    pPrice float not null
);
create table OrderDetail(
	oID int,
    pID int,
    odQty int not null,
    constraint fk_sell foreign key (oID) references Sell(oID),
    constraint fk_product foreign key (pID) references Product(pID),
    primary key(oID,pID)
);
INSERT INTO Customer(cID, cName, cAge)
VALUES
	(1, 'Nguyen Van A', 25),
	(2, 'Tran Thi B', 30),
	(3, 'Le Van C', 22);
INSERT INTO Product(pID, pName, pPrice)
VALUES
	(101, 'Laptop', 1500.00),
	(102, 'Chuột', 20.00),
	(103, 'Bàn phím', 50.00),
	(104, 'Màn hình', 300.00);
INSERT INTO Sell(oID, cID, oDate, oTotalPrice)
VALUES
	(1001, 1, '2025-12-26 10:00:00', 1570.00),
	(1002, 2, '2025-12-26 11:30:00', 1520.00),
	(1003, 1, '2025-12-26 15:45:00', 350.00);
INSERT INTO OrderDetail(oID, pID, odQty)
VALUES
	(1001, 101, 1), 
	(1001, 102, 2),  
	(1001, 103, 1),  

	(1002, 101, 1),  
	(1002, 104, 1),  

	(1003, 104, 1);  
