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

<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>

<div id="main">
    <%@include file="/view/layout/left.jsp" %>
    <div id="opt_area">
        <ul class="classlist">
            <c:forEach items="${requestScope.topics}" var="topic">
            <li> &#160;&#160;&#160;&#160; ${topic.tname} &#160;&#160;&#160;&#160; <a href='../newspages/topic_modify.jsp?tid=${topic.tid}&tname=${topic.tname}'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/topics?opr=del&tid=${topic.tid}'>删除</a> </li>
        </c:forEach>
        </ul>
    </div>
</div>

<script>
    <%--var url="${pageContext.request.contextPath}/topic.html"--%>
    <%--$.getJSON(url,{action:"ajaxList"},cabck);--%>
    <%--function cabck(rst) {--%>
    <%--    console.log(rst);--%>
    <%--    var li="";--%>
    <%--    for (var topic of rst){--%>
    <%--        li+=" <li> &#160;&#160;&#160;&#160; "+topic.tname+" &#160;&#160;&#160;&#160; <a href='../newspages/topic_modify.jsp?tid="+topic.tid+"&tname="+topic.tname+"'>修改</a> &#160;&#160;&#160;&#160; <a href='../util/topics?opr=del&tid="+topic.tid+"'>删除</a> </li>"--%>
    <%--    }--%>
    <%--    $(".classlist").html(li);--%>
    <%--}--%>
    var url="${pageContext.request.contextPath}/topic.html";
    $(".classlist").load(url,{action:"loadList"});
    $.param();
    var df=jQuery.noConflict(); //自定义操作符
   console.log(df(".classlist"));
</script>

<%@ include file="../../layout/bom.jsp" %>
