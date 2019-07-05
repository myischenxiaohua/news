    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <div class="sidebar">
        <h1> <img src="${pageContext.request.contextPath}/static/images/title_1.gif" alt="国内新闻" /> </h1>
        <div class="side_list">
        <ul>
        <c:forEach items="${news}" var="news">
            <li><a href='${pageContext.request.contextPath}/new.html?action=show&tid=${news.nid}'><b>${news.ntitle}</b></a></li>
        </c:forEach>
        </ul>
        </div>
        <h1> <img src="${pageContext.request.contextPath}/static/images/title_2.gif" alt="国际新闻" /> </h1>
        <div class="side_list">
        <ul>
        <c:forEach items="${tNews}" var="news">
            <li><a href='${pageContext.request.contextPath}/new.html?action=show&tid=${news.nid}'><b>${news.ntitle}</b></a></li>
        </c:forEach>
        </ul>
        </div>
        <h1> <img src="${pageContext.request.contextPath}/static/images/title_3.gif" alt="娱乐新闻" /> </h1>
        <div class="side_list">
        <ul>
        <c:forEach items="${hNews}" var="news">
            <li><a href='${pageContext.request.contextPath}/new.html?action=show&tid=${news.nid}'><b>${news.ntitle}</b></a></li>
        </c:forEach>
        </ul>
        </div>
        </div>