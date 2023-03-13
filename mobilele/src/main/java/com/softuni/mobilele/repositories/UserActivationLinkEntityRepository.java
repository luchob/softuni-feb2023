package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.UserActivationLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationLinkEntityRepository extends JpaRepository<UserActivationLinkEntity, Long> {

}
