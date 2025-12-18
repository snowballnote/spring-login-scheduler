<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>login</h1>
	<img src="${pageContext.request.contextPath}/upload/image.png"><!-- d:/app/upload : 외부정적 저장소맵핑 -->
	<form method="post" action="${pageContext.request.contextPath}/login">
		<table border="1">
			<tr>
				<td>username</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<button>로그인</button>
	</form>
</body>
</html>