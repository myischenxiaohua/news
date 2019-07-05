package cn.cxh.filter;/*
  Created by IntelliJ IDEA.
  Package: cn.cxh.filter
  User: myischenxiaohua@163.com
  Date: 2019/7/4
  Time: 14:16
*/

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         this.encoding=filterConfig.getInitParameter("en");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                    servletRequest.setCharacterEncoding(this.encoding);
                    servletResponse.setCharacterEncoding(this.encoding);
                    servletResponse.setContentType("text/html;charset=utf-8");
                    filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    @Override
    public void destroy() {

    }
}
