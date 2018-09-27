<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "exActionTag.studentVO" %>  <!-- studentVO를 정의하기위해 사용 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<jsp:useBean id="item" scope="page" class="exActionTag.studentVO"/>  <!-- usebean 사용 -->
<jsp:useBean id="dao" scope="page" class="exActionTag.studentDAO"/>
<%
 request.setCharacterEncoding("UTF-8");

 List<studentVO> items = new ArrayList<studentVO>();

 items = dao.selectStudent();     
%>
<!-- dao의 selectstudent 부분 사용 -->

<body>
<%
 for(int i=0;i<items.size();i++) {

  item = items.get(i);
%>
<!-- for 반복문 사용 -->
  <%=item.getNo()%>

  <%=item.getName()%><BR>

 <%}%>
</body>
</html>

