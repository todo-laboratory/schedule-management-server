package com.schedule.manager.test.group;

import com.schedule.manager.front.group.entity.Group;
import com.schedule.manager.front.group.model.request.CreateGroupReqDTO;
import com.schedule.manager.front.group.model.request.UpdateGroupReqDTO;
import com.schedule.manager.front.group.service.GroupService;
import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
public class GroupCRUDTest {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @Test
    void GroupCRUDTest() {

        // createUser
        CreateUserReqDTO dto1 = CreateUserReqDTO.builder().name("test")
                .loginId("testId").nickName("testNickName").build();

        User user1 = userService.createUser(dto1);

        CreateUserReqDTO dto2 = CreateUserReqDTO.builder().name("test")
                .loginId("testId").nickName("testNickName").build();

        User user2 = userService.createUser(dto2);

        List<Long> users = new ArrayList<>();
        users.add(user1.getId());
        users.add(user2.getId());

        // createGroup
        CreateGroupReqDTO dto = CreateGroupReqDTO.builder()
                .managerYn(false)
                .groupName("test")
                .userIdList(users)
                .groupEndTime(LocalDateTime.now())
                .groupDescription("testDescription")
                .build();

        Group group = groupService.createGroup(dto);

        // Create 확인
        Assertions.assertEquals(group.getGroupName(), dto.getGroupName());

        // Read 확인
        Group findGroup = groupService.findGroupById(group.getId());
        Assertions.assertEquals(findGroup.getId(), group.getId());

        // Update 확인
        UpdateGroupReqDTO updateDTO = UpdateGroupReqDTO.builder().groupName("updatedTest")
                .id(findGroup.getId()).build();

        Group updatedGroup = groupService.updateGroup(updateDTO);
        Assertions.assertEquals(updatedGroup.getGroupName(), updateDTO.getGroupName());

        // Delete 확인
        groupService.deleteGroup(updatedGroup.getId());
        Group deletedGroup = groupService.findGroupById(group.getId());
        Assertions.assertEquals(deletedGroup.isDeleteYn(), true);

    }

}
