package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.UserActivationEntity;
import com.softuni.mobilele.domain.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivationRepository extends JpaRepository<UserActivationEntity, Long> {

  @Query("SELECT ua FROM UserActivationEntity ua WHERE ua.user.id = :userId")
  Optional<UserActivationEntity> findByUser(@Param("userId") long userId);

}
