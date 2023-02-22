package bg.softuni.security.service.impl;

import static org.mockito.Mockito.when;

import bg.softuni.security.model.entity.UserEntity;
import bg.softuni.security.model.entity.UserRoleEntity;
import bg.softuni.security.model.enums.UserRoleEnum;
import bg.softuni.security.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
class AppUserDetailsServiceTest {

  private AppUserDetailsService toTest;

  private UserEntity testUserEntity;

  @Mock
  private UserRepository mockUserRepository;

  @BeforeEach
  void setUp() {
    toTest = new AppUserDetailsService(mockUserRepository);

    testUserEntity = new UserEntity().
        setEmail("pesho@pesho.com").
        setPassword("topsecret").
        setFirstName("Pesho").
        setRoles(List.of(new UserRoleEntity().setRole(UserRoleEnum.MODERATOR)));
  }

  @Test
  void loadUserByUsername_UserFound() {
    var testEmail = testUserEntity.getEmail();

    // Arrange
    when(mockUserRepository.findByEmail(testEmail)).
        thenReturn(Optional.of(testUserEntity));

    // Act
    UserDetails actual = toTest.loadUserByUsername(testEmail);

    // Assert
    Assertions.assertEquals(testEmail, actual.getUsername());
    Assertions.assertEquals(testUserEntity.getPassword(), actual.getPassword());
    Assertions.assertEquals(testUserEntity.getRoles().size(), actual.getAuthorities().size());

    testUserEntity.getRoles().forEach(
        r ->
          Assertions.assertTrue(actual.
              getAuthorities().
              stream().
              anyMatch(a -> ("ROLE_" + r.getRole().name()).equals(a.getAuthority())),
              "Role " + r.getRole().name() + " is not mapped correctly!")
    );
  }

  @Test
  void loadUserByUsername_UserNotFound() {
    // Arrange
    // nothing to do here

    // Act, Assert
    Assertions.assertThrows(
        UsernameNotFoundException.class,
        () -> toTest.loadUserByUsername("pesho")
    );
  }

}
