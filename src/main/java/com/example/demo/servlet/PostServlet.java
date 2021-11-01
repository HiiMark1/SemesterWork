package com.example.demo.servlet;

import com.example.demo.service.Impl.CommentServiceImpl;
import com.example.demo.service.Impl.PostServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "postServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
      PostServiceImpl postService = new PostServiceImpl();
      CommentServiceImpl commentService = new CommentServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = 0;
            if(req.getParameter("id")!=null){
                  id = Integer.parseInt(req.getParameter("id"));
            }
            if(id!=0){
                  HttpSession httpSession = req.getSession();
                  String login = (String) httpSession.getAttribute("login");
                  if (login == null) {
                        req.setAttribute("post", postService.get(id));
                        req.setAttribute("user", null);
                  } else {
                        req.setAttribute("post", postService.get(id));
                        req.setAttribute("user", userService.get(login));
                  }
                  req.setAttribute("comments", commentService.getPostComments(id));
                  req.getRequestDispatcher("post.jsp").forward(req, resp);
            } else {
                  resp.sendRedirect("/news");
            }
      }
}
