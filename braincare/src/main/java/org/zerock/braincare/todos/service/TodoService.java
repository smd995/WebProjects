package org.zerock.braincare.todos.service;


import org.zerock.braincare.todos.dto.PageRequestDTO;
import org.zerock.braincare.todos.dto.PageResponseDTO;
import org.zerock.braincare.todos.dto.TodoDTO;

public interface TodoService {

    Long register(TodoDTO todoDTO);

    TodoDTO readOne(Long todo_id);

    void modify(TodoDTO todoDTO);

    void remove(Long todo_id);

    PageResponseDTO<TodoDTO> list(PageRequestDTO pageRequestDTO);

}
