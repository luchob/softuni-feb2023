package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.UserRoleEntity;
import com.softuni.mobilele.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRoleEntity, String> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);
}
