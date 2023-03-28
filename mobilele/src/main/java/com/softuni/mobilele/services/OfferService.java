package com.softuni.mobilele.services;

import com.softuni.mobilele.domain.dtos.veiw.OfferDetailsViewDTO;
import com.softuni.mobilele.domain.entities.OfferEntity;
import com.softuni.mobilele.repositories.OfferRepository;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  private final OfferRepository offerRepository;

  public OfferService(OfferRepository offerRepository) {
    this.offerRepository = offerRepository;
  }

  public boolean isOwner(String userName, UUID offerUUID) {

    System.out.println("IS OWNERRRR: " + userName + " " + offerUUID);
    return true;
  }

  public void deleteOfferByUUID(UUID uuid){
    System.out.println("DELETE: " + uuid);
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
}
