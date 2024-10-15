create database QuanLyPhongKham
use quanlyphongkham

use master
drop database QuanLyPhongKham

create table BenhNhan(
	MaBN nvarchar(5) primary key,
	Hoten nvarchar(50) not null,
	ngaysinh date not null,
	Gioitinh nvarchar(5) not null,
	Diachi nvarchar(50) not null,
	Baohiem	bit,
	sdt nvarchar(10) not null
)
--drop table benhnhan

create table BacSi(
	MaBS nvarchar(5) primary key,
	TenBS nvarchar(50) not null,
	Chuyennganh	nvarchar(50) not null,
	NgaySinh date not null,
	GhiChu nvarchar(50) not null,
	SDT nvarchar(10) not null,
	GioiTinh nvarchar(5) 
)
--drop table bacsi

create table Thuoc(
	MaThuoc nvarchar(5) primary key,
	Tenthuoc nvarchar(50) not null,
	HDS date,
	DonVi nvarchar(10),
	GiaTien float
)

create table DonThuoc(
	MaDT nvarchar(5) primary key,
	MaBS nvarchar(5) not null,
	MaThuoc nvarchar(5) not null,
	Lieudung nvarchar(5)
)
--drop table donthuoc


create table PhieuKham(
	MaPhieuKham varchar(5) primary key,
	MaDT nvarchar(5)  not null,
	MaBS nvarchar(5)  not null,
	MaBN nvarchar(5)  not null,
	ThanhTien nvarchar(10)  not null,
	NgayKham Date not null,
	MotaBenh nvarchar(200) not null
)
--drop table hoadon

create table Chitiet_DonThuoc_Thuoc(
 MaThuoc nvarchar(5) not null,
 MaDT nvarchar(5)
 primary key(MaThuoc,MaDT)
 )

 alter table Chitiet_DonThuoc_Thuoc add constraint ct_Dt_T
 foreign key (MaDT) references DonThuoc(MaDT)

 alter table Chitiet_DonThuoc_Thuoc add constraint ct_Dt_T2
 foreign key (MaThuoc) references Thuoc(MaThuoc)
 
alter table donthuoc add constraint dthuoc_bsi_FK 
foreign key (mabs) references bacsi(mabs)


alter table phieukham add constraint PhieuKham_Bsi_FK
foreign key (mabs) references bacsi(mabs)

alter table phieukham add constraint PhieuKham_Bnhan_FK
foreign key (mabn) references benhnhan(mabn)

alter table phieukham add constraint PhieuKham_DThuoc_FK
foreign key (madt) references donthuoc(madt)

create table Account( 
 UserName nvarchar(50) not null,
 Password nvarchar(50) not null,
 vaitro bit )

 alter table DonThuoc drop column MaThuoc
 select * from BenhNhan
 select * from BacSi
 select * from DonThuoc
 select * from Chitiet_DonThuoc_Thuoc
 select * from Thuoc

 create proc tienphieukham @mapk nvarchar(5)
 as begin 
 select sum(Thuoc.GiaTien) from Thuoc,DonThuoc,Chitiet_DonThuoc_Thuoc,PhieuKham where 
                          Thuoc.MaThuoc=Chitiet_DonThuoc_Thuoc.MaThuoc and
						  Chitiet_DonThuoc_Thuoc.MaDT=DonThuoc.MaDT and
						  PhieuKham.MaDT=DonThuoc.MaDT and PhieuKham.MaPhieuKham='PK01'
end


alter table Thuoc
alter column GiaTien float


CREATE PROCEDURE sp_LoadTableThuoc
    @madt NVARCHAR(5)  -- Tham số đầu vào
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        Thuoc.MaThuoc,
        Thuoc.Tenthuoc,
        Thuoc.DonVi,
		Thuoc.HDS
    FROM 
        Thuoc
    JOIN 
        Chitiet_DonThuoc_Thuoc ON Chitiet_DonThuoc_Thuoc.MaThuoc = Thuoc.MaThuoc
    JOIN 
        DonThuoc ON Chitiet_DonThuoc_Thuoc.MaDT = DonThuoc.MaDT
    WHERE 
        DonThuoc.MaDT = @madt;  -- Lọc theo mã đơn thuốc
END

DROP PROCEDURE IF EXISTS sp_LoadTableThuoc;


CREATE PROCEDURE sp_benhnhan
    @maphieukham NVARCHAR(5)  -- Tham số đầu vào
AS
BEGIN
    SET NOCOUNT ON;

    SELECT 
        BenhNhan.Hoten,
        BenhNhan.Ngaysinh,
        BenhNhan.Gioitinh,
        BenhNhan.SDT,
        BenhNhan.MaBN,
        PhieuKham.MaPhieuKham,
        DonThuoc.MaDT,
        PhieuKham.MaBS,
        PhieuKham.MotaBenh,
        PhieuKham.NgayKham,
        PhieuKham.ThanhTien
    FROM 
        BenhNhan
    JOIN 
        PhieuKham ON BenhNhan.MaBN = PhieuKham.MaBN
    JOIN 
        DonThuoc ON PhieuKham.MaDT = DonThuoc.MaDT
    WHERE 
        PhieuKham.MaPhieuKham = @maphieukham;  -- Lọc theo mã phiếu khám
END


CREATE PROCEDURE sp_DoanhThu
    @nam INT
AS
BEGIN
    SET NOCOUNT ON;

    -- Các biến lưu trữ kết quả
    DECLARE @TongSoPhieuKham INT,
            @TongSoBenhNhan INT,
            @DoanhThu DECIMAL(18, 2),
            @DoanhThuThap DECIMAL(18, 2),
            @DoanhThuCao DECIMAL(18, 2),
            @DoanhThuTrungBinh DECIMAL(18, 2);

    -- Tính tổng số phiếu khám
    SELECT @TongSoPhieuKham = COUNT(*)
    FROM PhieuKham
    WHERE YEAR(NgayKham) = @nam;

    -- Tính tổng số bệnh nhân
    SELECT @TongSoBenhNhan = COUNT(DISTINCT MaBN)
    FROM PhieuKham
    WHERE YEAR(NgayKham) = @nam;

    -- Tính tổng doanh thu
    SELECT @DoanhThu = SUM(CAST(ThanhTien AS DECIMAL(18, 2)))
    FROM PhieuKham
    WHERE YEAR(NgayKham) = @nam;

    -- Tính doanh thu thấp, cao và trung bình
    SELECT @DoanhThuThap = MIN(CAST(ThanhTien AS DECIMAL(18, 2))),
           @DoanhThuCao = MAX(CAST(ThanhTien AS DECIMAL(18, 2))),
           @DoanhThuTrungBinh = AVG(CAST(ThanhTien AS DECIMAL(18, 2)))
    FROM PhieuKham
    WHERE YEAR(NgayKham) = @nam;

    -- Trả về kết quả
    SELECT @TongSoPhieuKham AS [Tổng số phiếu khám],
           @TongSoBenhNhan AS [Tổng số bệnh nhân],
           @DoanhThu AS [Doanh thu],
           @DoanhThuThap AS [Doanh thu thấp],
           @DoanhThuCao AS [Doanh thu cao],
           @DoanhThuTrungBinh AS [Doanh thu trung bình];
END;
