package com.softuni.mobilele.domain.dtos.veiw;

import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import java.util.UUID;

public class OfferDetailsViewDTO {

  private String description;
  private UUID offerId;
  private Engine engine;
  private String imageUrl;
  private String mileage;
  private String price;
  private Transmission transmission;
  private String year;
  private String brand;
  private String model;

  public String offerSummary() {
    return year + " " + model;
  }

  public String getDescription() {
    return description;
  }

  public OfferDetailsViewDTO setDescription(String description) {
    this.description = description;
    return this;
  }

  public UUID getOfferId() {
    return offerId;
  }

  public OfferDetailsViewDTO setOfferId(UUID offerId) {
    this.offerId = offerId;
    return this;
  }

  public Engine getEngine() {
    return engine;
  }

  public OfferDetailsViewDTO setEngine(Engine engine) {
    this.engine = engine;
    return this;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public OfferDetailsViewDTO setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public String getMileage() {
    return mileage;
  }

  public OfferDetailsViewDTO setMileage(String mileage) {
    this.mileage = mileage;
    return this;
  }

  public String getPrice() {
    return price;
  }

  public OfferDetailsViewDTO setPrice(String price) {
    this.price = price;
    return this;
  }

  public Transmission getTransmission() {
    return transmission;
  }

  public OfferDetailsViewDTO setTransmission(
      Transmission transmission) {
    this.transmission = transmission;
    return this;
  }

  public String getYear() {
    return year;
  }

  public OfferDetailsViewDTO setYear(String year) {
    this.year = year;
    return this;
  }

  public String getModel() {
    return model;
  }

  public OfferDetailsViewDTO setModel(String model) {
    this.model = model;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public OfferDetailsViewDTO setBrand(String brand) {
    this.brand = brand;
    return this;
  }
}
