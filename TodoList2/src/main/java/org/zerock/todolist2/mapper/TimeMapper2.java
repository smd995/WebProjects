package org.zerock.todolist2.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper2 {
    String getNow();
}
