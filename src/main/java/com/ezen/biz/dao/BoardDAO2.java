package com.ezen.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

@Repository
public class BoardDAO2 {

	@Autowired
	private SqlSessionTemplate mybatis;

	// 게시글 작성
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 처리2");

		mybatis.insert("BoardMapper.insertBoard", vo);
	}

	// 게시글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 처리2");

		mybatis.update("BoardMapper.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 처리2");

		mybatis.delete("BoardMapper.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 처리2");

		return mybatis.selectOne("BoardMapper.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 처리2");

		return mybatis.selectList("BoardMapper.getBoardList_D", vo);
	}

}
