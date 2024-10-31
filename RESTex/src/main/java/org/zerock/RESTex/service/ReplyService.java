package org.zerock.restex.service;

import org.zerock.restex.dto.PageRequestDTO;
import org.zerock.restex.dto.PageResponseDTO;
import org.zerock.restex.dto.ReplyDTO;

public interface ReplyService {

    Long register(ReplyDTO replyDTO);

    ReplyDTO read(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequest);

}
