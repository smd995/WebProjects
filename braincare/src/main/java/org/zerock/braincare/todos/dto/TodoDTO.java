package org.zerock.braincare.todos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private int todo_id;

    private int member_id;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime dueDate;
}
