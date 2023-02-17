package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.enitities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, String> {
}

