package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.enitities.UserRole;
import com.softuni.mobilele.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByRole(Role role);
}
