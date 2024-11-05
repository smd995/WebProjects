package todolist2.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.todolist2.dto.PageRequestDTO;
import org.zerock.todolist2.dto.PageResponseDTO;
import org.zerock.todolist2.dto.TodoDTO;
import org.zerock.todolist2.dto.UserDTO;
import org.zerock.todolist2.service.UserService;

import java.time.LocalDate;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        UserDTO userDTO = UserDTO.builder()
                .id("user12")
                .pw("password12")
                .email1("user12")
                .email2("example.com")
                .regDate(LocalDate.now())
                .build();


        userService.register(userDTO);
    }

//    @Test
//    public void testGetOne() {
//        UserDTO user12 = userService.getOne("user12", "password12");
//        log.info(user12);
//    }
}
