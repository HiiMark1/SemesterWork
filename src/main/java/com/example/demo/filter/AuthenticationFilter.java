package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = "/profile")
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
            if (session == null && !uri.contains("username")) {
                  response.sendRedirect("login.html");
            } else {
                  filterChain.doFilter(servletRequest, servletResponse);
            }
      }

      @Override
      public void destroy() {
      }
}