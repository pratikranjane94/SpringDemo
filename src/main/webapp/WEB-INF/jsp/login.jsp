<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="login" method=get >
<label>User Name</label></br>
<input type="text" name="username"></br>
<label>Password</label></br>
<input type="text" name="password"></br>
<input type="submit" value="Login"> 
</form> -->
	<form:form action="login" commandName="validate" method="get">
		<h3>Username</h3>
		<%-- <form:input path="username" /> --%>
		<input type="text" name="username">
		<form:errors path="username" />
		<h1>login page</h1>
		<%-- <form:password path="password" /> --%>
		<input type="text" name="password">
		<form:errors path="password" />
		<br>

		<input type="submit" value="Login">

	</form:form>
</body>
</html>