use case_study;

/* câu 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên
 bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.*/
	select *
    from nhan_vien 
    where ho_ten like ('% K%' or '% H%' or '% T%') and char_length (ho_ten)<=15;
/* câu 3: 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và 
có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”. */
	select * 
    from khach_hang
    where (dia_chi like '% Đà Nẵng' or  '% Quảng Trị') 
    and TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) BETWEEN 18 AND 50;

/* câu 4 : Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần
 theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.*/
	select c.ma_khach_hang , c.ho_ten, count(h.ma_hop_dong) as so_lan_dat
    from khach_hang c
    join hop_dong h on c.ma_khach_hang=h.ma_khach_hang
    join loai_khach l on c.ma_loai_khach= l.ma_loai_khach
    where l.ten_loai_khach like 'Diamond'
    group by c.ma_khach_hang
    order by so_lan_dat  asc;

/* câu 5:Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc,
 tong_tien (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng
 dich_vu_di_kem, hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt 
 phòng cũng phải hiển thị ra).*/
	select 	k.ma_khach_hang,
			k.ho_ten,
            l.ten_loai_khach,
            h.ma_hop_dong,
            s.ten_dich_vu,
            h.ngay_lam_hop_dong,
            h.ngay_ket_thuc,
			(s.chi_phi_thue +ifnull(sum(ct.so_luong * sct.gia),0)) as tong_tien
	from khach_hang k
	left join loai_khach l on k.ma_loai_khach= l.ma_loai_khach
    left join hop_dong h on k.ma_khach_hang = h.ma_khach_hang
    left join dich_vu s on h.ma_dich_vu = s.ma_dich_vu
    left join hop_dong_chi_tiet ct on h.ma_hop_dong = ct.ma_hop_dong
    left join dich_vu_di_kem sct on ct.ma_dich_vu_di_kem = sct.ma_dich_vu_di_kem
    group by k.ma_khach_hang,
			k.ho_ten,
            l.ten_loai_khach,
            h.ma_hop_dong,
            s.ten_dich_vu,
            h.ngay_lam_hop_dong,
            h.ngay_ket_thuc;

/* câu 6:	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa 
từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3). */
	select 	dv.ma_dich_vu, 
			dv.ten_dich_vu,
            dv.dien_tich,
            dv.chi_phi_thue,
            ldv.ten_loai_dich_vu
	from dich_vu dv 
    inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
    where dv.ma_dich_vu not in (
			select distinct ma_dich_vu 
			from hop_dong 
            where year(ngay_lam_hop_dong)=2021
				and quarter(ngay_lam_hop_dong)=1
	);

/* câu 7:Hiển thị thông tin mã dịch vụ , ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,ten_loai_dich_vu của tất cả
các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 nhưng chưa từng được khách hàng đặt phòng trong năm 2021.*/
	select distinct	dv.ma_dich_vu, 
			dv.ten_dich_vu, 
            dv.dien_tich, 
            dv.so_nguoi_toi_da, 
            dv.chi_phi_thue, 
            ldv.ten_loai_dich_vu
	from dich_vu dv
	inner join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
	where exists(
		select 1 from hop_dong hd
        where dv.ma_dich_vu=hd.ma_dich_vu
        and year(hd.ngay_lam_hop_dong)=2020
	)
	and not exists(
		select 1 from hop_dong hd
        where dv.ma_dich_vu=hd.ma_dich_vu
        and year(hd.ngay_lam_hop_dong)=2021
	);
 
/*8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.*/
	-- 1: distinct
			select distinct ho_ten as customer_name
            from khach_hang;
	-- 2: group by
			select ho_ten as customer_name
            from khach_hang
            group by ho_ten;
	-- 3: union
			select ho_ten from khach_hang
            union
            select ho_ten from khach_hang;
/*9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì sẽ có bao nhiêu
	khách hàng thực hiện đặt phòng.*/
		select month(hd.ngay_lam_hop_dong) as thang,count(kh.ma_khach_hang) as so_luong
        from hop_dong hd 
        join khach_hang kh on hd.ma_khach_hang= kh.ma_khach_hang
        where year(hd.ngay_lam_hop_dong)=2021
        group by month(hd.ngay_lam_hop_dong)
        order by thang;
        
