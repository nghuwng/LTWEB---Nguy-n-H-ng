<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>
	<h2>Login Account</h2>
	<form class="form" action="/itwebct5/LoginServlet" method="post">
		<c:if test="${alert !=null}">
 			<h3 class="alert alert-danger">${alert}</h3>
 		</c:if>
 		
  	  	<label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>
        
        <label for="remember">Remember me:</label>
        <input type="checkbox" name="remember" id="remember"><br>
        
        <button type="submit">Login</button>
        <p><a href="${pageContext.request.contextPath}/ForgotPasswordServlet">Forgot Password?</a></p>
        <p>Don't have an account? <a href="/itwebct5/RegisterServlet">Sign up</a></p>
	</form>
</body>
</html>