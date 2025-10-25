function isNotANumber(num){
    if(isNaN(num)){
        alert("Vui lòng nhập lại")
        return false;
    }
    return true
}
function BinhPhuong(a){
    return a*a
}
function DienTich(r){
    return (Math.PI*r*r).toFixed(2)
}
function ChuVi(r){
    return (2*Math.PI*r).toFixed(2)
}
function GiaiThua(a){
    if (a<0){
        return "Không tính giai thừa số âm"
    }
    let result=1
    for (let i=1;i<=a;i++){
        result*=i
    }
    return result
}
function SoSanh(a,b,c){
    return Math.min(a,b,c)
}
function SoDuong(a){
    if(a<0){
        return false
    }
    return true
}