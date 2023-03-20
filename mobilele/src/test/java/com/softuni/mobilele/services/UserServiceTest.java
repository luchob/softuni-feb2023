package com.softuni.mobilele.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.entities.UserEntity;
import com.softuni.mobilele.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private PasswordEncoder mockPasswordEncoder;

  @Mock
  private UserRepository mockUserRepository;

  @Captor
  private ArgumentCaptor<UserEntity> userEntityArgumentCaptor;

  private UserService toTest;

  @BeforeEach
  void setUp() {
    toTest = new UserService(mockUserRepository, mockPasswordEncoder);
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
    Mockito.verify(mockUserRepository).save(any());
  }

  @Test
  void testUserRegistration_SaveInvoked_Version2() {

    // ARRANGE

    String testPassword = "topsecret";
    String encodedPassword = "encoded_password";

    UserRegisterFormDto testRegistrationDTO = new UserRegisterFormDto().
        setEmail("test@example.com").
        setFirstName("Test").
        setLastName("Testov").
        setPassword(testPassword);

    when(mockPasswordEncoder.encode(testRegistrationDTO.getPassword())).
        thenReturn(encodedPassword);

    //ACT

    toTest.registerUser(testRegistrationDTO);

    //ASSERT
    Mockito.verify(mockUserRepository).save(userEntityArgumentCaptor.capture());

    UserEntity actualSavedUser = userEntityArgumentCaptor.getValue();
    Assertions.assertEquals(testRegistrationDTO.getEmail(), actualSavedUser.getEmail());
    Assertions.assertEquals(encodedPassword, actualSavedUser.getPassword());

  }
}
