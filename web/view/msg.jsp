<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%     request.setCharacterEncoding("utf-8");

%>

<html>
<head>
    <title>提示信息</title>
</head>
<body>
<div
    ${requestScope.msg}
</div>
</body>
</html>
