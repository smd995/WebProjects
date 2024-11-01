package org.zerock.braincare.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.braincare.todos.dto.PageRequestDTO;
import org.zerock.braincare.todos.dto.PageResponseDTO;
import org.zerock.braincare.todos.dto.TodoDTO;
import org.zerock.braincare.todos.service.TodoService;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @Test
    public void testRegister() {
        log.info(todoService.getClass().getName());

        TodoDTO todoDTO = TodoDTO.builder()
                .title("Sample Title")
                .description("Sample Description")
                .completed(false)
                .dueDate(LocalDateTime.parse("2024-12-31T00:00:00"))
                .build();

        Long todo_id = todoService.register(todoDTO);

        log.info("todo_id: " + todo_id);
    }

    @Test
    public void testRead() {
        TodoDTO todoDTO = todoService.readOne(100L);

        log.info("todoDTO: " + todoDTO);
    }

    @Test
    public void testModify() {
        TodoDTO todoDTO = TodoDTO.builder()
                .todoId(101)
                .title("Update Title")
                .description("Update Description")
                .completed(true)
                .dueDate(LocalDateTime.parse("2024-12-31T00:00:00"))
                .build();
        todoService.modify(todoDTO);

        log.info("todoDTO: " + todoDTO);
    }

    @Test
    public void testDelete() {
        todoService.remove(101L);
    }

    @Test
    public void testList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .type("td")
                .keyword("1")
                .page(1)
                .size(10)
                .build();

        PageResponseDTO<TodoDTO> pageResponseDTO = todoService.list(pageRequestDTO);

        log.info(pageResponseDTO);
    }

}
