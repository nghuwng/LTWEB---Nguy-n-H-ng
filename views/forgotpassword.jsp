<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Quên Mật Khẩu</h2>
    <c:if test="${not empty alert}">
        <div>${alert}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/ForgotPasswordServlet" method="post">
        <input type="email" name="email" required placeholder="Nhập email của bạn">
        <button type="submit">Tạo liên kết đặt lại mật khẩu</button>
    </form>
</body>
</html>