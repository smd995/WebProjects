package org.zerock.boaredex.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.boaredex.domain.Board;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void voidTestInsert() {
        IntStream.range(1, 20).forEach(i -> {
            Board board = Board.builder()
                    .title("Title" + i)
                    .content("Content" + i)
                    .writer("Writer" + i)
                    .build();
            log.info(board);

            Board result = boardRepository.save(board);
            log.info(result);
        });
    }
}
