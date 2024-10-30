package org.zerock.todolist.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.todolist.todo.dto.MemberDTO;
import org.zerock.todolist.todo.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get......");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post......");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String auto = req.getParameter("auto");

        boolean rememberMe = auto != null && auto.equals("on");

        try {
            MemberDTO dto = MemberService.INSTANCE.login(mid, mpw);

            if (rememberMe) {
                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid, uuid);
                dto.setUuid(uuid);

                Cookie rememberCookie = new Cookie("remember-me", uuid);
                dto.setUuid(uuid);

                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", dto);
            resp.sendRedirect("/todo/list");

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }

    }
}
