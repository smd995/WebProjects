package org.zerock.todolist.todo.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.todolist.todo.dto.MemberDTO;
import org.zerock.todolist.todo.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Log4j2
@WebFilter(urlPatterns = {"/todo/*"}) // todo 디렉토리 모두 filter
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("Login Check doFilter......");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        if(session.getAttribute("loginInfo") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        Cookie cookie = findCookie(request.getCookies(), "remember-me");

        if(cookie == null) {
            response.sendRedirect("/login");
            return;
        }

        log.info("cookie 존재");

        String uuid = cookie.getValue();

        try {
            MemberDTO dto = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키 - 사용자 정보" + dto);
            if(dto == null) {
                throw new Exception("Cookie value is not valid");
            }

            session.setAttribute("loginInfo", dto);
            filterChain.doFilter(request, response);
        }catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/login");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String name) {
        if(cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent() ? result.get() : null;
    }
}
