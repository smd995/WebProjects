package org.zerock.todolist2.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    private String id;

    private String pw;

    private String email1;

    private String email2;

    private LocalDate regDate;
}
