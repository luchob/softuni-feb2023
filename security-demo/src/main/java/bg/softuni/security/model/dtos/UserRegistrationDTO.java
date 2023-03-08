package bg.softuni.security.model.dtos;

public class UserRegistrationDTO {

  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public String getFirstName() {
    return firstName;
  }

  public UserRegistrationDTO setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public UserRegistrationDTO setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserRegistrationDTO setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserRegistrationDTO setPassword(String password) {
    this.password = password;
    return this;
  }
}
