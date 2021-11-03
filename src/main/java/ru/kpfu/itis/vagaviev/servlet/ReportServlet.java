package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.model.Report;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.ReportServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "reportServlet", urlPatterns = "/report")
public class ReportServlet extends HttpServlet {
      User user;
      UserServiceImpl userService = new UserServiceImpl();
      ReportServiceImpl reportService = new ReportServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession httpSession = req.getSession();
            String login = (String) httpSession.getAttribute("login");
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
                        user = userService.get(login);
                        req.getRequestDispatcher("report.html").forward(req, resp);
                  } else {
                        resp.sendRedirect("/login");
                  }
            } else {
                  user = userService.get(login);
                  req.getRequestDispatcher("report.html").forward(req, resp);
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("text") != null && !req.getParameter("text").equals("")){
                  boolean isTech = false;
                  String text = req.getParameter("text");
                  if (req.getParameter("isTech")!=null){
                        if((req.getParameter("isTech").equals("isTech"))){
                              isTech = true;
                        }
                  }
                  Report report = new Report(user.getId(), new Date().getTime(), text, isTech);
                  reportService.save(report);
                  resp.sendRedirect("/news");
            } else {
                  resp.sendRedirect("/report");
            }
      }
}
