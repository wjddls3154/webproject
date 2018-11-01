package kr.ac.dit.service;
import java.util.*;
import kr.ac.dit.domain.BoardVO;
public interface BoardService {
	public List<BoardVO> listArticle() throws Exception;

	  public void createArticle(BoardVO boardVO) throws Exception;

	  public BoardVO readArticle(int no) throws Exception;

	  public void updateArticle(BoardVO boardVO) throws Exception;

	  public void deleteArticle(int no) throws Exception;
}
