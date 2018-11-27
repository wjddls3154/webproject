package kr.ac.dit.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.ac.dit.domain.BoardVO;
import kr.ac.dit.domain.UploadFileVO;
import kr.ac.dit.persistence.BoardDAO;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	 @Override

	 public List<BoardVO> listArticle(int page) throws Exception {

	  int start = (page - 1) * 10; // 페이징 의 조건절에 사용되는 시작 rownum

	  return boardDAO.selectList(start, start+10);

	 } 

	public void createArticle(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
	}
	public BoardVO readArticle(int no) throws Exception {
		return boardDAO.select(no);
	}
	
	@Override

	public List<UploadFileVO> readAttachFile(int no) {

	return boardDAO.selectAttachFile(no);

	}
	
	public void updateArticle(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}
	public void deleteArticle(int no) throws Exception {
		boardDAO.delete(no);
	}
	@Override
	public void uploadFile(UploadFileVO uploadFileVO) {
		uploadFileVO.setFileId(boardDAO.selectMaxFileId()+1); 
		boardDAO.insertFile(uploadFileVO);
		
	}
	@Override

	public UploadFileVO downloadFile(int fileId) {

	return boardDAO.selectDownloadFile(fileId);

	}

	@Override
	public int selectTotalArticleCount() {
		// TODO Auto-generated method stub
		return boardDAO.selectTotalArticleCount();
	}
}
