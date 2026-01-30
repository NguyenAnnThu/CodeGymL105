package com.example.calculatorjsp.servlet;

import com.example.calculatorjsp.model.Calculator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOperand= Float.parseFloat(req.getParameter("first-operand"));
        float secondOperand= Float.parseFloat(req.getParameter("second-operand"));
        char  operator = req.getParameter("operator").charAt(0);
        try{
            float result= Calculator.calculate(firstOperand,secondOperand,operator);
            req.setAttribute("ketqua",result);
        }catch (Exception ex){
            req.setAttribute("error",ex.getMessage());
        }
        req.getRequestDispatcher("HomeCalculator.jsp").forward(req,resp);

    }
}
