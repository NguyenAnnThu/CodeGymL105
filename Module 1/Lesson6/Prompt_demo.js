
    document.getElementById("sb").addEventListener('click',function()
    {
        let toan=parseFloat(document.getElementsByClassName("diem")[0].value);
        let ly=parseFloat(document.getElementsByClassName("diem")[1].value);
        let sinh=parseFloat(document.getElementsByClassName("diem")[2].value);
        if (toan<0||ly<0||sinh<0) {

            alert("Không hợp lệ");
        }
        let AVG=(toan+ly+sinh)/3;
        let sum=toan+sinh+ly;
            document.getElementById("kq").innerHTML= "Tổng điểm: " + sum + "<br>" +
                "Điểm trung bình: " + AVG

    })
