document.getElementById("check").addEventListener("click", function() {
    let a=Number(document.getElementById("weight").value);
    let b=parseFloat(document.getElementById("height").value);
    let c=Number(document.getElementById("old").value);
    let BMI=a/(b*b);
    if (c>=20){
        if(b===0|| a===0||(a===0&& b===0)){
            document.getElementById("result").innerHTML="Không hợp lệ!!!";
        }
        else{
            if(BMI<18.5){
                document.getElementById("result").innerHTML="Underweight"
            }
            else if(BMI<25.0){
                document.getElementById("result").innerHTML="Normal"
            }
            else if(BMI<30.0){
                document.getElementById("result").innerHTML="Overweight"
            }
            else{
                document.getElementById("result").innerHTML="Obese"
            }
        }
    }
    else{
        alert("Bạn chưa đủ tuổi ")
    }


})