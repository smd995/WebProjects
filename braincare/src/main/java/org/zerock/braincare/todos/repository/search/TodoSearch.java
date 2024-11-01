package org.zerock.braincare.todos.repository.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.braincare.todos.domain.Todo;

public interface TodoSearch {

    Page<Todo> search1(Pageable pageable);
}
