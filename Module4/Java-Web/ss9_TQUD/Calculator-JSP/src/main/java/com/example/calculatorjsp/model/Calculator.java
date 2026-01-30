package com.example.calculatorjsp.model;

public class Calculator {
    public static float calculate(float firstOperand,float secondOperand, char operator){
        switch (operator){
            case '+':
                return firstOperand+secondOperand;
            case '-':
                return firstOperand-secondOperand;
            case '*':
                return firstOperand*secondOperand;
            case '/':
                if(secondOperand!=0)
                    return firstOperand/secondOperand;
                else
                    throw new RuntimeException("Không chia được cho 0");
            default:
                throw new RuntimeException("Thao tác không hợp lệ !");

        }
    }
}
