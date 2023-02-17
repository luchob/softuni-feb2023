package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.enitities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
}
