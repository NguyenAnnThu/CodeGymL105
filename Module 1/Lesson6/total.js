document.getElementById("sb").addEventListener("click", function(){
    let n = Number(document.getElementById("ngay").value);
    let Final=false;
    for (let i = 0; i <= 7; i++) {
        if(n==i)
        {
            Final = true;
            if (i == 1) {
                document.getElementById("kq").innerHTML = "Chủ nhật";
            }
            if (i == 2) {
                document.getElementById("kq").innerHTML = "Thứ 2";
            }
            if (i == 3) {
                document.getElementById("kq").innerHTML = "Thứ 3";
            }
            if (i == 4) {
                document.getElementById("kq").innerHTML = "Thứ 4";
            }
            if (i == 5) {
                document.getElementById("kq").innerHTML = "Thứ 5";
            }
            if (i == 6) {
                document.getElementById("kq").innerHTML = "Thứ 6";
            }
            if (i ==7) {
                document.getElementById("kq").innerHTML = "Thứ 7";
            }
            break;
        }
    }
    if(!Final){
        document.getElementById("kq").innerHTML = "Không phải ngày trong tuần";
    }
})