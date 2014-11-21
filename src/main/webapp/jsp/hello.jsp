<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<span>This is my JSP page.
	<c:out value="${name}" /></span>
	<div>
		List example:
		<ul>
			<c:choose>
				<c:when test="${list != null}">
					<c:forEach items="${list}" var="curr" varStatus="status">
						<li>${status.index}:${curr}</li>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<li>被重定向后的网页不包括Request的数据</li>
				</c:otherwise>
			</c:choose>

		</ul>

		Session数据： <span><c:out value="${sessionScope.sessionObj}" /></span>
			
			
		
	</div>

	<div></div>
	<br>
</body>
</html>
