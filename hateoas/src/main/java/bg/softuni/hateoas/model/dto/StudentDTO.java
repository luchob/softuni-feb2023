package bg.softuni.hateoas.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

public class StudentDTO {
  private long id;
  private String name;
  private int age;

  private boolean isDeleted;

  private List<OrderDTO> orders;

  public long getId() {
    return id;
  }

  public StudentDTO setId(long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentDTO setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public StudentDTO setAge(int age) {
    this.age = age;
    return this;
  }

  @JsonIgnore
  public boolean isDeleted() {
    return isDeleted;
  }

  public StudentDTO setDeleted(boolean deleted) {
    isDeleted = deleted;
    return this;
  }

  public List<OrderDTO> getOrders() {
    return orders;
  }

  public StudentDTO setOrders(List<OrderDTO> orders) {
    this.orders = orders;
    return this;
  }
}
