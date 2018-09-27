package exActionTag;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import exActionTag.studentVO;
 public class studentDAO {
  public void insertStudent(studentVO item) throws Exception {
   String no = item.getNo();
   String name = item.getName();


   Class.forName("oracle.jdbc.driver.OracleDriver");
   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201531449","201531449");

 

  PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");
   pstmt.setString(1,no);
   pstmt.setString(2,name);
   pstmt.executeUpdate();

  pstmt.close();
  conn.close();
  }
  
  public List<studentVO> selectStudent() throws Exception{
		 List<studentVO> sList = new ArrayList<studentVO>();

		 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201531449","201531449"); 
		 PreparedStatement sql = conn.prepareStatement("select * from student"); //select한다 student를
		 ResultSet rs = sql.executeQuery();
		 while(rs.next()) {
			 studentVO item = new studentVO();
			 item.setNo(rs.getString("no"));       //no부분 select
			 item.setName(rs.getString("name"));   //no부분 select
			 sList.add(item);
		 }
		 return sList;
	 }
 }
