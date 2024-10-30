package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Log4j2
@Controller
@RequestMapping("/todo")
public class TodoController {

    @RequestMapping("/list")
    public void list() {
        log.info("todo list........");
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("todo register....");
    }

    @PostMapping("register")
    public void registerPost(TodoDTO dto) {
        log.info("todo register....");
        log.info(dto);
    }

}
