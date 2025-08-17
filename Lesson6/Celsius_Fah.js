document.getElementById("sb").addEventListener("click", function() {
    let ndo =parseFloat(document.getElementById("do").value);
    let fh=ndo*9/5+32;
    document.getElementById("fh").value=fh.toFixed(2);
})