package exBean;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

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
  
//mysql insert문을 사용하여 student라는 테이블에있는 no와 name이라는 데이터들을 삽입한다.  
 
 

 public List<studentVO> select() throws Exception{
	 List<studentVO> sList = new ArrayList<studentVO>();

	 Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201531449","201531449");
	 PreparedStatement sql = conn.prepareStatement("select * from student");
	 ResultSet rs = sql.executeQuery();
	 while(rs.next()) {
		 studentVO item = new studentVO();
		 item.setNo(rs.getString("no"));
		 item.setName(rs.getString("name"));
		 sList.add(item);
	 }
	 return sList;
 }

}
 // mysql select문을 사용하여 student라는 테이블에있는 no와 name이라는 데이터들을 가져온다.  
 // 가져온 값을 item에 저장하여 sList에 추가한다.