package com.example.demo.servlet;

import com.example.demo.modelDTO.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {

      private static final UserDTO TestUser = new UserDTO(1, "Man4ik", "Name1", "Surname1", "ggg@mail.ru",
              "Мальчики девочки0", "Cringe", 20);

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("user", TestUser);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
      }
}
