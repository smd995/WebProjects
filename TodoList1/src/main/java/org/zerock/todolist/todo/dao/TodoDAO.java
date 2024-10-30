package org.zerock.todolist.todo.dao;

import lombok.Cleanup;
import org.zerock.todolist.todo.domain.TodoVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    public String getTime() {
        String now = null;

        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select now()");
             ResultSet resultSet = preparedStatement.executeQuery();) {

            resultSet.next();

            now = resultSet.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return now;
    }

    public String getTime2() throws Exception {
        String now = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup  ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        now = resultSet.getString(1);

        return now;
    }

    public void insert (TodoVO todoVO) throws Exception {
        String sql = "insert into tbl_todo (title, dueDate, writer, done) " +
                "values (?, ?, ?, ?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setString(3, todoVO.getWriter());
        preparedStatement.setBoolean(4, todoVO.isDone());

        preparedStatement.executeUpdate();
    }

    public List<TodoVO> selectAll() throws Exception {

        String sql = "select * from tbl_todo";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup  ResultSet resultSet = preparedStatement.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while(resultSet.next()) {
            TodoVO vo = TodoVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .title(resultSet.getString("title"))
                    .dueDate(resultSet.getDate("dueDate").toLocalDate())
                    .writer(resultSet.getString("writer"))
                    .done(resultSet.getBoolean("done"))
                    .build();

            list.add(vo);

        }

        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception {
        String sql = "select * from tbl_todo where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);
        @Cleanup  ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        TodoVO vo = TodoVO.builder()
                .tno(resultSet.getLong("tno"))
                .title(resultSet.getString("title"))
                .dueDate(resultSet.getDate("dueDate").toLocalDate())
                .writer(resultSet.getString("writer"))
                .build();

        return vo;


    }

    public void deleteOne (Long tno) throws Exception {
        String sql = "delete from tbl_todo where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, tno);

        preparedStatement.executeUpdate();
    }

    public void updateOne (TodoVO todoVO) throws Exception {
        String sql = "update tbl_todo set " +
                "title = ?, dueDate = ?, writer = ?, done = ? " +
                "where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup  PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, todoVO.getTitle());
        preparedStatement.setDate(2, Date.valueOf(todoVO.getDueDate()));
        preparedStatement.setString(3, todoVO.getWriter());
        preparedStatement.setBoolean(4, todoVO.isDone());
        preparedStatement.setLong(5, todoVO.getTno());
        preparedStatement.executeUpdate();

    }
}
