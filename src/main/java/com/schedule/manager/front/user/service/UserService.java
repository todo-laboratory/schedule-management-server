package com.schedule.manager.front.user.service;

import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public UserService (UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(rollbackOn = Exception.class)
    public User createUser(CreateUserReqDTO dto) {
        log.info("dto: {}", dto.toString());
        User user = modelMapper.map(dto, User.class);
        log.info("model user: {}", user.getName());
        User returnedUser = userRepository.save(user);
        return returnedUser;
    }


    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }





}
