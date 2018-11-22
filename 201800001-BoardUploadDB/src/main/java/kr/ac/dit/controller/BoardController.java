package kr.ac.dit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		boardService.createArticle(boardVO);
		UploadFileVO uploadFileVO = new UploadFileVO();
		MultipartFile[] uploadFile = boardVO.getUploadFile();
		if (uploadFile != null) {
			for (MultipartFile eachFile : uploadFile) {
				uploadFileVO.setFileName(eachFile.getOriginalFilename());
				uploadFileVO.setFileData(eachFile.getBytes());
				boardService.uploadFile(uploadFileVO);
			}
		}

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

	@RequestMapping(value = "/download/{fileId}", method = RequestMethod.GET)

	public ResponseEntity<byte[]> download(@PathVariable int fileId) throws Exception {

		UploadFileVO downloadFile = boardService.downloadFile(fileId);

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

		httpHeaders.setContentDispositionFormData("attachment", downloadFile.getFileName());

		return new ResponseEntity<byte[]>(downloadFile.getFileData(), httpHeaders, HttpStatus.OK);

	}
}