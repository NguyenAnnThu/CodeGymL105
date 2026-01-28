package com.example.productcalculator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name= "DiscountServlet" ,value="/discount")
public class DiscountServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");
        float price= Float.parseFloat(req.getParameter("price"));
        int discount =Integer.parseInt(req.getParameter("sale"));
        double disAmount= price * discount * 0.01;
        double result=price - disAmount;
        req.setAttribute("disA",disAmount);
        req.setAttribute("kq",result);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }
}
