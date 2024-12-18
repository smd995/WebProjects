package org.zerock.todolist.todo.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {
    private Long tno;

    private String title;

    private LocalDate dueDate;

    private String writer;

    private boolean done;
}
