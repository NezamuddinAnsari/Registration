<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Registration</h2>
	<form action="saveReg" method="post">
		<pre>
		First Name <input type ="text" name="firstName"/>
		Last Name <input type ="text" name="lastName"/>
		Email <input type="text" name="email"/> 
		Mobile Number<input type="text" name="mobile"/>
		<input type="submit" value="save"/>
		</pre>
	</form>
	${msg}
</body>
</html>