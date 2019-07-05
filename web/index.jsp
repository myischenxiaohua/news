<%@ page import="cn.cxh.dao.impl.NewsDaoImpl" %>
<%@ page import="cn.cxh.util.DatabaseUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.cxh.entity.News" %>
<%@ page import="cn.cxh.service.impl.NewsServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <%

    List<News> list= new NewsServiceImpl().getNewsList();
    for (News news:list){
        out.print(news.getNid());
    }
  %>
  </body>
</html>
