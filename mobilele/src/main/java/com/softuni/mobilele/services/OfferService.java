package com.softuni.mobilele.services;

import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  public boolean isOwner(String userName, UUID offerUUID) {
    return true;
  }

  public void deleteOfferByUUID(UUID uuid){}

}
