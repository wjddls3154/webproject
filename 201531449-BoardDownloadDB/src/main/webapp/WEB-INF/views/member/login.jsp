<!DOCTYPE=HTML>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<form method="post" action="/member/loginPost">
			<input type="text" name="id" size="50">
			<input type="password" name="pwd" size="50">
			<input type="submit">
		</form>
		<br><a href="/member/create">REGISTER</a>
	</body>
</html>