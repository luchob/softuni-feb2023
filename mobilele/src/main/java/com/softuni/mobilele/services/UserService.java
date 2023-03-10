package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtoS.model.UserModel;
import com.softuni.mobilele.domain.entities.UserActivationEntity;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.UserActivationRepository;
import com.softuni.mobilele.repositories.UserRepository;
import jakarta.persistence.Column;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements DataBaseInitService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final UserActivationRepository userActivationRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository,
        UserRoleService userRoleService,
        UserActivationRepository userActivationRepository,
        ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.userActivationRepository = userActivationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void dbInit() {
        UserEntity userEntity = new UserEntity().
            setFirstName("admin").
            setLastName("adminov").
            setActive(true).
            setUsername("test").
            setPassword("test");

        userEntity = userRepository.save(userEntity);

        UserActivationEntity activationEntity = new UserActivationEntity().
            setActivation("aaaaaa").
            setUser(userEntity);

        userActivationRepository.save(activationEntity);

        System.out.println(userActivationRepository.findByUser(userEntity.getId()).get());
    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }

    public UserModel registerUser(UserRegisterFormDto userRegister) {
        final UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRole(this.userRepository.count() == 0
            ? this.userRoleService.findAllRoles()
            : List.of(this.userRoleService.findRoleByName("USER")));

        final UserEntity userToSave = this.modelMapper.map(userModel, UserEntity.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }
}