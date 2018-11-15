package kr.ac.dit.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.UploadFileVO;
import kr.ac.dit.service.BoardService;
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	@RequestMapping("/board/list")
	public void listGET(Model model) throws Exception {
		model.addAttribute("items", boardService.listArticle());
	}
	@RequestMapping(value = "/board/create", method = RequestMethod.GET)
	public void createGET() throws Exception {
	}
	@RequestMapping(value = "/board/createPost", method = RequestMethod.POST)
	public String createPOST(BoardVO boardVO) throws Exception {
		 UploadFileVO uploadFileVO = new UploadFileVO();
		  MultipartFile uploadFile = boardVO.getUploadFile();
		  if (!uploadFile.isEmpty()) {
		   uploadFileVO.setFileName(uploadFile.getOriginalFilename());
		   uploadFileVO.setFileData(uploadFile.getBytes());
		   boardService.uploadFile(uploadFileVO);
		  }
		boardService.createArticle(boardVO);
		return "redirect:/board/list";
	}
	@RequestMapping("/board/read")
	public void readGET(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute(boardService.readArticle(no));
	}
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public void updateGET(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute(boardService.readArticle(no));
	}
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String updatePOST(BoardVO boardVO) throws Exception {
		boardService.updateArticle(boardVO);
		return "redirect:/board/list";
	}
	@RequestMapping(value = "/board/delete", method = RequestMethod.GET)
	public String deleteGET(@RequestParam("no") int no) throws Exception {
		boardService.deleteArticle(no);
		return "redirect:/board/list";
	}
}