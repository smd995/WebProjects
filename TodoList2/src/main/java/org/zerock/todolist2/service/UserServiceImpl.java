package org.zerock.todolist2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.todolist2.domain.User;
import org.zerock.todolist2.dto.UserDTO;
import org.zerock.todolist2.mapper.UserMapper;

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
    public boolean authenticate(String id, String password) {
        User user = userMapper.selectOne(id, password);

        if(user.getId().equals(id) && user.getPw().equals(password)) {

            return true;
        }    else {
            return false;
        }

    }

    @Override
    public void remove(String id) {
        userMapper.delete(id);
    }


}
