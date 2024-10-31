package org.zerock.restex.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zerock.restex.dto.PageRequestDTO;
import org.zerock.restex.dto.PageResponseDTO;
import org.zerock.restex.dto.ReplyDTO;
import org.zerock.restex.service.ReplyService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/replies")
@Log4j2
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping(value = "")
    public ResponseEntity<Map<String, Long>> register(
            @Valid @RequestBody ReplyDTO replyDTO,
            BindingResult bindingResult) throws BindException {

        log.info(replyDTO);

        if(bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }

        Map<String, Long> resultMap = new HashMap<>();

        Long rno = replyService.register(replyDTO);

        resultMap.put("rno", rno);

        return ResponseEntity.ok(resultMap);
    }

    @GetMapping(value = "/list/{bno}")
    public PageResponseDTO<ReplyDTO> list(@PathVariable("bno") Long bno,
                                          PageRequestDTO pageRequestDTO) {
        PageResponseDTO<ReplyDTO> responseDTO = replyService.getListOfBoard(bno,pageRequestDTO);

        return responseDTO;
    }

    @GetMapping("/{rno}")
    public ReplyDTO getReplyDTO(@PathVariable("rno") Long rno) {

        ReplyDTO replyDTO = replyService.read(rno);

        return replyDTO;
    }

    @DeleteMapping("/{rno}")
    public Map<String, Long> remove(@PathVariable("rno") Long rno) {

        replyService.remove(rno);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }

    @PutMapping(value = "/{rno}")
    public Map<String, Long> remove(@PathVariable("rno") Long rno, @RequestBody ReplyDTO replyDTO) {

        replyDTO.setRno(rno);

        replyService.modify(replyDTO);

        Map<String, Long> resultMap = new HashMap<>();

        resultMap.put("rno", rno);

        return resultMap;
    }
}
