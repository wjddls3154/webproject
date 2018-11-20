package kr.ac.dit.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.dit.domain.BoardVO;
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
		MultipartFile[] uploadFile = boardVO.getUploadFile();
		  for (MultipartFile eachFile : uploadFile) {
		   String fileName = eachFile.getOriginalFilename();
		   eachFile.transferTo(new File("c:/upload/" + fileName));
		  }
		boardService.createArticle(boardVO);
		return "redirect:/board/list";
	}
	@RequestMapping("/board/read")
	public void readGET(@RequestParam("no") int no, Model model) throws Exception {
		model.addAttribute(boardService.readArticle(no));
		model.addAttribute("items", boardService.readAttachFile(no));
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
	
	 @ResponseBody
	 @RequestMapping("/download")
	 public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) throws Exception {
	  ResponseEntity<byte[]> responseEntity = null;
	  InputStream inputStream = null;
	  try {
	   HttpHeaders httpHeaders = new HttpHeaders();
	   inputStream = new FileInputStream("c:/upload/"+fileName);
	   httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	   httpHeaders.add("Content-Disposition", "attatchment; filename=\"" +
	     new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

	   responseEntity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream), httpHeaders, HttpStatus.CREATED);
	  } catch(Exception e) {
	   e.printStackTrace();
	  } finally {
	   inputStream.close();
	  }
	  return responseEntity;
	 }
	
}