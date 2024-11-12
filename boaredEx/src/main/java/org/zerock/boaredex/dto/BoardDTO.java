package org.zerock.boaredex.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 컨트롤러에서 DTO를 쓰기 때문에 JSON 직렬화와 역직렬화가 일어남
// 그 과정에서 직렬화(Java Object -> JSON)는 getter,
// 역직렬화(JSON -> Java Object )에서는
// 기본 생성자와 getter,setter 중 하나가 필요함
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {

    private Long bno;

    @NotEmpty
    @Size(min = 3, max = 50)
    private String title;

    @NotEmpty
    private String content;

    @NotEmpty
    private String writer;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

}

