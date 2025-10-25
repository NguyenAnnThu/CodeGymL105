document.getElementById("sb").addEventListener("click", function() {
    let ndo =parseFloat(document.getElementById("do").value);
    let fh=ndo*9/5+32;
    if(isNaN(a)||isNaN(b)){
        alert("Vui lòng nhập lại")
    }
    else {
        document.getElementById("fh").value = fh.toFixed(2);
    }
})