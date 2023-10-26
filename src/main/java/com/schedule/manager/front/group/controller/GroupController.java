package com.schedule.manager.front.group.controller;

import com.schedule.manager.front.group.entity.Group;
import com.schedule.manager.front.group.model.request.CreateGroupReqDTO;
import com.schedule.manager.front.group.model.request.UpdateGroupReqDTO;
import com.schedule.manager.front.group.service.GroupService;
import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.model.request.UpdateUserReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Slf4j
@RequestMapping("/group")
@Controller
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping()
    public Group createGroup(@RequestBody CreateGroupReqDTO dto) {
        return groupService.createGroup(dto);
    }

    @PutMapping()
    public Group updateGroup(@RequestBody UpdateGroupReqDTO dto) {
        return groupService.updateGroup(dto);
    }

    @DeleteMapping()
    public void deleteGroup(@NotBlank @RequestParam Long id) {
        groupService.deleteGroup(id);
    }

    @GetMapping()
    public Group findGroupById(@NotBlank @RequestParam Long id) {
        return groupService.findGroupById(id);
    }

}
