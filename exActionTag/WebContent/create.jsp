<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>

<jsp:useBean id="item" scope="page" class="exActionTag.studentVO"> <!--studentVO에 대한 usebean  -->

 <jsp:setProperty name="item" property="no"/>
 <jsp:setProperty name="item" property="name"/>
 <!--<jsp:setProperty name="item" property="*"/> 앞에거처럼하면 하나만 부를수도 잇고 *하면 모두를 부름 -->
</jsp:useBean>
<jsp:useBean id="dao" scope="page" class="exActionTag.studentDAO"/> <!-- studentDAO에 대한 usebean -->
</html>
 <%
  request.setCharacterEncoding("UTF-8");
  dao.insertStudent(item);
  response.sendRedirect("read.jsp");
 %>
