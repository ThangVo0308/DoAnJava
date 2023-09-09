create database QLDienthoai

use QLDienthoai
go

create table Tai_khoan(
	So_TK int primary key not null,
	Ten_TK nvarchar(50),
	Mat_khau varchar(50),
	SDT varchar(11),
	Ngay_tao DATE,
	check_exist bit,
);
go


create table Loai_DT(
	Ma_Loai varchar(10) primary key not null,
	Ten_Loai varchar(100),
	Mo_ta varchar(1000),
	check_exist bit
);
go

create table Khach_hang(
	Ma_KH varchar(10) primary key not null,
	Ten_KH nvarchar(100),
	Dia_chi varchar(100),
	SDT varchar(11),
	check_exist bit
);
go

create table Phieu_BH(
	Ma_BH varchar(10) not null primary key,
	Ten_CH nvarchar(100),
	Dia_chi varchar(100),
	Ngay_Ban_Hang date,
	TG_Baohanh nvarchar(100),
	Ngay_Het_Han date,
	check_exist bit
);
go

create table Chuc_vu(
	Ma_CV varchar(10) not null primary key,
	Ten_CV nvarchar(50),
	MO_TA nvarchar(1000),
	check_exist bit
);
go

create table Dien_thoai(
	Ma_DT varchar(10) NOT NULL PRIMARY KEY,
	Ten_loai varchar(10),
	Ma_BH varchar(10),
	Tinh_nang nvarchar(1000),
	Ten_DT varchar(100),
	SL int,
	Gia_tien int,
	img varchar(1000),
	IS_DELETED bit,
	foreign key(Ma_BH) references Phieu_BH(Ma_BH),
);
go

create table Nha_SX(
	Ma_NSX varchar(10) not null primary key,
	Ten_NSX nvarchar(100),
	Dia_chi varchar (100),
	SDT varchar(11),
	email varchar(100),
	check_exist bit
);
go

create table Nha_PP(
	Ma_NPP varchar(10) not null primary key,
	Ten_NPP nvarchar(100),
	Dia_chi varchar (100),
	SDT varchar(11),
	email varchar(100),
	check_exist bit
);
go

create table Nhan_Vien(
	Ma_NV varchar(10) not null primary key,
	Ten_NV nvarchar(100),
	Dia_chi varchar(100),
	SDT varchar(11),
	Gioi_tinh bit,
	Ngay_sinh date,
	So_CMND varchar(15),
	Ma_CV varchar(10),
	foreign key(Ma_CV) references Chuc_vu(Ma_CV),
	check_exist bit
);
go

create table Hoa_don(
	Ma_HD varchar(10) not null primary key,
	Ngaylap_HD date,
	Tong_tien int,
	Ma_KH varchar(10),
	Ma_NV varchar(10),
	Ma_DT varchar(10),
	check_exist bit,
	foreign key(Ma_KH) references Khach_hang(Ma_KH),
	foreign key(Ma_NV) references Nhan_vien(Ma_NV),
	foreign key(Ma_DT) references Dien_thoai(Ma_DT),
);
go


create table CT_Hoadon(
	Ma_HD varchar(10) not null,
	Ma_DT varchar(10) not null,
	primary key(Ma_HD,Ma_DT),
	SL int,
	Gia float,
	check_exist bit
);
go

create table Phieu_nhap(
	Ma_PN varchar(10) not null primary key,
	Ngay_nhap date,
	Tong_gia int,
	Ma_NPP varchar(10),
	foreign key (Ma_NPP) references Nha_PP(Ma_NPP),
	check_exist bit,
);
go

create table CT_Phieunhap(
	Ma_PN varchar(10) not null,
	Ma_DT varchar(10) not null,
	primary key(Ma_PN,Ma_DT),
	SL int,
	Gia float,
	check_exist bit
);
go

create table Phieu_chi(
	Ma_PC varchar(10) not null,
	Ma_PN varchar(10) not null,
	Ma_NV varchar(10),
	foreign key (Ma_NV) references Nhan_Vien(Ma_NV),
	primary key (Ma_PC,Ma_PN),
	Ngay_chi date,
	Tong_gia float,
	check_exist bit
);
go

create table Cua_hang(
	Ma_CH varchar(10) not null primary key,
	Ten_CH nvarchar(100),
	Dia_chi varchar(100),
	SDT varchar(11),
	check_exist bit
);
go


INSERT INTO Tai_khoan(So_TK,Ten_TK,Mat_khau,SDT,Ngay_tao,check_exist)
VALUES 
(1,'Admin','123123','099999999',GETDATE(),1),
(2,'hahaha','123123','099999999',GETDATE(),1),
(3,'banhang1','123123','099999999',GETDATE(),1);

INSERT INTO Cua_hang(Ma_CH,Ten_CH,Dia_chi,SDT,check_exist) 
VALUES 
('CH01','HANDPHONE','Quan 5, HCM','0909090909',1);

INSERT INTO Dien_thoai(Ma_DT,Ten_loai,Ma_BH,Tinh_nang,Ten_DT,SL,Gia_tien,img,IS_DELETED)
VALUES 
('DT01','Apple','BH01','Iphone 11 rat xin xo','Iphone 11 pro max',200,20000000,'./src/img/XiaomiRedmiNote11.jpg',1),
('DT02','Samsung','BH02','Samsung galaxy A7 rat xin xo','Samsung galaxy S23 Ultra',200,5000000,'./src/img/XiaomiRedmiNote11.jpg',1),
('DT03','Xiaomi','BH03','Redmi note 11s pro rat xin xo','Redmi note 11',200,12000000,'./src/img/XiaomiRedmiNote11.jpg',1);


