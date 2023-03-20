package com.softuni.mobilele.services;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.domain.entities.UserRoleEntity;
import com.softuni.mobilele.domain.enums.UserRoleEnum;
import com.softuni.mobilele.repositories.UserRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opentest4j.AssertionFailedError;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {

  private final String NOT_EXISTING_EMAIL = "pesho@example.com";

  private ApplicationUserDetailsService toTest;

  @Mock
  private UserRepository mockUserRepository;

  @BeforeEach
  void setUp() {
    toTest = new ApplicationUserDetailsService(
        mockUserRepository
    );
  }

  @Test
  void testUserFound() {

    // ARRANGE
    UserRoleEntity testAdminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
    UserRoleEntity testUserRole = new UserRoleEntity().setRole(UserRoleEnum.USER);

    String EXISTING_EMAIL = "admin@example.com";
    UserEntity testUserEntity = new UserEntity().
        setEmail(EXISTING_EMAIL).
        setPassword("topsecret").
        setRoles(List.of(testAdminRole, testUserRole));


    when(mockUserRepository.findByEmail(EXISTING_EMAIL)).
        thenReturn(Optional.of(testUserEntity));
    // EO: ARRANGE


    // ACT
    UserDetails adminDetails =
        toTest.loadUserByUsername(EXISTING_EMAIL);
    // EO: ACT

    // ASSERT
    Assertions.assertNotNull(adminDetails);
    Assertions.assertEquals(EXISTING_EMAIL, adminDetails.getUsername());
    Assertions.assertEquals(testUserEntity.getPassword(), adminDetails.getPassword());

    Assertions.assertEquals(2,
        adminDetails.getAuthorities().size(),
        "The authorities are supposed to be just two - ADMIN/USER.");

    assertRole(adminDetails.getAuthorities(), "ROLE_ADMIN");
    assertRole(adminDetails.getAuthorities(), "ROLE_USER");
    // EO: ASSERT
  }

  private void assertRole(Collection<? extends GrantedAuthority> authorities,
    String role) {
    authorities.
        stream().
        filter(a -> role.equals(a.getAuthority())).
        findAny().
        orElseThrow(() -> new AssertionFailedError("Role " + role + " not found!"));
  }


  @Test
  void testUserNotFound() {
    assertThrows(
        UsernameNotFoundException.class,
        () -> toTest.loadUserByUsername(NOT_EXISTING_EMAIL)
    );
  }
}
