package com.example.listcustomer.controller;

import com.example.listcustomer.entity.Customers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name="ListServlet", value="/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customers> customers= new ArrayList<>();
        customers.add(new Customers("Nguyễn Văn An", "1995-01-01", "Hà Nội", "image/image1.jpg"));
        customers.add(new Customers("Trần Thị Binh", "1996-02-02", "Đà Nẵng", "image/image2.jpg"));
        customers.add(new Customers("Lê Văn Cuong", "1997-03-03", "TP.HCM", "image/image3.jpg"));

        req.setAttribute("customers", customers);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
