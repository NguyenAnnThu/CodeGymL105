create database sales_inventory;
use sales_inventory;

create table PhieuXuat(
	SoPX char(6) primary key ,
    NgayXuat datetime default current_timestamp
);

create table VatTu(
	MaVTu char(6) primary key,
    TenVTu varchar(30) not null
);
create table CT_XVT(
	SoPX char(6),
    MaVTu char(6),
    SLXuat int not null,
    DGXuat decimal(15,2) not null,
    constraint fk_PhieuXuat foreign key (SoPX) references PhieuXuat (SoPX),
    constraint fk_VatTu foreign key (MaVTu) references VatTu(MaVTu),
    primary key(SoPX,MaVTu)
);

create table PhieuNhap(
	SoPN char(6) primary key,
    NgayNhap datetime default current_timestamp
);

create table CT_PhieuNhap(
	SoPN char(6),
    MaVTu char(6),
    DGNhap decimal(15,2) not null,
    SLNhap int not null,
    constraint fk_PhieuNhap foreign key(SoPN) references PhieuNhap(SoPN),
    constraint fk_NVatTu foreign key(MaVTu) references VatTu(MaVTu),
    primary key(SoPN, MaVTu)
);

create table NhaCC(
	MaNCC char(6) primary key,
    TenNCC varchar(50) not null,
    DiaChi varchar(50) default ' ',
    SDT  char(10) not null
);
create table DonDH(
	SoDH char(6) primary key,
    NgayDH datetime default current_timestamp,
    MaNCC char(6),
    foreign key (MaNCC) references NhaCC(MaNCC)
    
);
 create table CT_DH(
	SoDH char(6),
    MaVTu char(6),
    constraint fk_DH foreign key (SoDH) references DonDH(SoDH),
    constraint fk_DVatTu foreign key (MaVTu) references VatTu(MaVTu),
    primary key(SoDH, MaVTu)
 );

insert into PhieuXuat (SoPX, NgayXuat)
values	('PX0001','2025-10-08'),
		('PX0002','2025-10-09'),
        ('PX0003', '2025-10-08');
INSERT INTO VatTu(MaVTu, TenVTu)
VALUES
		('VT01','Vật tư A'),
		('VT02','Vật tư B'),
		('VT03','Vật tư C'),
		('VT04','Vật tư D');
INSERT INTO NhaCC(MaNCC, TenNCC, DiaChi, SDT)
VALUES
		('NCC01','Công ty ABC','Hà Nội','0123456789'),
		('NCC02','Công ty XYZ','HCM','0987654321');
INSERT INTO CT_XVT(SoPX, MaVTu, SLXuat, DGXuat)
VALUES
		('PX0001','VT01',10,5000),
		('PX0001','VT02',5,7000),
		('PX0002','VT01',8,5200),
		('PX0003','VT03',3,4500);
INSERT INTO PhieuNhap(SoPN, NgayNhap)
VALUES
		('PN001', CURDATE()),
		('PN002', CURDATE());
INSERT INTO CT_PhieuNhap(SoPN, MaVTu, SLNhap, DGNhap)
VALUES
		('PN001','VT01',20,4500),
		('PN001','VT02',10,6800),
		('PN002','VT01',15,5000),
		('PN002','VT03',5,4700);
INSERT INTO DonDH(SoDH, NgayDH, MaNCC)
VALUES
		('DH001', CURDATE(), 'NCC01'),
		('DH002', CURDATE(), 'NCC02');
INSERT INTO CT_DH(SoDH, MaVTu)
VALUES
		('DH001','VT01'),
		('DH001','VT02'),
		('DH002','VT01'),
		('DH002','VT03');

select * from PhieuXuat;
select * from VatTu;
select * from CT_XVT;