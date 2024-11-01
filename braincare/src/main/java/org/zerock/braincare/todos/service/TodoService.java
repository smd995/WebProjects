package org.zerock.braincare.todos.service;


import org.zerock.braincare.todos.dto.TodoDTO;

public interface TodoService {

    int register(TodoDTO todoDTO);

    TodoDTO readOne(int todo_id);

    void modify(TodoDTO todoDTO);

    void remove(int todo_id);

}
