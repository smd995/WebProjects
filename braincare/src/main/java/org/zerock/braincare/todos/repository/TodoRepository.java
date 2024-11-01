package org.zerock.braincare.todos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.braincare.todos.domain.Todo;
import org.zerock.braincare.todos.repository.search.TodoSearch;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {

}
