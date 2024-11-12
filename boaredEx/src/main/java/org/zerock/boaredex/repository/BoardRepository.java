package org.zerock.boaredex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.boaredex.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
