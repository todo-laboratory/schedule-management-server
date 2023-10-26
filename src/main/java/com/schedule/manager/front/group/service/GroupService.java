package com.schedule.manager.front.group.service;

import com.schedule.manager.front.group.entity.Group;
import com.schedule.manager.front.group.model.request.CreateGroupReqDTO;
import com.schedule.manager.front.group.model.request.UpdateGroupReqDTO;
import com.schedule.manager.front.group.repository.GroupRepository;
import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.model.request.UpdateUserReqDTO;
import com.schedule.manager.front.user.repository.UserRepository;
import com.schedule.manager.front.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;



    public GroupService (GroupRepository groupRepository, ModelMapper modelMapper, UserService userService) {
        this.groupRepository = groupRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Transactional(rollbackOn = Exception.class)
    public Group createGroup(CreateGroupReqDTO dto) {

        // user_id -> user
        // TODO 리팩토링 해야할듯..
        List<User> userList = dto.getUserIdList().stream()
                .map(userService::findUserById)
                .collect(Collectors.toList());

        Group group = modelMapper.map(dto, Group.class);
        group.setUsers(userList);

        Group returnedGroup = groupRepository.save(group);
        return returnedGroup;
    }

    @Transactional(rollbackOn = Exception.class)
    public Group updateGroup(UpdateGroupReqDTO dto) {
        Group group = this.findUserById(dto.getId());

        group.setGroupName(dto.getGroupName());
        group.setGroupDescription(dto.getGroupDescription());
        group.setDeleteYn(dto.isDeleteYn());
        group.setManagerYn(dto.isManagerYn());
        group.setGroupEndTime(dto.getGroupEndTime());
        // group.setUsers(dto.getUsers());

        return group;
    }

    public Group findUserById(Long groupId) {
        return groupRepository.findById(groupId).orElse(null);
    }

    public void deleteUser(Long groupId) {
        groupRepository.deleteGroupById(groupId);
    }



}
