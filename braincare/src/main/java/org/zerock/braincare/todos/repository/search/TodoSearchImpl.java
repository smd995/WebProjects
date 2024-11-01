package org.zerock.braincare.todos.repository.search;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    @Override
    public Page<Todo> searchAll(String[] types, String keyword, Pageable pageable) {
        QTodo todo = QTodo.todo;
        JPQLQuery<Todo> query = from(todo);

        if ((types != null && types.length > 0) && keyword != null) {

            BooleanBuilder booleanBuilder = new BooleanBuilder();

            for(String type : types) {
                switch(type) {
                    case "t":
                        booleanBuilder.or(todo.title.contains(keyword));
                        break;
                    case "d":
                        booleanBuilder.or(todo.description.contains(keyword));
                        break;
                }
            }
            query.where(booleanBuilder);
        }

        query.where(todo.todoId.gt(0));

        this.getQuerydsl().applyPagination(pageable, query);

        List<Todo> list =query.fetch();

        long count = query.fetchCount();

        return new PageImpl<>(list, pageable, count);
    }
}
