package org.mixdog.board.service;

import org.mixdog.board.dto.BoardDto;

import java.util.List;

public interface BoardService {
    // 리스트 조회
    List<BoardDto> selectBoardList() throws Exception;
    // 게시글 등록
    void insertBoard(BoardDto board) throws Exception;
    // 게시글 세부 조회
    BoardDto selectBoardDetail(int boardIdx) throws Exception;
    // 게시글 수정
    void updateBoard(BoardDto board) throws Exception;
    // 게시글 삭제
    void deleteBoard(int boardIdx) throws Exception;
}
