package com.schedule.manager.front.user.controller;

import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@Slf4j
@RequestMapping("/fo/user")
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
    }

    @PostMapping()
    public void createUser(@RequestBody CreateUserReqDTO dto) {
        log.info("createUser dto: {}", dto);
        userService.createUser(dto);
    }

    @PutMapping()
    public void updateUser(@RequestBody String json) {

    }

    @DeleteMapping()
    public void deleteUser(@RequestBody String json) {

    }

    @GetMapping()
    public void getUser(@NotBlank @RequestParam Long id) {

    }
}

