package org.mixdog.board.service;

import org.mixdog.board.dto.BoardDto;
import org.mixdog.board.repository.IBoardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final IBoardDao iBoardDao;

    @Autowired
    public BoardServiceImpl(IBoardDao iBoardDao) {
        this.iBoardDao = iBoardDao;
    }

    /**
     * 게시판 리스트 조회 서비스
     */
    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return iBoardDao.selectBoardList();
    }

    /**
     * 게시판 글 등록 서비스
     */
    @Override
    public void insertBoard(BoardDto board) throws Exception {
        iBoardDao.insertBoard(board);
    }

    /**
     * 게시글 세부 조회
     */
    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        iBoardDao.updateHitCount(boardIdx);

        BoardDto board = iBoardDao.selectBoardDetail(boardIdx);

        return board;
    }
    /**
     * 게시글 수정
     */
    @Override
    public void updateBoard(BoardDto board) throws Exception {
        iBoardDao.updateBoard(board);
    }
    /**
     * 게시글 삭제
     */
    @Override
    public void deleteBoard(int boardIdx) throws Exception {
        iBoardDao.deleteBoard(boardIdx);
    }
}
