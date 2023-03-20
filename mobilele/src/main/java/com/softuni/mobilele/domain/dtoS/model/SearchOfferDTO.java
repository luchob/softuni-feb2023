package com.softuni.mobilele.domain.dtoS.model;

public class SearchOfferDTO {

    private String model;

    private Integer minPrice;

    private Integer maxPrice;

    public String getModel() {
        return model;
    }

    public SearchOfferDTO setModel(String model) {
        this.model = model;
        return this;
    }

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

    public boolean isEmpty() {
        return (model == null || model.isEmpty()) &&
            minPrice == null &&
            maxPrice == null;
    }

    @Override
    public String toString() {
        return "SearchOfferDTO{" +
            "model='" + model + '\'' +
            ", minPrice=" + minPrice +
            ", maxPrice=" + maxPrice +
            '}';
    }
}
