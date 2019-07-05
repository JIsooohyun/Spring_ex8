package com.sh.s8;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sh.board.BoardDTO;
import com.sh.board.qna.QnaDTO;
import com.sh.board.qna.QnaService;
import com.sh.file.FileDAO;
import com.sh.util.PagerMaker;

@Controller
@RequestMapping("/qna/")
public class QnaController {

	@Inject
	private QnaService qnaService;
	@Inject
	private FileDAO fileDAO;
	//------------------------------------------------------------
	@RequestMapping(value="qnaComments", method = RequestMethod.GET)
	public String qnaCommnets(Model model, int num)throws Exception{
		QnaDTO qnaDTO = (QnaDTO)qnaService.getSelect(num);
		model.addAttribute("boardDTO", qnaDTO);
		model.addAttribute("board", "qna");
		return "board/boardComments";
	}
	
	@RequestMapping(value="qnaComments", method = RequestMethod.POST)
	public String qnaCommnets(Model model, QnaDTO qnaDTO, HttpSession session, List<MultipartFile> multipartFiles)throws Exception{
		String view="common/messageMove";
		int result = qnaService.setComments(qnaDTO, session, multipartFiles);
		if(result>0) {
			model.addAttribute("path", "qnaList");
			model.addAttribute("message", "Write Success");
		}else {
			model.addAttribute("path", "qnaList");
			model.addAttribute("message", "Write Fail");
		}
		return view;
	}
	//------------------------------------------------------------
	@RequestMapping(value="qnaList", method=RequestMethod.GET)
	public String qnaList(Model model, PagerMaker pagerMaker)throws Exception{
		List<BoardDTO> ar = qnaService.getList(pagerMaker);
		model.addAttribute("board", "qna");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pagerMaker);
		return "board/boardList";
	}
	//------------------------------------------------------------
	@RequestMapping(value="qnaUpdate", method = RequestMethod.POST)
	public String qnaUpdate(QnaDTO qnaDTO, Model model)throws Exception{
		  int result = qnaService.setUpdate(qnaDTO);
		  String view = "common/messageMove"; 
		  if(result>0) {
			  model.addAttribute("message", "update success"); 
			  model.addAttribute("path","qnaList"); 
		  }else { 
			  model.addAttribute("message", "update fail");
			  model.addAttribute("path", "qnaList"); 
		  }
		return view;
	}
	
	@RequestMapping(value="qnaUpdate", method = RequestMethod.GET)
	public String qnaUpdate(int num, Model model)throws Exception{
		QnaDTO qnaDTO = (QnaDTO)qnaService.getSelect(num);
		model.addAttribute("boardDTO", qnaDTO);
		model.addAttribute("board", "qna");
		model.addAttribute("files", qnaDTO.getFiles());
		return "board/boardUpdate";
	}
	//------------------------------------------------------------
	@RequestMapping(value="qnaDelete")
	public String qnaDelete(int num, Model model)throws Exception{
		int result = qnaService.setDelete(num);
		int result1 = fileDAO.setDelete(num);
		String view = "common/messageMove";
		if(result>0) {
			model.addAttribute("message", "Delete Success");
			model.addAttribute("path", "qnaList");
		}else {
			model.addAttribute("message", "Delete Fail");
			model.addAttribute("path", "qnaList");
		}
		return view;
	}
	//------------------------------------------------------------
	@RequestMapping(value = "qnaSelect", method=RequestMethod.GET)
	public String qnsSelect(int num, Model model)throws Exception{
		
		QnaDTO qnaDTO = (QnaDTO)qnaService.getSelect(num);
		model.addAttribute("board", "qna");
		model.addAttribute("boardDTO", qnaDTO);
		model.addAttribute("files", qnaDTO.getFiles());
		return "board/boardSelect";
	}
	//------------------------------------------------------------
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public String qnaWrite(QnaDTO qnaDTO, Model model, List<MultipartFile> multipartFiles, HttpSession session)throws Exception{
		String view = "common/messageMove";
		int result = qnaService.setWrite(qnaDTO,multipartFiles, session );
		if(result>0) {
			model.addAttribute("message", "Write Success");
			model.addAttribute("path", "qnaList");
		}else {
			model.addAttribute("message", "Write Fail");
			model.addAttribute("path", "qnaList");
		}
		
		return view;
	}
	@RequestMapping(value ="qnaWrite", method =RequestMethod.GET)
	public String qnaWrite(Model model)throws Exception{
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
}
