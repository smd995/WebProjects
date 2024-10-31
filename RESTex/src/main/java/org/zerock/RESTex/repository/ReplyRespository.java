package org.zerock.restex.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.zerock.restex.domain.Reply;

public interface ReplyRespository extends JpaRepository<Reply, Long> {

    @Query("select r from Reply  r where r.board.bno = :bno")
    Page<Reply> listOfBoard(Long bno, Pageable pageable);

}
