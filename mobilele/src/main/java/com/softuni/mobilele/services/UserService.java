package com.softuni.mobilele.services;

import static org.hibernate.internal.util.collections.ArrayHelper.forEach;

import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.RoleRepository;
import com.softuni.mobilele.repositories.UserRepository;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Set<SessionRegistry> sessionRegistries;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public UserService(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder,
        Set<SessionRegistry> sessionRegistries) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.sessionRegistries = sessionRegistries;
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