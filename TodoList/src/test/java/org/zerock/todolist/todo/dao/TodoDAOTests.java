package org.zerock.todolist.todo.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.todolist.todo.domain.TodoVO;

import java.time.LocalDate;
import java.util.List;

public class TodoDAOTests {

    private TodoDAO todoDAO;

    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception {

        System.out.println(todoDAO.getTime());
    }

    @Test
    public void insertTest() throws Exception {
        TodoVO todoVO = TodoVO.builder()
                .title("sample title")
                .dueDate(LocalDate.of(2024,12,31))
                .writer("sample writer")
                .build();

        todoDAO.insert(todoVO);
    }

    @Test
    public void testList() throws Exception {
        List<TodoVO> list = todoDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {
        Long tno = 1L;
        TodoVO todoVO = todoDAO.selectOne(tno);

        System.out.println(todoVO);

    }

    @Test
    public void deleteOne() throws Exception{
        Long tno = 2L;
        todoDAO.deleteOne(tno);

    }

    @Test
    public void updateOne() throws Exception{
        TodoVO vo = TodoVO.builder()
                .tno(2L)
                .title("sample title2")
                .dueDate(LocalDate.of(2025,1,31))
                .writer("sample writer2")
                .done(true)
                .build();

        todoDAO.updateOne(vo);
    }
}
