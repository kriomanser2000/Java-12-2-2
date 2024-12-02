package com.example.java1222.model.servlet;


import com.example.java1222.model.QuizCategory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/categories")
public class CategoryServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("categories", QuizCategory.values());
        request.getRequestDispatcher("/category.jsp").forward(request, response);
    }
}
