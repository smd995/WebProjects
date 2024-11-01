package org.zerock.braincare.todos.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    private String title;

    private String description;

    private boolean completed;

    private LocalDateTime dueDate;

    public void change(String title, String description, boolean completed, LocalDateTime dueDate){
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.dueDate = dueDate;
    }
}