INSERT INTO Chuc_vu(Ma_CV,Ten_CV,MO_TA,check_exist) 
VALUES 
('CV01','Nhan vien ban hang','Thuc hien cong viec ban hang',1),
('CV02','Nhân viên tu van','Thực hien cong viec tu van cho khach hang',1),
('CV03','Nhan vien quan ly','Thuc hien cong viec quan ly nhan vien, cua hang',1);

INSERT INTO Nhan_Vien(Ma_NV,Ten_NV, Ma_CV, Dia_Chi, SDT, Gioi_tinh, Ngay_sinh, So_CMND,check_exist) 
VALUES 
('NV01','Huynh Van Teo','CV01', 'Quan 5, HCM', '0214745962', 1, '2003-01-06', '3121410465',1),
('NV02','Ho Quoc Cuong','CV02', 'Quan 5, HCM', '0214745962', 0, '2003-01-06', '3121410466',1),
('NV03','Vo Chung Thang','CV03', 'Quan 5, HCM', '0214745962', 1, '2003-01-06', '3121410467',1),
('NV04','Pham Hoang Anh Tuan','CV01', 'Quan 5, HCM', '0214745962', 0, '2003-01-06', '3121410468',1),
('NV05','Nguyen Hoang Duy','CV02', 'Quan 5, HCM', '0214745962', 1, '2003-01-06', '3121410469',1);

INSERT INTO Khach_hang(Ma_KH,Ten_KH,Dia_chi,SDT,check_exist)
VALUES 
('KH01','Huynh Van Teo', 'Quan 5, HCM', '0214745962',1),
('KH02','Nguyen Van Bay', 'Quan 12, HCM', '0214745872',1),
('KH03','Nguyen Van Banh', 'Quan 6, HCM', '0214745621',1);

INSERT INTO Nha_PP(Ma_NPP,Ten_NPP,Dia_chi,SDT,email,check_exist)
VALUES 
('NPP01','Gearvn', 'Quan 5, HCM', '0988732132','gearvn@gmail.com',1),
('NPP02','The gioi di dong', 'Quan 8, HCM', '0856648843','thegioididong@gmail.com',1),
('NPP03','Cellphones', 'Quan 6, HCM', '04897821486', 'cellphones@gmail.com',1);

INSERT INTO Nha_SX(Ma_NSX,Ten_NSX,Dia_chi,SDT,email,check_exist)
VALUES 
('NSX01','Apple', 'USA', '01111111111','apple@gmail.com',1),
('NSX02','Samsung', 'Korea', '0222222222','samsung@gmail.com',1),
('NSX03','Xiaomi', 'China', '0333333333', 'xiaomi@gmail.com',1),
('NSX04','Oppo', 'China', '0444444444', 'oppo@gmail.com',1),
('NSX05','Vertu', 'England', '0333333333', 'vertu@gmail.com',1);

INSERT INTO Loai_DT(Ma_Loai,Ten_Loai,Mo_Ta,check_exist) 
VALUES 
('LDT01','Apple','Cac san pham cua dien thoai Apple rat xin',1),
('LDT02','Samsung','Cac san pham cua dien thoai Samsung rat xin',1),
('LDT03','Xiaomi','Cac san pham cua dien thoai Xiaomi rat xin',1),
('LDT04','Oppo','Cac san pham cua dien thoai Oppo rat xin',1),
('LDT05','Vertu','Cac san pham cua dien thoai Vertu rat xin',1);


INSERT INTO Phieu_nhap(Ma_PN,Ngay_nhap,Tong_gia,Ma_NPP,check_exist)
VALUES 
('PN01',GETDATE(),250000000,'NPP01',1),
('PN02',GETDATE(),300000000,'NPP02',1),
('PN03',GETDATE(),400000000,'NPP03',1);

INSERT INTO Hoa_don(Ma_HD,Ngaylap_HD,Tong_tien,Ma_KH,Ma_NV,Ma_DT,check_exist)
VALUES 
('HD01',GETDATE(),5000000,'KH01','NV03','DT01',1),
('HD02',GETDATE(),11000000,'KH02','NV02','DT02',1),
('HD03',GETDATE(),22000000,'KH03','NV01','DT03',1);

INSERT INTO Phieu_BH(Ma_BH,Ten_CH,Dia_chi,Ngay_Ban_Hang,TG_Baohanh,Ngay_Het_Han,check_exist) 
VALUES 
('BH01','HANDPHONE','An Duong Vuong,Quan 5',GETDATE(),'3 thang', CONVERT(date, DATEADD(month, 3, GETDATE()), 103),1), -- 103: dinh dang ngay thang nam kieu dd/mm/yyyy
('BH02','HANDPHONE','An Duong Vuong,Quan 5',GETDATE(),'6 thang', CONVERT(date, DATEADD(month, 6, GETDATE()), 103),1),
('BH03','HANDPHONE','An Duong Vuong,Quan 5',GETDATE(),'12 thang', CONVERT(date, DATEADD(month, 12, GETDATE()), 103),1);

INSERT INTO CT_Phieunhap(Ma_PN,Ma_DT,SL,Gia,check_exist)
VALUES 
('PN01','DT01',200,1250000,1),
('PN02','DT02',200,1500000,1),
('PN03','DT03',200,2000000,1);

INSERT INTO Phieu_chi(Ma_PC,Ma_PN,Ma_NV,Ngay_chi,Tong_gia,check_exist)
VALUES 
('PC01','PN01','NV01',GETDATE(),250000000,1),
('PC02','PN02','NV02',GETDATE(),300000000,1),
('PC03','PN03','NV02',GETDATE(),400000000,1);

INSERT INTO CT_Hoadon(Ma_HD,Ma_DT,SL,Gia,check_exist)
VALUES 
('HD01','DT01',1,20000000,1),
('HD02','DT01',1,30000000,1),
('HD03','DT02',1,40000000,1);



