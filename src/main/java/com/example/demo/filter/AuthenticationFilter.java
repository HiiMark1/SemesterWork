package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter(filterName = "authenticationFilter", urlPatterns = {"/profile", "/upload", "/settings", "/new_post"})
public class AuthenticationFilter implements Filter {
      @Override
      public void init(FilterConfig filterConfig) {
      }

      @Override
      public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
              throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            Cookie[] cookies = request.getCookies();
            boolean flag = false;
            if(cookies!=null){
                  for(Cookie cookie: cookies){
                        if(cookie.getName().equals("login")){
                              flag = true;
                              break;
                        }
                  }
            }

            String uri = request.getRequestURI();
            HttpSession session = request.getSession(false);
            if (session == null && !uri.contains("login")) {
                  if(flag){
                        filterChain.doFilter(servletRequest, servletResponse);
                  } else{
                        response.sendRedirect("/login");
                  }
            } else {
                  filterChain.doFilter(servletRequest, servletResponse);
            }
      }

      @Override
      public void destroy() {
      }
}