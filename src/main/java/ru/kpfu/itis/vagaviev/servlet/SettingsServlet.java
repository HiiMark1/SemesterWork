package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.helper.PasswordHelper;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "settingsServlet", urlPatterns = "/settings")
public class SettingsServlet extends HttpServlet {

      UserServiceImpl userService = new UserServiceImpl();
      String login;

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession httpSession = req.getSession();
            login = (String) httpSession.getAttribute("login");
            if (login == null) {
                  String l = null;
                  Cookie[] cookies = req.getCookies();
                  for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("login")) {
                              l = cookie.getValue();
                              break;
                        }
                  }
                  if (l != null) {
                        login = l;
                        HttpSession session = req.getSession();
                        session.setAttribute("login", l);
                        session.setMaxInactiveInterval(2 * 60 * 60);
                  } else {
                        resp.sendRedirect("/login");
                  }
            }
            User user = userService.get(login);
            req.setAttribute("user", user);
            req.getRequestDispatcher("settings.ftl").forward(req, resp);
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            User user = userService.get(login);
            if(req.getParameter("age") !=null && !req.getParameter("age").equals("")){
                  userService.changeAge(user, Integer.parseInt(req.getParameter("age")));
            }
            if(req.getParameter("name") !=null && !req.getParameter("name").equals("")){
                  userService.changeName(user, req.getParameter("name"));
            }
            if(req.getParameter("surname") !=null && !req.getParameter("surname").equals("")){
                  userService.changeSurname(user, req.getParameter("surname"));
            }
            if(req.getParameter("status") !=null && !req.getParameter("status").equals("")){
                  userService.changeStatus(user, req.getParameter("status"));
            }
            if(req.getParameter("oldPassword") !=null && !req.getParameter("oldPassword").equals("") && PasswordHelper.encrypt(req.getParameter("oldPassword")).equals(user.getPassword())
            && req.getParameter("newPassword")!=null && !req.getParameter("newPassword").equals("")){
                  userService.changePassword(user, req.getParameter("newPassword"));
            }

            resp.sendRedirect("/profile");
      }
}
