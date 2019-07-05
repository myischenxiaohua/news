<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/26
  Time: 9:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<%@include file="/view/layout/top.jsp" %>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/view/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/view/ueditor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/view/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">

    function check() {
        var tname=document.getElementById("tname");
       if(tname.value==""){
           document.getElementById("msg").innerText("主题不能为空");
           document.getElementById("msg").style="color:red";
       }
    }

</script>

<div id="main">
    <%@include file="/view/layout/left.jsp" %>
    <div id="opt_area">
        <h1 id="opt_type"> 新增主题： </h1>
        <form  action="${pageContext.request.contextPath}/topic.html?action=save"  method="post" onsubmit="return check()">

            <p>
                <label> 主题名称 </label>
                <input name="tname" type="text" class="opt_input" id="tname"/><span id="msg"></span>
            </p>

            <input type="submit"  value="提交" class="opt_sub" />
            <input type="reset" value="重置" class="opt_sub" />
        </form>

    </div>
</div>

<%@ include file="../../layout/bom.jsp" %>
