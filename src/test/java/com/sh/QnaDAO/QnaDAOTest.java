package com.sh.QnaDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.sh.board.BoardDTO;
import com.sh.board.qna.QnaDAO;
import com.sh.board.qna.QnaDTO;
import com.sh.s8.Abstract;
import com.sh.util.PagerMaker;

public class QnaDAOTest extends Abstract{

	@Inject
	private QnaDAO qnaDAO;
	
	@Inject
	private PagerMaker pagerMaker;
	@Test
	public void setWrite() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("title");
		qnaDTO.setWriter("writer");
		qnaDTO.setContents("contents12341234");
		
		int result = qnaDAO.setWrite(qnaDTO);
		assertEquals(1, result);
	}
	@Test
	public void getList()throws Exception{
		List<BoardDTO> ar =  qnaDAO.getList(pagerMaker);
		assertNotEquals(null, ar);
	}
}
