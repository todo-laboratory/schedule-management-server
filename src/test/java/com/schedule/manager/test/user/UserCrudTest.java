package com.schedule.manager.test.user;

import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.model.request.UpdateUserReqDTO;
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
    void UserCRUDTest() {

        CreateUserReqDTO dto = CreateUserReqDTO.builder().name("test")
                .loginId("testId").nickName("testNickName").build();

        User returnedUser = userService.createUser(dto);

        // Create 확인
        Assertions.assertEquals(returnedUser.getName(), dto.getName());

        User findUser = userService.findUserById(returnedUser.getId());
        // Read 확인
        Assertions.assertEquals(findUser.getId(), returnedUser.getId());

        // Update 확인
        findUser.setName("test2");
        User updatedUser = userService.updateUser(modelMapper.map(findUser, UpdateUserReqDTO.class));
        Assertions.assertEquals(updatedUser.getName(), findUser.getName());

        // Delete 확인
        userService.deleteUser(updatedUser.getId());
        User deletedUser = userService.findUserById(returnedUser.getId());
        Assertions.assertEquals(deletedUser.isDeleteYn(), true);

    }
}
