package bg.softuni.security.service;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import bg.softuni.security.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitService {

  private UserRoleRepository userRoleRepository;
  private UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public InitService(UserRoleRepository userRoleRepository,
      UserRepository userRepository,
      PasswordEncoder passwordEncoder,
      @Value("${app.default.password}") String defaultPassword) {
    this.userRoleRepository = userRoleRepository;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @PostConstruct
  public void init() {
    initRoles();
    initUsers();
  }

  private void initRoles() {
    if (userRoleRepository.count() == 0) {
      var moderatorRole = new UserRoleEntity().setRole(UserRoleEnum.MODERATOR);
      var adminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);

      userRoleRepository.save(moderatorRole);
      userRoleRepository.save(adminRole);
    }
  }

  private void initUsers() {
    if (userRepository.count() == 0) {
      initAdmin();
      initModerator();
      initNormalUser();
    }
  }

  private void initAdmin(){
    var adminUser = new UserEntity().
        setEmail("admin@example.com").
        setFirstName("Admin").
        setLastName("Adminov").
        setPassword(passwordEncoder.encode("topsecret")).
        setRoles(userRoleRepository.findAll());

    userRepository.save(adminUser);
  }

  private void initModerator(){

    var moderatorRole = userRoleRepository.
        findUserRoleEntityByRole(UserRoleEnum.MODERATOR).orElseThrow();

    var moderatorUser = new UserEntity().
        setEmail("moderator@example.com").
        setFirstName("Moderator").
        setLastName("Moderatorov").
        setPassword(passwordEncoder.encode("topsecret")).
        setRoles(List.of(moderatorRole));

    userRepository.save(moderatorUser);
  }

  private void initNormalUser(){

    var normalUser = new UserEntity().
        setEmail("user@example.com").
        setFirstName("User").
        setLastName("Userov").
        setPassword(passwordEncoder.encode("topsecret"));

    userRepository.save(normalUser);
  }
}
