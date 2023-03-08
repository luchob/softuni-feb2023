package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtoS.model.UserRoleModel;
import com.softuni.mobilele.domain.dtoS.veiw.UserRoleViewDto;
import com.softuni.mobilele.domain.entities.UserRoleEntity;
import com.softuni.mobilele.domain.enums.UserRoleEnum;
import com.softuni.mobilele.repositories.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserRoleService implements DataBaseInitService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleService(RoleRepository roleRepository, ModelMapper modelMapper) {
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.dbInit();
    }


    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<UserRoleEntity> roles = new ArrayList<>();

            roles.add(new UserRoleEntity().setRole(UserRoleEnum.USER));
            roles.add(new UserRoleEntity().setRole(UserRoleEnum.ADMIN));

            this.roleRepository.saveAllAndFlush(roles);
        }
    }

    @Override
    public boolean isDbInit() {
        return this.roleRepository.count() > 0;
    }

    public List<UserRoleViewDto> getAll() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleViewDto.class))
                .collect(Collectors.toList());
    }

    public List<UserRoleModel> findAllRoles() {
        return this.roleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleModel.class))
                .collect(Collectors.toList());
    }

    public UserRoleModel findRoleByName(String name) {
        return this.modelMapper.map(this.roleRepository.findByRole(UserRoleEnum.valueOf(name))
                        .orElseThrow(NoSuchElementException::new),
                UserRoleModel.class);
    }
}