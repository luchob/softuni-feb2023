package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.OfferEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long>,
    JpaSpecificationExecutor<OfferEntity> {
  Optional<OfferEntity> findOfferEntityByOfferId(UUID uuid);

}
