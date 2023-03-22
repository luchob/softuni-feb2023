package com.softuni.mobilele.web;

import com.softuni.mobilele.services.OfferService;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
