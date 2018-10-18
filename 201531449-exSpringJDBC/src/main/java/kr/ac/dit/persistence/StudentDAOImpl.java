package kr.ac.dit.persistence;
import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.StudentVO;
@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void insertStudent(StudentVO studentVO) throws Exception {
		  jdbcTemplate.update("insert into student values(?,?)", studentVO.getNo(), studentVO.getName());
	}
	@Override
	public List<StudentVO> selectStudentList() throws Exception {
		List<StudentVO> items = new ArrayList<StudentVO>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from student"); 
	    for (@SuppressWarnings("rawtypes") Map row : rows) { 
	      StudentVO item = new StudentVO(); 
	      item.setNo((String) row.get("no")); 
	      item.setName((String) row.get("name")); 
	      items.add(item); 
	    } 
		return items;
	}
}
