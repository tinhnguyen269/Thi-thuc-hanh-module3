package com.example.module3.Controllers;

import com.example.module3.Services.IProductService;
import com.example.module3.Services.impl.ProductService;
import com.example.module3.Models.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/product")
public class ProductController extends HttpServlet {
    private IProductService productService = (IProductService) new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<Product> products = productService.findAll();
                req.setAttribute("products",products);
                req.getRequestDispatcher("/create.jsp").forward(req, resp);
                break;

            default:
                products = productService.findAll();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/list.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                double discount = Double.parseDouble(req.getParameter("discount"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
               Product product = new Product(name,price,discount,quantity);
                productService.save(product);
                resp.sendRedirect("/product");
                break;
        }
    }
}
