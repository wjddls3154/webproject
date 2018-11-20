package kr.ac.dit.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.persistence.BoardDAO;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	public List<BoardVO> listArticle() throws Exception {
		return boardDAO.selectList();
	}
	public void createArticle(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
		 MultipartFile[] uploadFile = boardVO.getUploadFile();
		  if (uploadFile != null) {
		   for (MultipartFile eachFile : uploadFile) {
		    String fileName = eachFile.getOriginalFilename();
		    boardDAO.insertAttachFile(fileName);
		   }
		  }
	}
	public BoardVO readArticle(int no) throws Exception {
		return boardDAO.select(no);
	}
	public void updateArticle(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}
	public void deleteArticle(int no) throws Exception {
		boardDAO.delete(no);
	}
	@Override
	 public List<String> readAttachFile(int no) throws Exception {
		  return boardDAO.selectAttachFile(no);
		 }
}
