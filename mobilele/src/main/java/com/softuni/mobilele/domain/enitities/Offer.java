package com.softuni.mobilele.domain.enitities;

import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private Engine engine;

    @Column
    private String imageUrl;

    @Column
    private String mileage;

    @Column
    private String price;

    @Enumerated(EnumType.STRING)
    private Transmission transmission;

    @Column
    private String year;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;

    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Offer setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Offer setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getMileage() {
        return mileage;
    }

    public Offer setMileage(String mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public Offer setPrice(String price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public Offer setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Offer setYear(String year) {
        this.year = year;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Offer setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public Offer setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public Offer setModel(Model model) {
        this.model = model;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
