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

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return iBoardDao.selectBoardList();
    }
}
