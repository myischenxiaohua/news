<%@ page import="cn.cxh.entity.User" %>
<%@ page import="cn.cxh.util.ConfigManager" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/22
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
pageContext.setAttribute("zs","zhangsan");

Cookie cookieUser=new Cookie("user","张三");
Cookie cookiePwd=new Cookie("pwd","123");
    cookiePwd.setMaxAge(60);
    response.addCookie(cookieUser);
    response.addCookie(cookiePwd);


   Cookie[] cookies=request.getCookies();

//   for (Cookie cookie:cookies){
//       out.print("cookie:"+cookie.getValue()+"<br/>");
//   }




%>
<%=pageContext.getAttribute("zs")%>
<%=application.getRealPath("/user.jsp")%>
user用户页面


<%

    User user=new User();
    user.setId(1);
    user.setuName("张三");
    user.setuPwd("123");
    user.setRole(0);
  out.print(ConfigManager.getProperties("driver"));



%>

</body>
</html>
