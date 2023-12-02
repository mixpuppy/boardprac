    package org.mixdog.board.repository;

    import org.apache.ibatis.annotations.Mapper;
    import org.mixdog.board.dto.BoardDto;

    import java.util.List;

    @Mapper
    public interface IBoardDao {
        // 게시판 리스트 DAO
        List<BoardDto> selectBoardList() throws Exception;
        // 게시판 글 등록 DAO
        void insertBoard(BoardDto board) throws Exception;
        // 조회수 증가 DAO
        void updateHitCount(int boardIdx) throws Exception;
        // 게시글 세부 조회
        BoardDto selectBoardDetail(int boardIdx) throws Exception;
        // 게시글 수정
        void updateBoard(BoardDto board) throws Exception;
        // 게시글 삭제
        void deleteBoard(int boardIdx) throws Exception;
    }
