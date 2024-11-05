package org.zerock.todolist2.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.todolist2.dto.UserDTO;
import org.zerock.todolist2.service.UserService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/member")
@Log4j2
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "/member/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id,
                        @RequestParam("password") String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        // 유저 인증 처리
        boolean isAuthenticated = userService.authenticate(id, password);

        if (isAuthenticated) {
            // 인증 성공 시 세션에 ID 저장
            session.setAttribute("loginUser", id);
            log.info(session.getAttribute("loginUser"));
            return "redirect:/todo/list"; // Todo 리스트로 리다이렉트
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid credentials");
            return "redirect:/member/login"; // 로그인 페이지로 리다이렉트
        }
    }

    @GetMapping("/join")
    public String joinGET() {
        return "/member/join";
    }

    @PostMapping("/join")
    public void joinPOST(@RequestParam("id") String id,
                         @RequestParam("password") String password,
                         @RequestParam("email1") String email1,
                         @RequestParam("email2") String email2) {
        UserDTO userdto = UserDTO.builder()
                .id(id)
                .pw(password)
                .email1(email1)
                .email2(email2)
                .regDate(LocalDate.now())
                .build();

        userService.register(userdto);
    }
}
