package org.zerock.braincare.todos.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.braincare.todos.domain.Todo;
import org.zerock.braincare.todos.dto.TodoDTO;
import org.zerock.braincare.todos.repository.TodoRepository;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;

    @Override
    public int register(TodoDTO todoDTO) {

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        int todo_id = todoRepository.save(todo).getTodoId();

        return todo_id;
    }

    @Override
    public TodoDTO readOne(int todo_id) {

        Optional<Todo> result = todoRepository.findById((long) todo_id);

        Todo todo = result.orElseThrow();

        TodoDTO todoDTO = modelMapper.map(todo, TodoDTO.class);

        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById((long) todoDTO.getTodo_id());
        Todo todo = result.orElseThrow();
        todo.change(todoDTO.getTitle(), todoDTO.getDescription(), todoDTO.isCompleted(), todoDTO.getDueDate());

        todoRepository.save(todo);
    }

    @Override
    public void remove(int todo_id) {
        todoRepository.deleteById((long) todo_id);
    }
}
