package kr.ac.dit.persistence;
import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.StudentVO;
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//여기서부터
	@Autowired
	JdbcTemplate jdbcTemplate;
	//이까지 붙여넣음 밑에 insert 내용을 사용하기위해서.
	@Override
	public void insertStudent(StudentVO studentVO) throws Exception {
		  jdbcTemplate.update("insert into student values(?,?)", studentVO.getNo(), studentVO.getName());
	//insert 내용을 한줄로 축소해서 붙여넣음  
	 	 
	}
	@Override
	public List<StudentVO> selectStudentList() throws Exception {
		List<StudentVO> items = new ArrayList<StudentVO>();
		
		//이부분부터
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from student"); 
	    for (@SuppressWarnings("rawtypes") Map row : rows) { 
	      StudentVO item = new StudentVO(); 
	      item.setNo((String) row.get("no")); 
	      item.setName((String) row.get("name")); 
	      items.add(item); 
	    } 
	    //이부분까지 복사하고 붙여넣고 List<Map<String, Object>> 의 map에 갓다대서 suppresswarnings를 설정
	    //실행에는 문제없으나 warning을 없애려고 suppresswarnings를 설정한것임.
	    
		return items;
	}
}
