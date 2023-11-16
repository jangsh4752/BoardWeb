package com.ezen.biz.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ezen.biz.dto.BoardVO;

//@Repository
public class BoardDAO extends SqlSessionDaoSupport {

	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// �Խñ� �ۼ�
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 처리");

		getSqlSession().insert("BoardMapper.insertBoard", vo);
	}

	// �Խñ� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 처리");

		getSqlSession().update("BoardMapper.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 처리");

		getSqlSession().delete("BoardMapper.deleteboard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 처리");

		return getSqlSession().selectOne("BoardMapper.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 처리");

		return getSqlSession().selectList("BoardMapper.getBoardList_D", vo);
	}

}
