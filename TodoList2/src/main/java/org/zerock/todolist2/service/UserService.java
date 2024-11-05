package org.zerock.todolist2.service;

import org.zerock.todolist2.dto.UserDTO;

public interface UserService {

    void register(UserDTO userDTO);

    boolean authenticate(String id, String password);

    void remove(String id);

}
