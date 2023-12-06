package org.mixdog.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.mixdog.board.dto.BoardDto;
import org.mixdog.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


import java.util.List;

@Slf4j
@Controller
public class BoardController {

//    //slf4j log 생성
//    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    /**
     * 게시판 리스트 뷰 반환 컨트롤러
     */
    @RequestMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception {

        log.debug("리스트 불러왔정");
        ModelAndView mv = new ModelAndView("/board/boardList");

        int i = 10/0;

        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }

    /**
     * 글쓰기 뷰 반환 컨트롤러
     */
    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception {
        return "/board/boardWrite";
    }

    /**
     * 글 등록 요청 컨트롤러
     */
    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    /**
     * 글 세부 조회 뷰 호출 컨트롤러
     */
    @RequestMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
        ModelAndView mv = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board", board);

        return mv;
    }
    /**
     * 글 수정 요청 컨트롤러
     */
    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }
    /**
     * 글 삭제 요청 컨트롤러
     */
    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }

}