package com.schedule.manager.test.user;

import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class UserCrudTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    void createUserTest() {

        CreateUserReqDTO dto = CreateUserReqDTO.builder().name("test")
                .loginId("testId").nickName("testNickName").build();

        User returnedUser = userService.createUser(dto);

        Assertions.assertEquals(returnedUser.getName(), dto.getName());

    }
}
