<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
	<c:choose>
		<c:when test=${empty sessionScope.id }>
			<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
		</c:when>
		<c:others>
			<li><a href="${pageContext.request.contextPath}/logout">로그아웃</a></li>
		</c:others>
	</c:choose>
	<li><a href="${pageContext.request.contextPath}/insert">회원가입</a></li>
	<li><a href="${pageContext.request.contextPath}/list">회원목록</a></li>
</ul>
</body>
</html>