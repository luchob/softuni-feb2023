package com.softuni.mobilele.repositories;


import com.softuni.mobilele.domain.dtoS.model.SearchOfferDTO;
import com.softuni.mobilele.domain.entities.OfferEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

public class OfferSpecification implements Specification<OfferEntity> {

  private final SearchOfferDTO searchOfferDTO;

  public OfferSpecification(SearchOfferDTO searchOfferDTO) {
    this.searchOfferDTO = searchOfferDTO;
  }

  @Override
  public Predicate toPredicate(Root<OfferEntity> root,
                               CriteriaQuery<?> query,
                               CriteriaBuilder cb) {

    final List<Predicate> predicates = new ArrayList<>();

    if (searchOfferDTO.getMinPrice() != null) {
      predicates.add(cb.greaterThanOrEqualTo(root.get("price"), searchOfferDTO.getMinPrice()));
    }

    if (searchOfferDTO.getMaxPrice() != null) {
      predicates.add(cb.and(cb.lessThanOrEqualTo(root.get("price"), searchOfferDTO.getMaxPrice())));
    }
    if (searchOfferDTO.getModel() != null && !searchOfferDTO.getModel().isEmpty()) {
      predicates.add(cb.and(cb.equal(root.join("model").get("name"), searchOfferDTO.getModel())));
    }

    return cb.and(predicates.toArray(new Predicate[0]));
  }
}
