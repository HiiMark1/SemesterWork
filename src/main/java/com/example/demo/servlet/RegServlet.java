package com.example.demo.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "regServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.sendRedirect("reg.html");
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String login = req.getParameter("login");
            String mail = req.getParameter("mail");
            String password = req.getParameter("pass");
            String confirmedPassword = req.getParameter("pass2");
            int age = Integer.parseInt(req.getParameter("age"));
            if (password.equals(confirmedPassword) && mail!=null && age>18 && login!=null) {
                  resp.sendRedirect("/login");
            } else {
                  resp.sendRedirect("/reg");
            }
      }
}
