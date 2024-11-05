package org.zerock.todolist2.service;

import org.zerock.todolist2.dto.PageRequestDTO;
import org.zerock.todolist2.dto.PageResponseDTO;
import org.zerock.todolist2.dto.TodoDTO;
import org.zerock.todolist2.dto.UserDTO;

public interface UserService {

    void register(UserDTO userDTO);

    UserDTO authenticate(String id, String password);

    void remove(String id);

}
