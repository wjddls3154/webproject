package kr.ac.dit.service;
import java.util.*;
import kr.ac.dit.domain.StudentVO;

public interface StudentService {

public void createStudent(StudentVO studentVO) throws Exception;
public List<StudentVO> readStudentList() throws Exception;

//create 부분이랑 read 부분에 사용할 거 지정


}
