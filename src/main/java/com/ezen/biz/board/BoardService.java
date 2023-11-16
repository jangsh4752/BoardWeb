package com.ezen.biz.board;

import java.util.List;

import com.ezen.biz.dto.BoardVO;

public interface BoardService {

	// 게시글 작성
	void insertBoard(BoardVO vo);

	// 게시글 수정
	void updateBoard(BoardVO vo);

	void deleteBoard(BoardVO vo);

	BoardVO getBoard(BoardVO vo);

	List<BoardVO> getBoardList(BoardVO vo);

}