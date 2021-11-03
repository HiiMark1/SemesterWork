package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.model.Post;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.PostServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "newPostServlet", urlPatterns = "/new_post")
public class NewPostServlet extends HttpServlet {
      User user;
      PostServiceImpl postService = new PostServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();

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
                        req.getRequestDispatcher("newPost.html").forward(req, resp);
                  } else {
                        resp.sendRedirect("/login");
                  }
            } else {
                  user = userService.get(login);
                  req.getRequestDispatcher("newPost.html").forward(req, resp);
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            if (req.getParameter("name") != null && !req.getParameter("text").equals("")
                    && !req.getParameter("name").equals("") && req.getParameter("text") != null) {
                  String text = req.getParameter("text");
                  String name = req.getParameter("name");
                  SimpleDateFormat out = new SimpleDateFormat("dd-MM-yy");
                  String newDate = out.format(new Date());
                  System.out.println(newDate);
                  Post post = new Post(user.getId(), newDate, 0, text, "", name);
                  postService.save(post);
                  resp.sendRedirect("/news");
            } else {
                  resp.sendRedirect("/new_post");
            }
      }
}
