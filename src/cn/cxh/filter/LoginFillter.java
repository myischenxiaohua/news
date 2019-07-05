package cn.cxh.filter;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.filter
  User: myischenxiaohua@163.com
  Date: 2019/7/4
  Time: 14:11
*/


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class LoginFillter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest request= (HttpServletRequest) servletRequest;
            HttpServletResponse response=(HttpServletResponse) servletResponse;
          if(Objects.nonNull( request.getSession().getAttribute("user"))) { //判断session中的登陆是设置的属性是否存在
              filterChain.doFilter(servletRequest,servletResponse);//放行
          }else {
                response.sendRedirect(request.getContextPath()+"/view/login.jsp");
          }
    }

    @Override
    public void destroy() {

    }
}
