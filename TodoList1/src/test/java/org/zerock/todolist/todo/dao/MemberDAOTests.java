package org.zerock.todolist.todo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.todolist.todo.domain.MemberVO;

public class MemberDAOTests {

    private MemberDAO dao;

    @BeforeEach
    public void setUp() {
        dao = new MemberDAO();
    }

    @Test
    public void testTime() throws Exception {
        System.out.println(dao.getTime());
    }

    @Test
    public void getWithPasswordTest() throws Exception {
        MemberVO memberVO = dao.getWithPassword("user00", "1111");
        System.out.println(memberVO);
    }
}
