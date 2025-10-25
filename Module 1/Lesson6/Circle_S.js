document.getElementById("sb").addEventListener("click", function() {
    let bk=parseFloat(document.getElementById("bk").value);
    let S= Math.PI * Math.pow(2,bk);
    let CV=2*Math.PI*bk;
    if(isNaN(bk)){
        alert("Vui lòng nhập lại")
    }
    else {
        document.getElementById("kq").innerHTML = "Diện tích hình tròn là:" + S.toFixed(2) +
            "<br>" + " Chu vi hình tròn:" + CV.toFixed(2);
    }
})