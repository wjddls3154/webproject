package kr.ac.dit.persistence;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import kr.ac.dit.domain.BoardVO;
@Repository
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	SqlSession sqlSession;
	@Override
	public List<BoardVO> selectList() throws Exception {
		return sqlSession.selectList("BoardMapper.selectList"); 
	}
	@Override
	public void insert(BoardVO boardVO) throws Exception {
		sqlSession.insert("BoardMapper.insert", boardVO);
	}
	@Override
	public BoardVO select(int no) throws Exception {
		return sqlSession.selectOne("BoardMapper.select", no); 
	}
	@Override
	public void update(BoardVO boardVO) throws Exception {
		sqlSession.update("BoardMapper.update", boardVO);
	}
	@Override
	public void delete(int no) throws Exception {
		sqlSession.delete("BoardMapper.delete", no); 
	}
}