/*10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. Kết quả hiển thị bao gồm 
ma_hop_dong, ngay_lam_hop_dong,ngay_ket_thuc, tien_dat_coc, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở 
dich_vu_di_kem).*/
		select 	hd.ma_hop_dong ,
				hd.ngay_lam_hop_dong,
                hd.ngay_ket_thuc ,
                hd.tien_dat_coc,
               ifnull(sum(hdct.so_luong),0) as so_luong_dich_vu_di_kem
		from hop_dong hd
        left join hop_dong_chi_tiet hdct on hd.ma_hop_dong= hdct.ma_hop_dong
		group by hd.ma_hop_dong;
/*11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng có ten_loai_khach là “Diamond” và 
	có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.*/
    select * from khach_hang;
    select dvdk.* 
    from dich_vu_di_kem dvdk
    join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem= hdct.ma_dich_vu_di_kem
    join hop_dong hd on hdct.ma_hop_dong= hd.ma_hop_dong
    join khach_hang kh on hd.ma_khach_hang = kh.ma_khach_hang
    where (dia_chi like '%Vinh' or '%Quảng Ngãi')
    and exists (
		select *from loai_khach
        where ten_loai_khach='Diamond'
	);

/*12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), ten_dich_vu, 
so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc của tất cả các dịch vụ đã từng 
được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.*/
	select 	hd.ma_hop_dong ,
			nv.ho_ten as ten_nhan_vien,
            kh.ho_ten as ten_khach_hang,
            kh.so_dien_thoai,
            dv.ten_dich_vu,
            ifnull(sum(hdct.so_luong),0) as so_luong_dich_vu_di_kem,
            hd.tien_dat_coc 
	from hop_dong hd
    join khach_hang kh on hd.ma_khach_hang= kh.ma_khach_hang
    join nhan_vien nv on hd.ma_nhan_vien= nv.ma_nhan_vien
    join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
    left join hop_dong_chi_tiet hdct on hd.ma_hop_dong= hdct.ma_hop_dong
    WHERE hd.ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-31'
	AND NOT EXISTS(
			select 1
            from hop_dong hd1 
            where hd1.ma_hop_dong = hd.ma_hop_dong
            and year(ngay_lam_hop_dong)=2021 and 
					month (ngay_lam_hop_dong) not between 1 and 6
			)
	group by hd.ma_hop_dong;
            
/*13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng.
 (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).*/
		select 	dvdk.ma_dich_vu_di_kem,
				dvdk.ten_dich_vu_di_kem,
                sum(hdct.so_luong) as so_luong
		from dich_vu_di_kem dvdk
        inner join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem= hdct.ma_dich_vu_di_kem
        group by dvdk.ma_dich_vu_di_kem
        having 	so_luong=(
				select max(tong_so_luong)
                from 
					(
						select sum(so_luong) as  tong_so_luong
                        from hop_dong_chi_tiet
                        group by ma_dich_vu_di_kem
                    ) as ttdv
				);
									
/*14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị
 bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các 
 ma_dich_vu_di_kem).*/
		select 	hd.ma_hop_dong,
				ldv.ten_loai_dich_vu,
                dvdk.ten_dich_vu_di_kem,
                count(hdct.ma_dich_vu_di_kem) as so_luong
		from hop_dong hd
        join dich_vu dv on hd.ma_dich_vu= dv.ma_dich_vu
        join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
        join hop_dong_chi_tiet hdct on hd.ma_hop_dong= hdct.ma_hop_dong
        join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
        group by hd.ma_hop_dong,ldv.ten_loai_dich_vu,dvdk.ten_dich_vu_di_kem
        having count(hdct.ma_dich_vu_di_kem)=1;
        
/*15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.*/
		select 	nv.ma_nhan_vien,
				nv.ho_ten,
                td.ten_trinh_do,
                bp.ten_bo_phan,
                nv.so_dien_thoai,
                nv.dia_chi
		from nhan_vien nv
        join trinh_do td on nv.ma_trinh_do= td.ma_trinh_do
        join bo_phan bp on nv.ma_bo_phan= bp.ma_bo_phan
        join hop_dong hd on nv.ma_nhan_vien= hd.ma_nhan_vien        
        where year(hd.ngay_lam_hop_dong) in (2020,2021)
        group by nv.ma_nhan_vien
        having count(hd.ma_hop_dong)<=3;
