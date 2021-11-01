package com.example.demo.servlet;

import com.example.demo.service.Impl.PostServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "newsServlet", urlPatterns = "/news")
public class NewsServlet extends HttpServlet {

      PostServiceImpl postService = new PostServiceImpl();
      UserServiceImpl userService = new UserServiceImpl();

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            HttpSession httpSession = req.getSession();
            String login = (String) httpSession.getAttribute("login");
            if (login!=null){
                  req.setAttribute("user", userService.get(login));
            }
            req.setAttribute("news", postService.getLastTenPosts());
            req.getRequestDispatcher("news.jsp").forward(req, resp);
      }
}