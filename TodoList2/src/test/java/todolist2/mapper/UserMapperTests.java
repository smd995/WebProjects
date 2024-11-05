package todolist2.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.todolist2.domain.User;
import org.zerock.todolist2.mapper.UserMapper;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class UserMapperTests {

    @Autowired(required = false)
    private UserMapper mapper;

    @Test
    public void testGetTime() {
        log.info(mapper.getTime());
    }

    @Test
    public void testInsert() {
        User user = User.builder()
                .id("user11")
                .pw("password11")
                .email1("user11")
                .email2("example.com")
                .regDate(LocalDate.now())
                .build();

        mapper.insert(user);
    }

    @Test
    public void testSelectAll() {
        List<User> userList = mapper.selectAll();

        userList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {
        User user = mapper.selectOne("user01", "password1");

        log.info(user);
    }

}
