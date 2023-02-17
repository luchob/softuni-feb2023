package com.softuni.mobilele.domain.enitities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column
    private String username; // –  username of the user.

    @Column
    private String password; //– password of the user.

    @Column
    private String firstName; //–  first name of the user.

    @Column
    private String lastName; //–  last name of the user.

    @Column
    private Boolean isActive; //– true OR false.

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<UserRole> role; //–  user's role (User or Admin).

    @Column
    private String imageUrl;//– a url of user's picture.

    @Column
    private Date created; // a date and time.

    @Column
    private Date modified;//– a date and time.

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public User setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRole> getRole() {
        return role;
    }

    public User setRole(List<UserRole> role) {
        this.role = role;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public User setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public User setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public User setModified(Date modified) {
        this.modified = modified;
        return this;
    }
}
