package com.softuni.mobilele.web;

import com.softuni.mobilele.services.OfferService;
import java.util.UUID;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OfferController {

  private OfferService offerService;

  public OfferController(OfferService offerService) {
    this.offerService = offerService;
  }

  @PreAuthorize("isOwner(#uuid)")
  @DeleteMapping("/offers/{id}")
  public String deleteOffer(
      @PathVariable("id") UUID uuid) {
    //offerService.deleteOfferById(uuid);

    return "redirect:/offers/all";
  }
}
