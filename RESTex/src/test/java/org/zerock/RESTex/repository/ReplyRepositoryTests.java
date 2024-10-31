package org.zerock.restex.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.restex.domain.Board;
import org.zerock.restex.domain.Reply;
import org.zerock.restex.dto.BoardListReplyCountDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRespository replyRespository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert() {

        Long bno = 109L;

        Board board = Board.builder().bno(bno).build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글....")
                .replyer("replyer1")
                .build();

        replyRespository.save(reply);

    }

    @Test
    public void testBoardReplies() {
        Long bno = 109L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRespository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> log.info(reply));
    }

    @Test
    public void testSearchReplyCount() {
        String[] types = {"t", "c", "w"};

        String keyword = "1";

        Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());

        Page<BoardListReplyCountDTO> result = boardRepository.searchWithReplyCount(types, keyword, pageable);

        log.info(result.getTotalPages());
        log.info(result.getSize());
        log.info(result.getNumber());
        log.info(result.hasPrevious()+ ": " + result.hasNext());

        result.getContent().forEach(board -> log.info(board));


    }

}
