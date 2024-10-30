package org.zerock.todolist.todo.service;

import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.zerock.todolist.todo.dao.MemberDAO;
import org.zerock.todolist.todo.domain.MemberVO;
import org.zerock.todolist.todo.dto.MemberDTO;
import org.zerock.todolist.todo.util.MapperUtil;

@Log4j2
public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);

        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);

        return dto;
    }

    public void updateUuid(String mid, String uuid) throws Exception {
        dao.updateUuid(mid, uuid);
    }

    public MemberDTO getByUUID(String uuid) throws Exception {

        MemberVO vo = dao.selectUUID(uuid);

        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);

        return dto;

    }
}
