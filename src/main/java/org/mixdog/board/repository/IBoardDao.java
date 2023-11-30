    package org.mixdog.board.repository;

    import org.apache.ibatis.annotations.Mapper;
    import org.mixdog.board.dto.BoardDto;

    import java.util.List;

    @Mapper
    public interface IBoardDao {
        List<BoardDto> selectBoardList() throws Exception;
    }
