package kr.ac.dit.persistence;
import java.util.*;
import kr.ac.dit.domain.StudentVO;

public interface StudentDAO {

public void insertStudent(StudentVO studentVO) throws Exception;

public List<StudentVO> selectStudentList() throws Exception;

// create부분은 insert 사용 read부분은 select 사용


}
