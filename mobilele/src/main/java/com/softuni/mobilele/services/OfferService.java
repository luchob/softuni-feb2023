package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtos.model.SearchOfferDTO;
import com.softuni.mobilele.domain.dtos.veiw.OfferDetailsViewDTO;
import com.softuni.mobilele.domain.entities.OfferEntity;
import com.softuni.mobilele.domain.enums.UserRoleEnum;
import com.softuni.mobilele.repositories.OfferRepository;
import com.softuni.mobilele.repositories.OfferSpecification;
import com.softuni.mobilele.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  private final OfferRepository offerRepository;

  public OfferService(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
  }

  public OfferDetailsViewDTO getOfferById(UUID offerId) {
    // TODO: test case
    var offerEntity = offerRepository.findOfferEntityByOfferId(offerId).orElseThrow(() ->
        new ObjectNotFoundException("Offer " + offerId + " not found", offerId));

    return map(offerEntity);
  }

  public Page<OfferDetailsViewDTO> getAllOffers(Pageable pageable) {
    return
        offerRepository.
            findAll(pageable).
            map(this::map);
  }

  private OfferDetailsViewDTO map(OfferEntity offerEntity) {
    return new OfferDetailsViewDTO().
        setOfferId(offerEntity.getOfferId()).
        setImageUrl(offerEntity.getImageUrl()).
        setDescription(offerEntity.getDescription()).
        setEngine(offerEntity.getEngine()).
        setModel(offerEntity.getModel().getName()).
        setModel(offerEntity.getModel().getBrand().getName()).
        setMileage(offerEntity.getMileage()).// TODO -> int
        setPrice(offerEntity.getPrice()).// TODO -> big decimal
        setTransmission(offerEntity.getTransmission()).
        setYear(offerEntity.getYear());//todo -> int
  }

  public void deleteOfferByUUID(UUID id) {
    offerRepository.
        findOfferEntityByOfferId(id).
        ifPresent(offerRepository::delete);
  }

  public List<OfferDetailsViewDTO> findOffers(SearchOfferDTO filter) {
    return
        offerRepository.findAll(new OfferSpecification(filter)).
            stream().
            map(this::map).
            toList();
  }

  public boolean isOwner(UserDetails userDetails, UUID id) {
    if (id == null || userDetails == null) {
      return  false;
    }

    var offer = offerRepository.
        findOfferEntityByOfferId(id).
        orElse(null);

    if (offer == null) {
      return false;
    }

    return userDetails.getUsername().equals(offer.getSeller().getEmail()) ||
        isUserAdmin(userDetails);
  }

  private boolean isUserAdmin(UserDetails userDetails) {
    // to do
    return userDetails.getAuthorities().
        stream().
        map(GrantedAuthority::getAuthority).
        anyMatch(a -> a.equals("ROLE_" + UserRoleEnum.ADMIN.name()));
  }
}
