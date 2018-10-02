package kr.ac.dit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
 //urlB 주소로 들어가면 view파일로 리턴해준다.
public class SampleController2 {
  @RequestMapping("urlB")
  public String urlBget() {
	  return "view";
  }
  //http://localhost:8090/dit/urlC?msg=hi 이런식으로 메시지 줄수있다.
  @RequestMapping("urlC") 
  public String urlCget(@ModelAttribute("msg") String msg) {
	  return "view";
  }
}
