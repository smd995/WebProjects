package org.zerock.todolist2.service;

import org.zerock.todolist2.dto.PageRequestDTO;
import org.zerock.todolist2.dto.PageResponseDTO;
import org.zerock.todolist2.dto.TodoDTO;

public interface TodoService {

    void register(TodoDTO todoDTO);

    // List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);

}
