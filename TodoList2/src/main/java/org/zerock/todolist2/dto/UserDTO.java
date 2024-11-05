package org.zerock.todolist2.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotEmpty
    private String id;
    @NotEmpty
    private String pw;
    @NotEmpty
    private String email1;
    @NotEmpty
    private String email2;

    private LocalDate regDate;
}
