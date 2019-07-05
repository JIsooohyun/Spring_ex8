package com.sh.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sh.board.BoardDAO;
import com.sh.board.BoardDTO;
import com.sh.util.PagerMaker;

@Repository
public class QnaDAO implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="QnaMapper.";
	
	@Override
	public List<BoardDTO> getList(PagerMaker pagerMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+"getList", pagerMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getSelect", num);
	}

	@Override
	public int setDelete(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE+"setDelete", num);
	}

	@Override
	public int getTotalCount(PagerMaker pagerMaker) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"totalCount", pagerMaker);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setWrite(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"setWrite", boardDTO);
	}
	
	public int setComments(BoardDTO boardDTO)throws Exception{
		int result = sqlSession.insert(NAMESPACE+"setComments", boardDTO);
		return result;
	}

}
