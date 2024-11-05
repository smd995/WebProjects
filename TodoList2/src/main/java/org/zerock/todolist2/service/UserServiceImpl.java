package org.zerock.todolist2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.todolist2.domain.TodoVO;
import org.zerock.todolist2.domain.User;
import org.zerock.todolist2.dto.PageRequestDTO;
import org.zerock.todolist2.dto.PageResponseDTO;
import org.zerock.todolist2.dto.TodoDTO;
import org.zerock.todolist2.dto.UserDTO;
import org.zerock.todolist2.mapper.TodoMapper;
import org.zerock.todolist2.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final ModelMapper modelMapper;

    @Override
    public void register(UserDTO userDTO) {

        log.info(modelMapper);

        User user = modelMapper.map(userDTO, User.class);

        log.info(user);

        userMapper.insert(user);

    }

    @Override
    public UserDTO authenticate(String id, String password) {
        User user = userMapper.selectOne(id, password);

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        return userDTO;
    }

    @Override
    public void remove(String id) {
        userMapper.delete(id);
    }


}
