package com.example.ss11_mvc.Controller;

import com.example.ss11_mvc.Entity.Product;
import com.example.ss11_mvc.Service.IProductService;
import com.example.ss11_mvc.Service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name="ProductController", value="/product")

public class ProductController extends HttpServlet {
    private IProductService productService=new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                req.getRequestDispatcher("/view/add.jsp").forward(req,resp);
                break;
            case "search":
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                deletebyId(req,resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.findById(id);

        req.setAttribute("product", product);
        req.getRequestDispatcher("/view/update.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action ="";
        }
        switch (action){
            case "add":
                save(req,resp);
                break;
            case "search":
                break;
            case "edit":
                updatePro(req, resp);
                break;
            default:
                showList(req,resp);
        }
    }

    private void deletebyId(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String idStr = req.getParameter("id");

        if (idStr == null || idStr.isEmpty()) {
            resp.sendRedirect("/product");
            return;
        }

        int id = Integer.parseInt(idStr);
        productService.delete(id);

        resp.sendRedirect("/product");
    }


    private void updatePro(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String idStr = req.getParameter("id");
        String quantityStr = req.getParameter("quantity");

        if (idStr == null || idStr.isEmpty()
                || quantityStr == null || quantityStr.isEmpty()) {
            resp.sendRedirect("/product");
            return;
        }

        int id = Integer.parseInt(idStr);
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(quantityStr);
        String expirationDate = req.getParameter("expirationDate");

        Product product = new Product(id, name, quantity, expirationDate);
        productService.update(product);

        resp.sendRedirect("/product");
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String expirationDate = req.getParameter("expirationDate");

        // Tạo id tự tăng đơn giản
        int id = productService.findAll().size() + 1;

        Product product = new Product(id, name, quantity, expirationDate);
        productService.add(product);

        resp.sendRedirect("/product");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList",productService.findAll());
        req.getRequestDispatcher("/view/list.jsp").forward(req,resp);
    }
}
