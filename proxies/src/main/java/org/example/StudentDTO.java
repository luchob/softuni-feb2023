package org.example;

public class StudentDTO {

  private String name;
  private int age;

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

  @Override
  public String toString() {
    return "StudentDTO{" +
        "name='" + name + '\'' +
        ", age=" + age +
        "}@" + hashCode();
  }
}
