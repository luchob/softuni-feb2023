package com.softuni.mobilele.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_activation")
public class UserActivationEntity extends BaseEntity {

  @OneToOne
  private UserEntity user;

  private String activation;

  public UserEntity getUser() {
    return user;
  }

  public UserActivationEntity setUser(UserEntity user) {
    this.user = user;
    return this;
  }

  public String getActivation() {
    return activation;
  }

  public UserActivationEntity setActivation(String activation) {
    this.activation = activation;
    return this;
  }

  @Override
  public String toString() {
    return "UserActivationEntity{" +
        "user=" + user +
        ", activation='" + activation + '\'' +
        '}';
  }
}
