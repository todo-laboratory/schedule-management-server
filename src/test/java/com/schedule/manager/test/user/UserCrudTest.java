package com.schedule.manager.test.user;

import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserCrudTest {

    @Autowired
    private UserService userService;

    @Test
    void createUserTest() {

        User user = new User().builder().id(1L).name("test")
                .loginId("testId").nickName("testNickName").build();

        User returnedUser = userService.createUser(user);

        Assertions.assertEquals(user.getId(), returnedUser.getId());

    }
}
