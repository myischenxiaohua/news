<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/1
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--设置值--%>
<c:set property="" target="" value="123" var="zs"></c:set>
<%--获取值--%>
<c:out value="dfsfdsgf"/>
${zs}
<c:if test="${1==2}" var="ts" scope="page">
    1==2成立${ts}
</c:if>
<c:if test="${!(1==2)}" var="ts" scope="page">
    1==2不成立
    ${ts}
</c:if>

<c:set var="zs" value="1" scope="page"></c:set>

<c:choose>
    <c:when test="${zs==1}">
        性别：男
    </c:when>
    <c:when test="${zs==2}">
        性别：中性
    </c:when>
    <c:otherwise>
        性别：女
    </c:otherwise>
</c:choose>


</body>
</html>
