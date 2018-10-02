package kr.ac.dit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.dit.domain.StudentVO;

@Controller
public class SampleController3 {

	@RequestMapping("urlD") 
	public String urlD(Model model) {
		StudentVO studentVO = new StudentVO();
		studentVO.setNo("201531449");
		studentVO.setName("in kyo");
		model.addAttribute(studentVO);
		return "read";
	}
}
