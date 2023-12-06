package org.mixdog.board.common;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        log.debug("익셉션 핸들러 진입");
        ModelAndView mv = new ModelAndView("error/error_default");
        mv.addObject("exception", exception);
        mv.addObject("stackTrace", exception.getStackTrace());
        log.error("exception", exception);

        return mv;
    }
}
