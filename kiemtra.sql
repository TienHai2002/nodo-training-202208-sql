    create table HAINT_NXB(
      id  number(3) not null constraint PK_HAINT_NXB PRIMARY KEY ,
      ma_nxb number(3) not null unique ,
      ten_nxb nvarchar2(50),
      trangThai_nxb number(1,0),
      diaChi_nxb nvarchar2(50),
      moTa_nxb nvarchar2(50)
    );
create table HAINT_TG(
id number(3) not null constraint PK_HAINT_TG primary key ,
ma_tg number(3) not null unique ,
ten_tg nvarchar2(50),
SDT_tg varchar(50),
diaChi_tg nvarchar2(50),
moTa_tg nvarchar2(50)
);
create table HAINT_SACH(
  id number(3) not null constraint PK_HAINT_SACH primary key ,
ma_sach number(3) not null unique ,
ten_sach nvarchar2(50),
id_nxb number(3) not null ,
id_tg number(3) not null ,
chuDe_sach nvarchar2(50),
namXB_sach nvarchar2(50),
moTa_sach nvarchar2(50),
soLuongConLai_sach varchar(50),
soLuongDangMuon_sach varchar(50),
tongSoSach varchar(50),

constraint "fk_nxb" foreign key (id_nxb) references "HAINT_NXB"(id),
constraint "fk_tg" foreign key (id_tg) references "HAINT_TG"(id)

);
DROP TABLE  HAINT_NXB;
    DROP TABLE  HAINT_TG;
    DROP TABLE  HAINT_SACH;
drop table HAINT_BANDOC;
    DROP TABLE  HAINT_MUONSACH;
create table HAINT_BanDoc(
    id number(3) not null constraint PK_HAINT_BanDoc primary key ,
    ma_bandoc number(3) not null unique ,
    ten_bandoc nvarchar2(50) ,
    SDT_bandoc varchar2(50),
    diaChi_bandoc nvarchar2(50),
    ngaySinh_bandoc  date,
    ngayTaoTK_bandoc date,
    hang_bandoc varchar(50)
);

create table HAINT_MuonSach(
    id number(3) not null constraint PK_HAINT_MuonSach primary key ,
    id_bandoc number(3) not null ,
    id_sach number(3) not null ,
    soLuong number,
    ngaygiomuon date,
    ngaygiotra date,
    trangthai number(1,0),
    ghichu nvarchar2(50),
        constraint "fk_bandoc" foreign key (id_bandoc) references "HAINT_BANDOC"(id),
    constraint "fk_sach" foreign key (id_sach) references "HAINT_SACH"(id)

)
--     1.	Viết script tạo cấu trúc các bảng. Đối với bảng Mượn Sách cần đánh partition trên trường ngày giờ mượn, và 2 local index: 1 index trên trường id bạn đọc, 1 index trên id sách. Tên indexes theo cấu trúc : TENBANG_IDX_TENTRUONG
    PARTITION BY RANGE(ngaygiomuon)
    (
    PARTITION NGAYGIOMUON_2020 VALUES LESS THAN(TO_DATE('30/12/2021','DD/MM/YYYY')),
    PARTITION NGAYGIOMUON_2021 VALUES LESS THAN(TO_DATE('30/12/2022','DD/MM/YYYY')),
    PARTITION NGAYGIOMUON_2022 VALUES LESS THAN(TO_DATE('30/12/2023','DD/MM/YYYY'))
    );
     --INDEX
    CREATE INDEX HAINT_BANDOC_IDX_IDBANDOC
        ON HAINT_BANDOC(ID);

    CREATE INDEX HAINT_SACH_IDX_IDSACH
        ON HAINT_SACH(ID);

--cau 2 2.	Viết script tạo sequence cho mỗi bảng. Sequence được dùng để insert trường Id cho các bảng. Tên sequence theo cấu trúc : TENBANG_SEQ
    CREATE SEQUENCE HAINT_NHAXUATBAN_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 10000
        NOCYCLE;
    CREATE SEQUENCE HAINT_TACGIA_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 10000
        NOCYCLE;
    CREATE SEQUENCE HAINT_SACH_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 10000
        NOCYCLE;
    CREATE SEQUENCE HAINT_BANDOC_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 10000
        NOCYCLE;
    CREATE SEQUENCE HAINT_MUONSACH_sequence
        INCREMENT BY 1
        START WITH 1
        MAXVALUE 10000
        NOCYCLE;

  --  4.	Viết script insert dữ liệu mẫu cho tất cả các bảng.

