package org.mixdog.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public String hello() {
        return "SpringBoot 기본을 다잡자!";
    }
}
