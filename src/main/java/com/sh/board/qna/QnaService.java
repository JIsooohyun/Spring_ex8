package com.sh.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sh.board.BoardDTO;
import com.sh.board.BoardService;
import com.sh.file.FileDAO;
import com.sh.file.FileDTO;
import com.sh.util.FileSaver;
import com.sh.util.PagerMaker;

@Service
public class QnaService implements BoardService{
	
	@Inject
	private QnaDAO qnaDAO;
	
	@Inject
	private FileSaver fileSaver;
	
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public List<BoardDTO> getList(PagerMaker pagerMaker) throws Exception {
		pagerMaker.makeRow();
		int totalCount = qnaDAO.getTotalCount(pagerMaker);
		pagerMaker.makePage(totalCount);
		// TODO Auto-generated method stub
		return qnaDAO.getList(pagerMaker);
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		BoardDTO boardDTO = qnaDAO.getSelect(num);
		return boardDTO;
	}

	@Override
	public int setDelete(int num) throws Exception {
		int result = qnaDAO.setDelete(num);
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.setUpdate(boardDTO);
		return result;
	}

	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles,HttpSession session ) throws Exception {
		int result = qnaDAO.setWrite(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile multipartFile : multipartFiles) {
			String fname = fileSaver.fileSaver(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			files.add(fileDTO);
		}
		System.out.println(files.size());
		fileDAO.setWrite(files);
		
		return result;
	}
	
	public int setComments(BoardDTO boardDTO, HttpSession session, List<MultipartFile> multipartFiles)throws Exception{
		int result = qnaDAO.setComments(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/upload");
		System.out.println("realPath : "+realPath);
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile multipartFile:multipartFiles) {
			String fname = fileSaver.fileSaver(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			files.add(fileDTO);
		}
		
		System.out.println(files.size());
		fileDAO.setWrite(files);
		return result;
	}

}
