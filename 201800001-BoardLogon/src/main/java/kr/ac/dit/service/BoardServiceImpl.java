package kr.ac.dit.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
