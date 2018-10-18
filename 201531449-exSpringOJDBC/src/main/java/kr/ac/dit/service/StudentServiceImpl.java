package kr.ac.dit.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

import kr.ac.dit.domain.StudentVO;

import kr.ac.dit.persistence.StudentDAO;

@Service

public class StudentServiceImpl implements StudentService {

@Autowired

private StudentDAO studentDAO;

public void createStudent(StudentVO studentVO) throws Exception {

studentDAO.insertStudent(studentVO);

//create.jsp의 insert 사용

}

public List<StudentVO> readStudentList() throws Exception { 
  		return studentDAO.selectStudentList(); 
  	} 

//read.jsp의 select 사용


}

 
