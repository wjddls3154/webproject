<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
		<c:forEach var="item" items="${items}">
			   ${boardVO.writer}
   ${boardVO.createDate}
   ${boardVO.title}
   ${boardVO.content}

   <br>
   <a href='<c:url value="/board/list"/>'>LIST</a>|
   <a href='<c:url value="/board/update?no=${boardVO.no}"/>'>UPDATE</a>|
   <a href='<c:url value="/board/delete?no=${boardVO.no}"/>'>DELETE</a>


		</c:forEach>
	</body>
</html>