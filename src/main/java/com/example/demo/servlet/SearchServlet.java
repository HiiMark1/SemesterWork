package com.example.demo.servlet;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.Impl.PostServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "searchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
      PostServiceImpl postService = new PostServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("search.ftl").forward(req, resp);
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String type = req.getParameter("flexRadioDefault");
            if (req.getParameter("text") != null) {
                  req.setAttribute("result", "1");
                  String q = req.getParameter("text");
                  if (type != null && q != null) {
                        if (type.equals("posts")) {
                              req.setAttribute("type", 1);
                              List<Post> posts1 = postService.getAll();
                              String[] str = q.split("\\+");
                              List<Post> posts = new ArrayList<>();
                              for (Post post : posts1) {
                                    for (String s : str) {
                                          if (post.getName().toLowerCase().contains(s.toLowerCase()) || post.getText().toLowerCase().contains(s.toLowerCase())) {
                                                posts.add(post);
                                                break;
                                          }
                                    }
                              }
                              req.setAttribute("users", null);
                              req.setAttribute("posts", posts);
                              req.getRequestDispatcher("search.ftl").forward(req, resp);
                        } else {
                              req.setAttribute("type", 2);
                              List<User> posts1 = userService.getAll();
                              String[] str = q.split("\\+");
                              List<User> users = new ArrayList<>();
                              for (User user : posts1) {
                                    for (String s : str) {
                                          if ((user.getName() != null && user.getName().toLowerCase().contains(s.toLowerCase())) ||
                                                  (user.getSurname() != null && user.getSurname().toLowerCase().contains(s.toLowerCase())) ||
                                                  user.getLogin().toLowerCase().contains(s.toLowerCase())) {
                                                users.add(user);
                                                break;
                                          }
                                    }
                              }
                              req.setAttribute("posts", null);
                              req.setAttribute("users", users);
                              req.getRequestDispatcher("search.ftl").forward(req, resp);
                        }
                  }
            } else {
                  resp.sendRedirect("/search");
            }
      }
}
