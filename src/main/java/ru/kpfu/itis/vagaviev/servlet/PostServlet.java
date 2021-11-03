package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.model.Comment;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.CommentServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.PostServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "postServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
      PostServiceImpl postService = new PostServiceImpl();
      CommentServiceImpl commentService = new CommentServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();
      int id = 0;

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(req.getParameter("id")!=null){
                  id = Integer.parseInt(req.getParameter("id"));
            }
            if(id!=0){
                  if(postService.get(id)==null){
                        resp.sendRedirect("/news");
                  } else {
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
                        req.getRequestDispatcher("post.ftl").forward(req, resp);
                  }
            } else {
                  resp.sendRedirect("/news");
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String text = req.getParameter("text");
            if (text!=null){
                  HttpSession httpSession = req.getSession();
                  String login = (String) httpSession.getAttribute("login");
                  if (login!=null){
                        User user = userService.get(login);
                        commentService.save(new Comment(user.getId(), new Date().getTime(), text, postService.get(id).getId()));
                        resp.sendRedirect("/post?id=" + postService.get(id).getId());
                  } else {
                        resp.sendRedirect("/login");
                  }
            } else {
                  resp.sendRedirect("/post?id=" + postService.get(id).getId());
            }
      }
}
