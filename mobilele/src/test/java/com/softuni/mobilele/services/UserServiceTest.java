package com.softuni.mobilele.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private PasswordEncoder mockPasswordEncoder;

  @Mock
  private UserRepository mockUserRepository;

  @Mock
  private EmailService mockEmailService;

  @Captor
  private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;

  private UserService toTest;

  @BeforeEach
  void setUp() {
    toTest = new UserService(
        mockUserRepository,
        mockPasswordEncoder,
        mockEmailService);
  }

  @Test
  void testUserRegistration_SaveInvoked() {

    //LEFT for reference

    // ARRANGE
    UserRegisterFormDto testRegistrationDTO = new UserRegisterFormDto().
        setEmail("test@example.com").
        setFirstName("Test").
        setLastName("Testov").
        setPassword("topsecret");

    //ACT

    toTest.registerUser(testRegistrationDTO);

    //ASSERT
    verify(mockUserRepository).save(any());
  }

  @Test
  void testUserRegistration_SaveInvoked_Version2() {

    // ARRANGE

    String testPassword = "topsecret";
    String encodedPassword = "encoded_password";
    String email = "test@example.com";
    String firstName = "Test";
    String lastName = "Testov";

    UserRegisterFormDto testRegistrationDTO = new UserRegisterFormDto().
        setEmail("test@example.com").
        setFirstName(firstName).
        setLastName(lastName).
        setPassword(testPassword);

    when(mockPasswordEncoder.encode(testRegistrationDTO.getPassword())).
        thenReturn(encodedPassword);

    //ACT

    toTest.registerUser(testRegistrationDTO);

    //ASSERT
    verify(mockUserRepository).save(userEntityArgumentCaptor.capture());

    UserEntity actualSavedUser = userEntityArgumentCaptor.getValue();
    assertEquals(testRegistrationDTO.getEmail(), actualSavedUser.getEmail());
    assertEquals(encodedPassword, actualSavedUser.getPassword());

    verify(mockEmailService).
        sendRegistrationEmail(email, firstName + " " + lastName);

  }
}
