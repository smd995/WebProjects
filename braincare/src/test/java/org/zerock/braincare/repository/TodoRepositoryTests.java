package org.zerock.braincare.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.braincare.todos.domain.Todo;
import org.zerock.braincare.todos.repository.TodoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;


    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Todo todo = Todo.builder()
                    .todoId(i)
                    .title("sample title" + i)
                    .description("sample description" + i)
                    .completed(false)
                    .dueDate(LocalDateTime.now())
                    .build();

            Todo result = todoRepository.save(todo);
            log.info("TodoId" + result.getTodoId());
        });

    }

    @Test
    public void testSelect() {
        Long todoId = 100L;

        Optional<Todo> result = todoRepository.findById(todoId);

        Todo todo = result.orElseThrow();

        log.info(todo);
    }

    @Test
    public void testUpdate () {
        Long todoId = 100L;

        Optional<Todo> result = todoRepository.findById(todoId);

        Todo todo = result.orElseThrow();

        todo.change("update..title 100",
                "update..description 100",
                true,
                LocalDateTime.parse("2024-12-31T00:00:00"));

        todoRepository.save(todo);
    }

    @Test
    public void testDelete () {

        Long todoId = 45L;

        todoRepository.deleteById(todoId);
    }

    @Test
    public void testPaging(){
        // 1 page order by bno desc
        Pageable pageable = PageRequest.of(0,10, Sort.by("todoId").descending());

        Page<Todo> result = todoRepository.findAll(pageable);

        log.info("total count : " + result.getTotalElements());
        log.info("total pages : " + result.getTotalPages());
        log.info("page number : " + result.getNumber());
        log.info("page size : " + result.getSize());

        List<Todo> todoList = result.getContent();

        todoList.forEach(todo -> log.info(todo));
    }

}
