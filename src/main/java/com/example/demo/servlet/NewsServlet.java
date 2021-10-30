package com.example.demo.servlet;

import com.example.demo.service.Impl.PostServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "newsServlet", urlPatterns = "/news")
public class NewsServlet extends HttpServlet {

      PostServiceImpl postService = new PostServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            req.setAttribute("news", postService.getLastTenPosts());
            resp.sendRedirect("news.jsp");
      }
}