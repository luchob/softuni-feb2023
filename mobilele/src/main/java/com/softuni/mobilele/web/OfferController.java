package com.softuni.mobilele.web;

import com.softuni.mobilele.services.OfferService;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {

  private final OfferService offerService;

  public OfferController(OfferService offerService) {

    this.offerService = offerService;
  }

  @PreAuthorize("isOwner(#id)")
  @GetMapping("/test/{id}")
  public String deleteOfferById(@PathVariable("id") UUID id) {
    //todo
    return "details";
  }

  @GetMapping("/{id}")
  public String getOfferById(@PathVariable("id") UUID offerUUID) {
    //todo
    return "details";
  }

  @GetMapping("/all")
  public String getAllOffers(Model model,
      @PageableDefault(
          sort = "offerId",
          size = 3
      ) Pageable pageable) {

    var allOffersPage = offerService.getAllOffers(pageable);

    model.addAttribute("offers", allOffersPage);

    return "offers";
  }

}
