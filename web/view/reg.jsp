<%@ page import="java.util.Objects" %>
<%@ page import="cn.cxh.entity.User" %>
<%@ page import="cn.cxh.service.UserService" %>
<%@ page import="cn.cxh.service.impl.UserServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
</head>
<body>


<form action="reg.jsp" method="post" >
    用户名：<input name="user"><span id="userError"></span><br/>
    密码：<input type="password" name="pwd">
    <input type="submit" value="注册">
</form>

<div id="box1"></div>
<table id="tb" border="1">

</table>
<script>

  // //创建异步请求对象
  // xmlHttpRequest=new xmlHttpRequest;
  // xmlHttpRequest.onreadystatechange=res;
  // var url="http://localhost:808/newsweb/user.html?action=cheackUser&uName="+user;
  // xmlHttpRequest.open("get",url,true);
  // xmlHttpRequest.send();
  //
  //
  //     function res() {
  //         if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200){
  //                   var data=xmlHttpRequest.responseText;
  //                   console.log(data);
  //                   if(data){
  //
  //                   }
  //         }
  //
  //     }
  $("input[name=\"user\"]").blur(function () {

      var user= $("input[name=\"user\"]").val();
      $.ajax({
          url:"http://localhost:808/newsweb/user.html?action=cheackUser", //请求的地址
          type:"get", //请求的方式
          data:{uName:user},//请求的数据
          dataType:"json",//响应的数据类型
          beforeSend:function(){}, //发送请求之前
          success:function (rst) { //请求成功后执行
              if(rst.status){
                  $("#userError").text(rst.msg);
              }else {
                  $("#userError").text(rst.msg);
              }
              console.log(rst);//请求成功之后
          },
          error:function (er) {
              console.log(er);//请求失败

          }

      })


  })



    var zs={name:"张三",age:18,gender:"男"};

    $("#box1").append("姓名:"+zs.name);
    $("#box1").append("年龄:"+zs.age);
    $("#box1").append("性别:"+zs.gender);

    var zss=[
        {name:"张三",age:18,gender:"男"},
        {name:"李四",age:19,gender:"男"},
        {name:"王五",age:20,gender:"女"}
        ]


    for (var persion in zss) {
        console.log(zss[persion]);
    }

    var trs="";
    for (var p of zss){ //p是每次循环得到的对象
        trs+="<tr>" +
            "<td>"+p.name+"</td>" +
            "<td>"+p.age+"</td>" +
            "<td>"+p.gender+"</td>" +
            "</tr>"
    }

    $("#tb").html(trs);
</script>


</body>
</html>
