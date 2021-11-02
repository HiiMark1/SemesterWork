package com.example.demo.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "charServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
//      @Override
//      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            resp.setContentType("text/plain");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write(String.format("Hello! %s", System.currentTimeMillis()));
//      }
}
