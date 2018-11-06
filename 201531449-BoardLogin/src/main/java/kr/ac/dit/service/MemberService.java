package kr.ac.dit.service;
import kr.ac.dit.domain.LoginDTO;
import kr.ac.dit.domain.MemberVO;
public interface MemberService {
	 public void createMember(MemberVO memberVO) throws Exception;

	  public MemberVO readMember(LoginDTO loginDTO) throws Exception;
}
