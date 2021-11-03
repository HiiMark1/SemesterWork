package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.service.Impl.PostServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "editPostServlet", urlPatterns = "/edit_post")
public class EditPostServlet extends HttpServlet {
      PostServiceImpl postService = new PostServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();
      int id = 0;

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if(req.getParameter("id")!=null){
                  id = Integer.parseInt(req.getParameter("id"));
            }
            if(id!=0){
                  HttpSession httpSession = req.getSession();
                  String login = (String) httpSession.getAttribute("login");
                  if (login == null) {
                        resp.sendRedirect("/post?id=" + id);
                  } else {
                        if(userService.get(login).getId()==postService.get(id).getUserId()){
                              req.setAttribute("post", postService.get(id));
                              req.getRequestDispatcher("edit_post.ftl").forward(req, resp);
                        } else {
                              resp.sendRedirect("/post?id=" + id);
                        }
                  }
            } else {
                  resp.sendRedirect("/post?id=" + id);
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("name") != null && !req.getParameter("name").equals("")){
                  String name = req.getParameter("name");
                  postService.changeName(postService.get(id), name);
            }
            if (req.getParameter("text") != null && !req.getParameter("text").equals("")){
                  String text = req.getParameter("text");
                  postService.changeText(postService.get(id), text);
            }
            resp.sendRedirect("/post?id=" + id);
      }
}
