package kr.ac.dit.persistence;
import kr.ac.dit.domain.LoginDTO;
import kr.ac.dit.domain.MemberVO;
public interface MemberDAO {
	 public void insert(MemberVO memberVO) throws Exception;

	  public MemberVO select(LoginDTO loginDTO) throws Exception;
}
