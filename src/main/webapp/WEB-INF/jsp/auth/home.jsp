<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
			<!--  Global error message appear here -->
			<c:if test="${not empty errorMessage}">
				<div>
					${errorMessage}
				</div>
			</c:if>
			<c:if test="${not empty successMessage}">
				<div>
					${successMessage}
				</div>
			</c:if>
			
		<form method="POST" action="/auth/saveUser.do">
			<label for="email">Email</label>
			<input type="text" name="email" value="${userDto.email}"/> 
			<!--  Individual validation errors appear next to the field -->
			<c:if test="${not empty errors['email']}">
				<div>${errors['email']}</div>
			</c:if>		
			<br/>
			<label for="firstName">First Name</label>
			<input type="text" name="firstName" value="${userDto.firstName}"/>
			<!--  Individual validation errors appear next to the field -->
			<c:if test="${not empty errors['firstName']}">
				<div>${errors['firstName']}</div>
			</c:if>		
			<br/>
			<label for="lastName">Last Name</label>
			<input type="text" name="lastName" value="${userDto.lastName}"/>
			<!--  Individual validation errors appear next to the field -->
			<c:if test="${not empty errors['lastName']}">
				<div>${errors['lastName']}</div>
			</c:if>	
			<br/>
			<c:if test="${not null loggedInUser.userAttachment}">
				Click <a href="/auth/fetchAttachment.do?attachmentId=${userDto.userAttachment.id}">here</a> to download current attachment.
			</c:if>
			Add User Attachment : <input type="file" name="userAttachment"/><br/>
			<c:if test="${not empty errors['file']}">
				<div>${errors['file']}</div>
			</c:if>	
		</form>
	</body>
</html>