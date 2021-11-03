package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.helper.PasswordHelper;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

      UserServiceImpl userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            resp.sendRedirect("login.html");
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String login = req.getParameter("login");
            String password = req.getParameter("pass");
            if(login == null || password == null || login.equals("") || password.equals("")){
                  resp.sendRedirect("/login");
            } else {
                  User user = userService.get(login);
                  if(user == null){
                        resp.sendRedirect("/login");
                  } else {
                        if (user.getPassword().equals(PasswordHelper.encrypt(password))) {
                              HttpSession session = req.getSession();
                              session.setAttribute("login", login);
                              session.setMaxInactiveInterval(2*60*60);
                              if(req.getParameter("remember")!=null && (req.getParameter("remember").equals("rem"))){
                                    Cookie userCookie = new Cookie("login", login);
                                    userCookie.setMaxAge(7*24*60*60);
                                    resp.addCookie(userCookie);
                              }
                              resp.sendRedirect("/profile");
                        } else {
                              resp.sendRedirect("/login");
                        }
                  }
            }
      }
}