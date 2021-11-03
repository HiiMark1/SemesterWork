package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

      UserServiceImpl userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("id")!=null){
                  int i = Integer.parseInt(req.getParameter("id"));
                  User u = userService.get(i);
                  System.out.println(u.getId());
                  if(u!=null){
                        HttpSession httpSession = req.getSession();
                        String login = (String) httpSession.getAttribute("login");
                        if (login == null && req.getCookies()!=null) {
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
                                    User user = userService.get(login);
                                    req.setAttribute("u", u);
                                    req.setAttribute("user", user);
                                    req.getRequestDispatcher("profile.ftl").forward(req, resp);
                              } else {
                                    resp.sendRedirect("/login");
                              }
                        } else {
                              User user = userService.get(login);
                              req.setAttribute("u", u);
                              req.setAttribute("user", user);
                              req.getRequestDispatcher("profile.ftl").forward(req, resp);
                        }
                  } else {
                        resp.sendRedirect("/profile");
                  }
            } else {
                  HttpSession httpSession = req.getSession();
                  String login = (String) httpSession.getAttribute("login");
                  if (login == null && req.getCookies()!=null) {
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
                              User user = userService.get(login);
                              req.setAttribute("user", user);
                              req.getRequestDispatcher("profile.ftl").forward(req, resp);
                        } else {
                              resp.sendRedirect("/login");
                        }
                  } else {
                        User user = userService.get(login);
                        req.setAttribute("user", user);
                        req.getRequestDispatcher("profile.ftl").forward(req, resp);
                  }
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doPost(req, resp);
      }
}
