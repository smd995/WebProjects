package org.zerock.restex.service;

import org.zerock.restex.dto.BoardDTO;
import org.zerock.restex.dto.BoardListReplyCountDTO;
import org.zerock.restex.dto.PageRequestDTO;
import org.zerock.restex.dto.PageResponseDTO;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO);

    PageResponseDTO<BoardListReplyCountDTO> listWithReplyCount(PageRequestDTO pageRequestDTO);
}