INSERT INTO HAINT_NXB VALUES ('001','001','HAI','1','HA NOI','ABC');
INSERT INTO HAINT_NXB VALUES ('002','002','HA','0','HA NOI','ABCd');
    INSERT INTO HAINT_NXB VALUES ('003','003','HA123','0','HA NOI','ABCe');
    INSERT INTO HAINT_NXB VALUES ('004','004','HA321','0','HA NOI','ABCf');
    INSERT INTO HAINT_NXB VALUES ('005','005','HA213','0','HA NOI','ABCg');

    INSERT INTO HAINT_TG VALUES ('001','001','HAI','113','HA NOI','ABC');
    INSERT INTO HAINT_TG VALUES ('002','002','HA','114','HA NOI','ABC');
    INSERT INTO HAINT_TG(id, ma_tg, ten_tg, SDT_tg, diaChi_tg, moTa_tg)
    VALUES ('003','003','HA12s3','112314','HA N1OI','ABC1231');
    INSERT INTO HAINT_TG VALUES ('004','004','HA32111','115','HA N1O1I','test');
    INSERT INTO HAINT_TG VALUES ('005','005','HA21311','115','HA N1O1I','test1');

    INSERT INTO HAINT_SACH VALUES ('001','001','VIP','001','001','TRUYEN TRANH','2021','ABC','100','1','101');
    INSERT INTO HAINT_SACH(id, ma_sach, ten_sach, id_nxb, id_tg, chuDe_sach, namXB_sach, moTa_sach, soLuongConLai_sach, soLuongDangMuon_sach, tongSoSach)
    VALUES ('002','002','Sach1','002','002','TRUYEN TRANH','2021','TRUYEN','1000','1','1001');
    INSERT INTO HAINT_SACH VALUES ('003','003','VIP1','001','001','TRUYEN 1TRANH','2022','ABC13','1001','11','1011');
    INSERT INTO HAINT_SACH VALUES ('004','004','VIP2','002','002','TRUYEN1 TRANH','2020','ABC','100','1','101');





    INSERT INTO HAINT_BANDOC VALUES ('002','002','HA','114','HA NOI','12-JAN-2002','12-JAN-2002','KIM CUONG');
    INSERT INTO HAINT_BANDOC(id, ma_bandoc, ten_bandoc, SDT_bandoc, diaChi_bandoc, ngaySinh_bandoc, ngayTaoTK_bandoc, hang_bandoc)
    VALUES ('003','003','HAiprodeptraisieucap','114','HA NOI','12-JAN-2002','12-JAN-2002','KIM CUONG');
    INSERT INTO HAINT_BANDOC VALUES ('004','001','HA','114','HA NOI','12-JAN-2002','12-JAN-2002','AB CUONG');
    INSERT INTO HAINT_BANDOC VALUES ('005','005','HA','114','HA NOI','12-JAN-2002','12-JAN-2002','KIM CUONG');
    INSERT INTO HAINT_BANDOC VALUES ('006','006','HA','114','HA NOI','12-JAN-1990','12-JAN-1991','KIM CUONG');
    INSERT INTO HAINT_BANDOC VALUES ('007','007','Ban doc 7','114','HA NOI','12-JAN-1990','12-JAN-1991','KIM CUONG');
    INSERT INTO HAINT_BANDOC VALUES ('008','008','Ban doc 8','114','HA NOI','12-JAN-1990','12-JAN-1991','KIM CUONG');




    INSERT INTO HAINT_MUONSACH(id, id_bandoc, id_sach, soLuong, ngaygiomuon, ngaygiotra, trangthai, ghichu)
    VALUES ('001','002','001','1','12-JAN-2002','12-JAN-2003','1','ABC');

    INSERT INTO HAINT_MUONSACH(id, id_bandoc, id_sach, soLuong, ngaygiomuon, ngaygiotra, trangthai, ghichu)
    VALUES ('002','002','001','1','12-JAN-2002','12-JAN-2003','2','ABC1');

    INSERT INTO HAINT_MUONSACH(id, id_bandoc, id_sach, soLuong, ngaygiomuon, ngaygiotra, trangthai, ghichu)
    VALUES ('003','002','001','1','12-JAN-2002','12-JAN-2003','1','ABC');


-- --6.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin:
--     Mã Sách, Tên Sách, Tên Nhà Xuất Bản, Tên Tác Giả, Chủ Đề, Năm Xuất Bản, Số Lượng Còn Lại,

SELECT s.ma_sach,s.ten_sach,HN.ten_nxb,tg.ten_tg,s.chuDe_sach,s.namXB_sach,s.soLuongConLai_sach
FROM HAINT_SACH s join HAINT_NXB HN on s.id_nxb = HN.id join HAINT_TG tg on s.id_tg = tg.id
where ROWNUM < 10 order by s.soLuongConLai_sach desc;

--     5.	Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin:
-- Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách
-- Sắp xếp theo số lượng sách giảm dần.
select ma_tg,ten_tg,chuDe_sach,soLuongConLai_sach from HAINT_TG join HAINT_SACH on HAINT_TG.id = HAINT_SACH.id_tg order by soLuongConLai_sach desc;

-- --10
--     10.	Hiển thị thông tin bạn đọc gồm có:
-- Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)

    SELECT ma_bandoc,ten_bandoc, TO_NUMBER(TO_CHAR(SYSDATE,'YYYY')) - TO_NUMBER(TO_CHAR(ngaySinh_bandoc,'YYYY')) AS TUỔI
    FROM HAINT_BANDOC;

select * from HAINT_BANDOC;
--     11.	Thống kê tổng số bạn đọc theo độ tuổi
-- Tuổi, Tổng số Bạn Đọc
select (to_char(sysdate,'yyyy')-to_char(ngaySinh_bandoc,'yyyy')) as tuoi, count(id) as tongSoBanDoc
from HAINT_BANDOC group by (to_char(sysdate,'yyyy')-to_char(ngaySinh_bandoc,'yyyy'));

--     9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo tên bạn đọc tăng dần:
-- Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn
select * from HAINT_MUONSACH;
select ma_bandoc,ten_bandoc,count(soLuong) as soLanMuon
from HAINT_BANDOC bandoc
         join HAINT_MUONSACH muonsach on bandoc.id = muonsach.id_bandoc
where to_char(ngaygiomuon,'yyyy')>=2002
group by ma_bandoc,ten_bandoc
order by ten_bandoc asc;
-- 14.	Hiển thị toàn bộ bạn đọc và sách mà bạn đọc đấy mượn, sẽ có bạn chưa mượn vẫn cần hiển thị và tên sách để là null.
-- Mã bạn đọc, tên ban đọc, tên sách
select ma_bandoc,ten_bandoc,ten_sach
    from HAINT_MUONSACH ms inner join HAINT_BANDOC bd on ms.id_bandoc = bd.id join HAINT_SACH sach on ms.id_sach =  sach.id
