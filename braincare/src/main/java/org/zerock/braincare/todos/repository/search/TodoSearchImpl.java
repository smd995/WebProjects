package org.zerock.braincare.todos.repository.search;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.braincare.todos.domain.QTodo;
import org.zerock.braincare.todos.domain.Todo;

import java.util.List;

public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(Pageable pageable) {

        QTodo todo =QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        query.where(todo.title.contains("1"));

        this.getQuerydsl().applyPagination(pageable, query);

        List<Todo> list =query.fetch();

        long count = query.fetchCount();

        return null;
    }
}
