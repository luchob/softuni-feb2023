package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.entities.UserRoleEntity;
import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService implements DataBaseInitService {

    private final UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository,
        UserRoleRepository userRoleRepository,
        PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void dbInit() {
        initAdmin();
    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }

    private void initAdmin() {
        UserEntity admin = new UserEntity().
            setUsername("admin").
            setActive(true).
            setFirstName("Admin").
            setLastName("Adminov").
            setPassword(passwordEncoder.encode("topsecret")).
            setRoles(userRoleRepository.findAll());
        userRepository.save(admin);
    }
}