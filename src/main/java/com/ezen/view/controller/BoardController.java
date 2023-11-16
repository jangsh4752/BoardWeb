package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.board.BoardService;
import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dto.BoardListVO;
import com.ezen.biz.dto.BoardVO;

@Controller
@SessionAttributes("board")  // getBoard()���� "board"�Ӽ����� ���� �����ϸ� 
							 // Session ��ü���� ���� ���� �����
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	// �Խñ� ���
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {

		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/Temp/upload/"+fileName));
		} else {
			System.out.println("���� ���ε尡 ���������� ó������ �ʾҽ��ϴ�.");
		}
		
		boardService.insertBoard(vo);

		// 3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}
	
	// �Խñ� ����
	// Session ��ü�� ����� board �Ӽ��� ���� @ModelAttribute�� ���Ͽ� BoardVO ��ü�� ���޵�
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("�Խñ� ���� ó��: <�ۼ��� �̸�> " + vo.getWriter());
		
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	// �Խñ� ����
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";			
	}
	
	// �� �Խñ� ��ȸ
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {

		BoardVO board = boardService.getBoard(vo);

		// 3. ���� ȭ�� ����
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	// �˻� ���� ��� ����
	// @RequestMapiing ������̼��� ����� �޼ҵ庸�� ���� ȣ���
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new LinkedHashMap<>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
	// �Խñ� ��� ��ȸ
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,	Model model) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("검색 조건 : " + vo.getSearchCondition());
		System.out.println("검색 단어 : " + vo.getSearchKeyword());
		
		// 2. DB ���� ó��
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		// 3. ���� ȭ�� ����
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("�˻� ����: " + vo.getSearchCondition());
		System.out.println("�˻� �ܾ�: " + vo.getSearchKeyword());
		
		// 2. DB ���� ó��
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		return boardList;
	}
	
	@RequestMapping(value="dataTransform_xml.do")
	@ResponseBody
	public BoardListVO dataTransformXml(BoardVO vo) {
		if (vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if (vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		System.out.println("�˻� ����: " + vo.getSearchCondition());
		System.out.println("�˻� �ܾ�: " + vo.getSearchKeyword());
		
		// 2. DB ���� ó��
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardList);
		
		return boardListVO;
	}
}









