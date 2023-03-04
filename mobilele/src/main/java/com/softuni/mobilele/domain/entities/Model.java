package com.softuni.mobilele.domain.entities;

import com.softuni.mobilele.domain.enums.ModelCategory;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "models")
public class Model extends BaseEntity {

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategory category;

    @Column
    private String imageUrl;

    @Column
    private Integer startYear;

    @Column
    private Integer endYear;

    @Column
    private Date created;

    @Column
    private Date modified;

    @ManyToOne
    private Brand brand;

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public Model setCategory(ModelCategory category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Model setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public Model setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public Model setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Model setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public Model setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
