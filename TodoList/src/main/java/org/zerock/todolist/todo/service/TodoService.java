package org.zerock.todolist.todo.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.todolist.todo.dao.TodoDAO;
import org.zerock.todolist.todo.domain.TodoVO;
import org.zerock.todolist.todo.dto.TodoDTO;
import org.zerock.todolist.todo.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum TodoService {
    INSTANCE;

    private TodoDAO dao;
    private ModelMapper modelMapper;

    TodoService() {

        dao = new TodoDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register (TodoDTO todoDTO) throws Exception {
        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);

        log.info(vo);

        dao.insert(vo);
    }

    public List<TodoDTO> listAll() throws Exception{

        List<TodoVO> voList = dao.selectAll();

        log.info("voList.....");
        log.info(voList);

        List<TodoDTO> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    public TodoDTO getByTno(Long tno) throws Exception {

        log.info("tno: " + tno);
        TodoVO vo = dao.selectOne(tno);
        TodoDTO dto = modelMapper.map(vo, TodoDTO.class);
        return dto;
    }

    public void remove(Long tno) throws Exception {

        log.info("tno: " + tno);
        dao.deleteOne(tno);

    }

    public void modify(TodoDTO todoDTO) throws Exception {
        log.info("todoDTO: " + todoDTO);

        TodoVO vo = modelMapper.map(todoDTO, TodoVO.class);

        dao.updateOne(vo);
    }
}
