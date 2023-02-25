package bg.softuni.security.service;

import bg.softuni.security.model.dto.UserRegistrationDTO;
import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository,
      PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void register(UserRegistrationDTO registrationForm) {
    userRepository.save(new UserEntity().
        setEmail(registrationForm.getEmail()).
        setFirstName(registrationForm.getFirstName()).
        setLastName(registrationForm.getLastName()).
        setPassword(passwordEncoder.encode(registrationForm.getPassword())));
  }

  public void login() {

  }

}
