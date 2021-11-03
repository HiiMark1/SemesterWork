package ru.kpfu.itis.vagaviev.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/profile", "/upload", "/settings", "/new_post", "/edit_post", "/report"})
public class AuthenticationFilter implements Filter {
      @Override
      public void init(FilterConfig filterConfig) {
      }

      @Override
      public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
              throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            String uri = request.getRequestURI();
            HttpSession session = request.getSession(false);

            Cookie[] cookies = request.getCookies();
            String login = null;
            if (session == null && !uri.contains("login")) {
                  if (cookies == null) {
                        response.sendRedirect("/login");
                  } else {
                        for (Cookie cookie : cookies) {
                              if (cookie.getName().equals("login")) {
                                    login = cookie.getValue();
                                    break;
                              }
                        }
                        if (login != null) {
                              session = request.getSession();
                              session.setAttribute("login", login);
                              session.setMaxInactiveInterval(2 * 60 * 60);
                              filterChain.doFilter(servletRequest, servletResponse);
                        } else {
                              response.sendRedirect("/login");
                        }
                  }
            } else {
                  filterChain.doFilter(servletRequest, servletResponse);
            }
      }

      @Override
      public void destroy() {
      }
}