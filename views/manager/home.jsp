<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	trang chủ của manager 
	<form action="${pageContext.request.contextPath}/LogoutServlet" method="get">
    	<button type="submit">Logout</button>
	</form>
</body>
</html>