use quanlysinhvien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất
	select * 
    from subjects 
    where credit = (select max(credit) from subjects);
  -- ****** Cách 2
	select * from subjects
    order by credit DESC
    limit 1;
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
	select s.*, m.mark 
    from subjects s
    join mark m on s.subID = m.subID
    where m.mark= (select max(m.mark) from mark m);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
	select st.* , dtb
    from students st
    join ( 
			select m.StuID , AVG(m.mark) as dtb
            from mark m 
			group by m.StuID
		) t on st.stuID = t.StuID
	order by dtb DESC;
select * from mark;