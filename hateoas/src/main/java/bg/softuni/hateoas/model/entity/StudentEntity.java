package bg.softuni.hateoas.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int age;
  private boolean deleted;

  @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
  private List<OrderEntity> orders;

  public Long getId() {
    return id;
  }

  public StudentEntity setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public StudentEntity setName(String name) {
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public StudentEntity setAge(int age) {
    this.age = age;
    return this;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public StudentEntity setDeleted(boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  public List<OrderEntity> getOrders() {
    return orders;
  }

  public StudentEntity setOrders(List<OrderEntity> orders) {
    this.orders = orders;
    return this;
  }
}
