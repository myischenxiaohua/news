<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
</head>
<body>
<%--
数据模型 mode
服务层 service
视图层 view
--%>
<form action="/user/login" method="post"  >
    <input name="user"><br/>
    <input name="pwd" type="password"><br/>
    <input type="checkbox" name="autoLogin" value="1">自动登录<br/>
    <span id="error"></span>
    <input type="button" value="登陆" onclick="btn()">

</form>

<script>


    function btn() {
        var user=$("input[name=\"user\"]").val();
        var pwd=$("input[name=\"pwd\"]").val();
        var url="${pageContext.request.contextPath}/login.html?action=login";

       // $.get(url,{uName:user,uPwd:pwd},cllback,"json");
       // $.post(url,{uName:user,uPwd:pwd},cllback,"json");
        $.getJSON(url,{uName:user,uPwd:pwd},cllback)

    }
    function cllback(rst) {
        console.log(rst);
        console.log(rst.msg);
        if (rst.status){
            //成功
            location.href="${pageContext.request.contextPath}/admin/new.html?action=list";
        } else {
            //失败
            $("#error").text(rst.msg);
        }
    }
</script>
</body>
</html>
