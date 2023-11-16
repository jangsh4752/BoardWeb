package com.ezen.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.biz.dao.BoardDAO2;
import com.ezen.biz.dto.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO2 boardDao;
	// 비즈니스 모듈에서 수동으로 로깅처리 수행
	//private LogAdvice log;
	//private Log4jAdvice log;
	
	public BoardServiceImpl() {
		// 사용할 로그 객체 생성
		//log = new LogAdvice();
		//log = new Log4jAdvice();
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		// 강제로 예외 발생
//		if (vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글을 등록할 수 없습니다.");
//		}
		boardDao.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
			
		boardDao.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		boardDao.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		return boardDao.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.printLog();
		//log.printLogging();
		
		return boardDao.getBoardList(vo);
	}

}






