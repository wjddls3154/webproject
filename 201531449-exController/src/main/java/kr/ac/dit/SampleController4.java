package kr.ac.dit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class SampleController4 {
 private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
 @RequestMapping("urlE")
 public String urlE(RedirectAttributes rttr) {
  logger.info("urlE called but redirected to /urlF............."); //콘솔에 로그를 찍어라
  rttr.addAttribute("msg", "This is the message with redirected"); //내가 삽입한 This is the message with redirected은 msg에 저장되어 출력
  return "redirect:/urlF";  //urlF로 이동
 }
 @RequestMapping("/urlF")
 public void urlF(String msg) {
  logger.info("urlF called......" + msg);  //urlF에서 msg를 불러들여와서 보여줌
 }
}

 