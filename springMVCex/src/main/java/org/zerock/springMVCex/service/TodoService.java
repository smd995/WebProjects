package org.zerock.springMVCex.service;

import org.zerock.springMVCex.dto.PageRequestDTO;
import org.zerock.springMVCex.dto.PageResponseDTO;
import org.zerock.springMVCex.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

    // List<TodoDTO> getAll();

    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);


}
