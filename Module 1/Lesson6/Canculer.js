document.getElementById("add").addEventListener("click", function() {
    let a=Number(document.getElementById("int").value);
    let b=Number(document.getElementById("int2").value);
    if(isNaN(a)||isNaN(b)){
        alert("Vui lòng nhập lại")
    }
    else{
        document.getElementById("kq").innerHTML=a+b;
    }

})
document.getElementById("sub").addEventListener("click", function() {
    let a=Number(document.getElementById("int").value);
    let b=Number(document.getElementById("int2").value);
    if(isNaN(a)||isNaN(b)){
        alert("Vui lòng nhập lại")
    }
    else{
    document.getElementById("kq").innerHTML=a-b;
    }
})
document.getElementById("mul").addEventListener("click", function() {
    let a=Number(document.getElementById("int").value);
    let b=Number(document.getElementById("int2").value);
    if(isNaN(a)||isNaN(b)){
        alert("Vui lòng nhập lại")
    }
    else{
    document.getElementById("kq").innerHTML=a*b;
    }
})
document.getElementById("div").addEventListener("click", function() {
    let a=Number(document.getElementById("int").value);
    let b=Number(document.getElementById("int2").value);
    if(isNaN(a)||isNaN(b)){
        alert("Vui lòng nhập lại")
    }
    else {
        if (b == 0) {
            document.getElementById("kq").innerHTML = "Không chia được cho 0"
        } else {
            document.getElementById("kq").innerHTML = a / b;
        }
    }
})

