package ru.kpfu.itis.vagaviev.servlet;

import ru.kpfu.itis.vagaviev.model.Message;
import ru.kpfu.itis.vagaviev.model.User;
import ru.kpfu.itis.vagaviev.service.Impl.MessagesServiceImpl;
import ru.kpfu.itis.vagaviev.service.Impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@WebServlet(name = "chatServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
      UserServiceImpl userService = new UserServiceImpl();
      MessagesServiceImpl messagesService = new MessagesServiceImpl();
      User u = null;
      User user = null;
      int id1 = 0;
      int id2 = 0;

      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("id")!=null){
                  u = userService.get(Integer.parseInt(req.getParameter("id")));
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
                              user = userService.get(login);

                              if(u!=null){
                                    req.setAttribute("user1", u);
                                    req.setAttribute("user2", user);
                                    if(u.getId()==user.getId()){
                                          resp.sendRedirect("/profile");
                                    } else {
                                          if(u.getId()<user.getId()){
                                                id1 = u.getId();
                                                id2 = user.getId();
                                          } else {
                                                id1 = user.getId();
                                                id2 = u.getId();
                                          }
                                          List<Message> messageList = messagesService.getAllMessagesForUsers(id1,id2);
                                          Collections.reverse(messageList);
                                          req.setAttribute("messages", messageList);
                                          req.getRequestDispatcher("chat.ftl").forward(req, resp);
                                    }
                              } else {
                                    resp.sendRedirect("/profile");
                              }
                        } else {
                              resp.sendRedirect("/login");
                        }
                  } else {
                        user = userService.get(login);
                        req.setAttribute("user1", u);
                        req.setAttribute("user2", user);

                        if(u!=null){
                              if(u.getId()==user.getId()){
                                    resp.sendRedirect("/profile");
                              } else {
                                    if(u.getId()<user.getId()){
                                          id1 = u.getId();
                                          id2 = user.getId();
                                    } else {
                                          id1 = user.getId();
                                          id2 = u.getId();
                                    }
                                    List<Message> messageList = messagesService.getAllMessagesForUsers(id1,id2);
                                    Collections.reverse(messageList);
                                    req.setAttribute("messages", messageList);
                                    req.getRequestDispatcher("chat.ftl").forward(req, resp);
                              }
                        } else {
                              resp.sendRedirect("/profile");
                        }
                  }
            } else {
                  resp.sendRedirect("/profile");
            }
      }

      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (req.getParameter("text") != null) {
                  String q = req.getParameter("text");
                  messagesService.save(new Message(q, id1, id2, new Date().getTime(), user.getLogin()));
                  resp.sendRedirect("/chat?id="+u.getId());
            } else {
                  resp.sendRedirect("/profile?id=" + u.getId());
            }
      }
}