package org.zerock.todolist2.mapper;

import org.zerock.todolist2.domain.TodoVO;
import org.zerock.todolist2.dto.PageRequestDTO;
import org.zerock.todolist2.dto.PageResponseDTO;
import org.zerock.todolist2.dto.TodoDTO;

import java.util.List;

public interface TodoMapper {

    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    List<TodoVO> findByWriterWithPaging(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);


}
