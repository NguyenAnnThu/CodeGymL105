document.getElementById("kq").addEventListener("click",function(){
    let input = document.getElementById("kq");
    let expression = "";
    let lastAns = "";
    if (btn.id === "ac") {
        expression = "";
        input.value = "0";
    }
    else if (btn.id === "submit") {
        try {
            let result = eval(expression);
            input.value = result;
            lastAns = result;
            expression = result.toString();
        } catch {
            input.value = "Error";
            expression = "";
        }
    }
    else if (btn.id === "ans") {
        expression += lastAns;
        input.value = expression;
    }
    else if (btn.id === "sin") {
        expression += "Math.sin(";
        input.value = expression;
    }
    else if (btn.id === "cos") {
        expression += "Math.cos(";
        input.value = expression;
    }
    else if (btn.id === "tan") {
        expression += "Math.tan(";
        input.value = expression;
    }
    else if (btn.id === "log") {
        expression += "Math.log10(";
        input.value = expression;
    }
    else if (btn.id === "ln") {
        expression += "Math.log(";
        input.value = expression;
    }
    else if (btn.id === "pi") {
        expression += "Math.PI";
        input.value = expression;
    }
    else if (btn.id === "e") {
        expression += "Math.E";
        input.value = expression;
    }
    else if (btn.id === "can") { // căn bậc 2
        expression += "Math.sqrt(";
        input.value = expression;
    }
    else if (btn.id === "mu") {
        expression += "**"; // x^y
        input.value = expression;
    }
    else { // số và toán tử bình thường
        if (input.value === "0") {
            expression = val;
        } else {
            expression += val;
        }
        input.value = expression;
    }
});
