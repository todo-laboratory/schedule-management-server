package com.schedule.manager.front.user.service;

import com.schedule.manager.front.user.entity.User;
import com.schedule.manager.front.user.model.request.CreateUserReqDTO;
import com.schedule.manager.front.user.model.request.UpdateUserReqDTO;
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
        User user = modelMapper.map(dto, User.class);
        User returnedUser = userRepository.save(user);
        return returnedUser;
    }

    @Transactional(rollbackOn = Exception.class)
    public User updateUser(UpdateUserReqDTO dto) {
        User user = this.findUserById(dto.getId());

        user.setName(dto.getName());
        user.setNickName(dto.getNickName());
        user.setProfileURL(dto.getProfileURL());
        user.setDeleteYn(dto.isDeleteYn());

        return user;
    }

    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteUserById(userId);
    }





}
