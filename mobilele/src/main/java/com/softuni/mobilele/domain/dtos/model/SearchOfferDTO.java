package com.softuni.mobilele.domain.dtos.model;

public class SearchOfferDTO {

  Integer minPrice, maxPrice;
  String model;

  public Integer getMinPrice() {
    return minPrice;
  }

  public SearchOfferDTO setMinPrice(Integer minPrice) {
    this.minPrice = minPrice;
    return this;
  }

  public Integer getMaxPrice() {
    return maxPrice;
  }

  public SearchOfferDTO setMaxPrice(Integer maxPrice) {
    this.maxPrice = maxPrice;
    return this;
  }

  public String getModel() {
    return model;
  }

  public SearchOfferDTO setModel(String model) {
    this.model = model;
    return this;
  }
}
