package org.zerock.braincare.todos.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.braincare.todos.domain.Todo;
import org.zerock.braincare.todos.dto.PageRequestDTO;
import org.zerock.braincare.todos.dto.PageResponseDTO;
import org.zerock.braincare.todos.dto.TodoDTO;
import org.zerock.braincare.todos.repository.TodoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

    private final ModelMapper modelMapper;

    private final TodoRepository todoRepository;

    @Override
    public Long register(TodoDTO todoDTO) {

        Todo todo = modelMapper.map(todoDTO, Todo.class);

        Long todoId = todoRepository.save(todo).getTodoId();

        return todoId;
    }

    @Override
    public TodoDTO readOne(Long todoId) {

        Optional<Todo> result = todoRepository.findById(todoId);

        Todo todo = result.orElseThrow();

        TodoDTO todoDTO = modelMapper.map(todo, TodoDTO.class);

        return todoDTO;
    }

    @Override
    public void modify(TodoDTO todoDTO) {

        Optional<Todo> result = todoRepository.findById(todoDTO.getTodoId());
        Todo todo = result.orElseThrow();
        todo.change(todoDTO.getTitle(), todoDTO.getDescription(), todoDTO.isCompleted(), todoDTO.getDueDate());

        todoRepository.save(todo);
    }

    @Override
    public void remove(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("todoId");

        Page<Todo> result = todoRepository.searchAll(types, keyword, pageable);

        List<TodoDTO> dtoList = result.getContent().stream()
                .map(todo -> modelMapper.map(todo,TodoDTO.class))
                .collect(Collectors.toList());

        return PageResponseDTO.<TodoDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }
}
