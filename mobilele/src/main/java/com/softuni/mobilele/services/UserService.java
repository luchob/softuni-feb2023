package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtoS.model.UserModel;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements DataBaseInitService {

    private final UserRepository userRepository;
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultAdminPass;


    @Autowired
    public UserService(UserRepository userRepository,
        RoleRepository roleRepository,
        PasswordEncoder passwordEncoder,
        @Value("${mobilele.admin.defaultpass}") String defaultAdminPass) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultAdminPass = defaultAdminPass;
    }

    @Override
    public void dbInit() {
        UserEntity admin = new UserEntity().
            setFirstName("Admin").
            setLastName("Adminov").
            setEmail("admin@example.com").
            setPassword(passwordEncoder.encode(defaultAdminPass)).
            setRoles(roleRepository.findAll());

        userRepository.save(admin);
    }

    @Override
    public boolean isDbInit() {
        return this.userRepository.count() == 0;
    }

    public void registerUser(UserRegisterFormDto registrationDTO) {
        UserEntity userEntity = new UserEntity().
            setFirstName(registrationDTO.getFirstName()).
            setLastName(registrationDTO.getLastName()).
            setEmail(registrationDTO.getEmail()).
            setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        userRepository.save(userEntity);

        //
    }

}