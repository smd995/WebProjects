package org.zerock.braincare.todos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.braincare.todos.domain.Todo;
import org.zerock.braincare.todos.dto.PageRequestDTO;
import org.zerock.braincare.todos.dto.PageResponseDTO;
import org.zerock.braincare.todos.dto.TodoDTO;
import org.zerock.braincare.todos.service.TodoService;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list")
    public void list(PageRequestDTO pageRequestDTO, Model model) {

        PageResponseDTO<TodoDTO> responseDTO = todoService.list(pageRequestDTO);

        log.info(responseDTO);

        model.addAttribute("responseDTO", responseDTO);

    }

    @GetMapping("/register")
    public void registerGET() {

    }

    @PostMapping("/register")
    public String registerPOST(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("todo POST register");

        if (bindingResult.hasErrors()) {
            log.info("has errors ...........");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        Long todoId = todoService.register(todoDTO);

        redirectAttributes.addFlashAttribute("result", todoId);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(Long todoId, PageRequestDTO pageRequestDTO, Model model) {
        TodoDTO todoDTO = todoService.readOne(todoId);

        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        log.info("todo POST modify" + todoDTO);

        if(bindingResult.hasErrors()) {
            log.info("has errors ...........");

            String link = pageRequestDTO.getLink();

            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addAttribute("todoId", todoDTO.getTodoId());

            return "redirect:/todo/modify?" + link;
        }

        todoService.modify(todoDTO);

        redirectAttributes.addFlashAttribute("result", "modified");

        redirectAttributes.addAttribute("todoId", todoDTO.getTodoId());

        return "redirect:/todo/read";
    }

    @PostMapping("/remove")
    public String remove(Long todoId, RedirectAttributes redirectAttributes) {

        log.info("remove post" + todoId);
        todoService.remove(todoId);
        redirectAttributes.addFlashAttribute("result", "removed");
        return "redirect:/todo/list";
    }



}
