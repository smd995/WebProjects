package org.zerock.todolist.todo.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.todolist.todo.dto.TodoDTO;

import java.time.LocalDate;

@Log4j2
public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {
        TodoDTO dto = TodoDTO.builder()
                .title("JDBC Test Title")
                .dueDate(LocalDate.now())
                .writer("sameple writer")
                .build();

        log.info("---------------------------");
        log.info(dto);

        todoService.register(dto);
    }

}
