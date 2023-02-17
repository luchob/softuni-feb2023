package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.enitities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model, String> {
}
