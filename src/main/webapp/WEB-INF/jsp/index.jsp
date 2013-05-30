<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Login</title>
	</head>
	<body>
			<!--  Global error message appear here -->
			<c:if test="${not empty errorMessage}">
				<div>
					${errorMessage}
				</div>
			</c:if>
		<form method="POST" action="/login.do">
			<label for="email">Email</label>
			<input type="text" name="email"/> 
			<!--  Individual validation errors appear next to the field -->
			<c:if test="${not empty errors['email']}">
				<div>${errors['email']}</div>
			</c:if>		
			<br/>
			<label for="password">Password</label>
			<input type="password" name="password"/>
			<!--  Individual validation errors appear next to the field -->
			<c:if test="${not empty errors['password']}">
				<div>${errors['password']}</div>
			</c:if>		
		</form>
	</body>
</html>