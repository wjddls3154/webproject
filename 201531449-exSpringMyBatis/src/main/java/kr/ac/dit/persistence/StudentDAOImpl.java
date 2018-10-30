package kr.ac.dit.persistence;
import java.sql.*;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.StudentVO;
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	//여기서부터
	@Autowired
	 SqlSession sqlSession;
	//이까지 붙여넣음 밑에 insert 내용을 사용하기위해서.
	@Override
	public void insertStudent(StudentVO studentVO) throws Exception {
		  sqlSession.insert("StudentMapper.insertStudent", studentVO);
	//insert 내용을 한줄로 축소해서 붙여넣음  
	 	 
	}
	@Override
	public List<StudentVO> selectStudentList() throws Exception {
		return sqlSession.selectList("StudentMapper.selectStudentList"); 
	}
	
}
