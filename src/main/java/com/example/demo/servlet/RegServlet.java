package com.example.demo.servlet;

import com.example.demo.model.User;
import com.example.demo.service.Impl.UserServiceImpl;
import com.example.demo.service.Service;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "regServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {

      Service userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.sendRedirect("reg.html");
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            if(req.getParameter("age").equals("") || req.getParameter("age") == null || req.getParameter("login") == null ||
                    req.getParameter("mail") == null || req.getParameter("pass") == null ||
                    req.getParameter("pass2") == null){
                  resp.sendRedirect("/reg");
            } else {
                  String login = req.getParameter("login");
                  String mail = req.getParameter("mail");
                  String password = req.getParameter("pass");
                  String confirmedPassword = req.getParameter("pass2");
                  int age = Integer.parseInt(req.getParameter("age"));
                  if (userService.get(login) == null && password.equals(confirmedPassword) && mail != null && age > 18 && login != null) {
                        User user = new User(age, login, mail, password);
                        userService.save(user);
                        resp.sendRedirect("/login");
                  } else {
                        resp.sendRedirect("/reg");
                  }
            }
      }
}
