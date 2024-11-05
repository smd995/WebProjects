package org.zerock.todolist2.mapper;

import org.apache.ibatis.annotations.Param;
import org.zerock.todolist2.domain.User;

import java.util.List;

public interface UserMapper {

    String getTime();

    void insert(User user);

    List<User> selectAll();

    User selectOne(@Param("id") String id, @Param("pw") String password);

    void delete(String id);
}
