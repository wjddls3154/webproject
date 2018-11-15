<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		${boardVO.no}
		${boardVO.writer}
		${boardVO.title}
		${boardVO.content}
		${boardVO.createDate}
		${boardVO.readCount}
		<br>
		<a href='<c:url value="/board/list"/>'>LIST</a>|
		<c:if test="${login.id==boardVO.writer}">
			<a href='<c:url value="/board/update?no=${boardVO.no}"/>'>UPDATE</a>|
			<a href='<c:url value="/board/delete?no=${boardVO.no}"/>'>DELETE</a>
		</c:if>
	</body>
</html>