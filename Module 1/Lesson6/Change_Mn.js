document.getElementById("cv").addEventListener("click", function(){
    let amount=parseFloat(document.getElementById("money").value);
    let FCurrent= String(document.getElementById("from").value);
    let TCurrent =String(document.getElementById("to").value);
    let result1=amount*26;
    let result=amount/26;
    if(FCurrent==TCurrent ||amount<=0|| isNaN(amount)){
        alert("Không hợp lệ!!!")
    }
    else{

        if(FCurrent!=TCurrent && TCurrent==="1"){

            document.getElementById("change").innerHTML=result1;
        }
       else{
           document.getElementById("change").innerHTML=result;
        }
    }
})
