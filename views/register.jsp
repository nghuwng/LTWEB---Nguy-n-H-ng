<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
	<h2>Register Account</h2>
	<form class="form" action="/itwebct5/RegisterServlet" method="post">
        <c:if test="${alert !=null}">
 			<h3 class="alert alert-danger">${alert}</h3>
 		</c:if>
                
        <label for="username">Username:</label>
        <input type="text" name="username" id="username" required><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>
        
        <label for="confirmPassword">Confirm Password:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required><br>
        
        <button type="submit">Sign Up</button>
        <p>Already have an account? <a href="/itwebct5/LoginServlet">Login</a></p>       
    </form>
</body>
</html>