<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@ page import="cn.cxh.entity.News" %>
<%@ page import="cn.cxh.service.impl.NewsServiceImpl" %>
<%@ page import="cn.cxh.util.Page" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>添加主题--管理后台</title>
    <link href="<%=request.getContextPath()%>/static/css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="welcome">欢迎使用新闻管理系统！</div>
    <div id="nav">
        <div id="logo"><img src="<%=request.getContextPath()%>/static/images/logo.jpg" alt="新闻中国" /></div>
        <div id="a_b01"><img src="<%=request.getContextPath()%>/static/images/a_b01.gif" alt="" /></div>
    </div>
</div>
<div id="admin_bar">
    <div id="status">管理员：${sessionScope.user.uName}  &#160;&#160;&#160;&#160; <a href="${pageContext.request.contextPath}/login.html?action=loginout">注销</a></div>
    <div id="channel"> </div>
</div>
<div id="main">
   <%@ include file="/view/layout/left.jsp" %>
    <div id="opt_area">
        <script type="text/javascript" >
            function clickdel(nid){
                if (confirm("此新闻的相关评论也将删除，确定删除吗？"))
                    window.location="${pageContext.request.contextPath}/new.html?action=del&nid="+nid;
            }

        </script>
        <ul class="classlist">
        <c:forEach items="${requestScope.list}" var="news" varStatus="st">
            <li><a href="${pageContext.request.contextPath}/new.html?action=show&tid=${news.nid}">${news.ntitle}</a><span> 作者：${news.nauthor} &#160;&#160;&#160;&#160;
<a href='${pageContext.request.contextPath}/new.html?action=edit&tid=${news.nid}'>修改</a> &#160;&#160;&#160;&#160;
<a href='javascript:;' onclick='return clickdel(${news.nid})'>删除</a></span> </li>
            <li class='space'></li>
        </c:forEach>
        </ul>
        <div>

            <c:if test="${pageData.currPageNo>1}">
                <a href="${pageContext.request.contextPath}/new.html?action=list&pageIndex=1">首页</a>
                <a href="${pageContext.request.contextPath}/new.html?action=list&pageIndex=${pageData.currPageNo-1}">上一页</a>
            </c:if>

            <c:forEach begin="1"  end="${pageData.totalPageCount}"   var="cc" >
                <a href="${pageContext.request.contextPath}/new.html?action=list&pageIndex=${cc}">${cc}</a>
            </c:forEach>

            <c:if test="${pageData.currPageNo<pageData.totalPageCount}">
                <a href="${pageContext.request.contextPath}/new.html?action=list&pageIndex=${pageData.currPageNo+1}">下一页</a>
                <a href="${pageContext.request.contextPath}/new.html?action=list&pageIndex=${pageData.totalPageCount}">末页</a>
            </c:if>


        </div>
    </div>
</div>
<div id="footer">
    <%-- 引入公共部分--%>
    <%@ include file="../layout/bom.jsp" %>
</div>
</body>
</html>