/*16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.*/
SET SQL_SAFE_UPDATES = 0;
		delete 
        from nhan_vien nv
        where not exists (
				select 1 
                from hop_dong hd
                where hd.ma_nhan_vien= nv.ma_nhan_vien
        );
SET SQL_SAFE_UPDATES = 1;
        select nv.*
        from nhan_vien nv
        where not exists (
				select 1 
                from hop_dong hd
                where hd.ma_nhan_vien= nv.ma_nhan_vien
        );
        
/*17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.*/
		update khach_hang kh
        join loai_khach lk on kh.ma_loai_khach= lk.ma_loai_khach
		set  kh.ma_loai_khach = (
					SELECT ma_loai_khach 
					FROM loai_khach 
					WHERE ten_loai_khach = 'Diamond'
				)
        where 	lk.ten_loai_khach='Platinum' AND kh.ma_khach_hang > 0 and 
				kh.ma_khach_hang in
			(
                select ma_khach_hang 
                from (
						select hd.ma_khach_hang 
                        from hop_dong hd 
                        join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                        join hop_dong_chi_tiet hdct on hd.ma_hop_dong= hdct.ma_hop_dong
                        join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
                        where year(hd.ngay_lam_hop_dong)=2021 
                        group by hd.ma_khach_hang
                        having sum(dv.chi_phi_thue + hdct.so_luong*dvdk.gia)>10000000
                        ) as tmp
				);
                
/*18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).*/
		delete from khach_hang kh
        where exists(
					select * from hop_dong hd
                    where	 kh.ma_khach_hang=hd.ma_khach_hang 
							and year(ngay_lam_hop_dong)<2021
        );
        SET SQL_SAFE_UPDATES = 0;
		SET FOREIGN_KEY_CHECKS = 0;
        SET SQL_SAFE_UPDATES = 1;
		SET FOREIGN_KEY_CHECKS = 1;

/*19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.*/
		update dich_vu_di_kem dvdk
        set dvdk.gia= dvdk.gia*2
        where dvdk.ma_dich_vu_di_kem in
        (
			select hdct.ma_dich_vu_di_kem
            from hop_dong_chi_tiet hdct
            join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
            where year(ngay_lam_hop_dong) =2020
            group by hdct.ma_dich_vu_di_kem
            having sum(hdct.so_luong) >10
		);
            
        select dvdk.* from dich_vu_di_kem dvdk
        join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem 
        join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong
        where year(ngay_lam_hop_dong) =2020
        group by dvdk.ma_dich_vu_di_kem
        having sum(so_luong)>10;
select* from dich_vu_di_kem;
select * from hop_dong_chi_tiet;
select * from hop_dong;
/*20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.*/
		select	ma_nhan_vien as id, ho_ten, email, so_dien_thoai,ngay_sinh,dia_chi 
        from nhan_vien
        union all
        select ma_khach_hang as id, ho_ten, email, so_dien_thoai,ngay_sinh,dia_chi 
        from khach_hang;
/*21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.*/
		create view v_nhan_vien as
        select distinct nv.* from nhan_vien nv 
        join hop_dong hd on nv.ma_nhan_vien = hd.ma_nhan_vien
        where nv.dia_chi like '%Hải Châu' and
				hd.ngay_lam_hop_dong = '2019-12-12';
/*22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên 
được nhìn thấy bởi khung nhìn này.*/
select * from v_nhan_vien;
		UPDATE nhan_vien
		SET dia_chi = 'Liên Chiểu'
		WHERE ma_nhan_vien IN (
			SELECT ma_nhan_vien
			FROM v_nhan_vien
		);
/*23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được
 truyền vào như là 1 tham số của sp_xoa_khach_hang.*/
		
/*24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong 
phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn 
vẹn tham chiếu đến các bảng liên quan.*/
/*25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn 
lại có trong bảng hop_dong ra giao diện console của database.
	Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.*/
/*26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời
 gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất
 là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp
 đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
	Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.*/
/*27.	Tạo Function thực hiện yêu cầu sau:
a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc 
kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp
 đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số
 của function này.*/
/*28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ 
là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng 
dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những
 bản liên quan khác.*/
