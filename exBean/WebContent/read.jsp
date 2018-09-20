
  <%@ page import = "java.util.*" %>
 <%@ page import = "exBean.studentDAO" %>
 <%@ page import = "exBean.studentVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
 <body>
   <%



  List<studentVO> sList = new ArrayList<studentVO>();
    studentDAO search = new studentDAO();
  sList = search.select();
 %>
 <%
 	for(int i=0; i<sList.size(); i++){
 		studentVO vd = (studentVO)sList.get(i);
 	%>
 	<%= vd.getNo()%>
 	<%= vd.getName()%><br>
 	<%}
 %>
 </body>
 </html>

