package com.softuni.mobilele.web;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Value("${mail.host}")
  private String mailHost;

  @Value("${mail.port}")
  private Integer mailPort;
  @Value("${mail.username}")
  private String mailUsername;
  @Value("${mail.password}")
  private String mailPassword;

  private GreenMail greenMail;

  @BeforeEach
  void setUp() {
    greenMail = new GreenMail(new ServerSetup(mailPort, mailHost, "smtp"));
    greenMail.start();
    greenMail.setUser(mailUsername, mailPassword);
  }

  @AfterEach
  void tearDown() {
    greenMail.stop();
  }

  @Test
  void testRegistration() throws Exception {
    mockMvc.perform(post("/users/register").
        param("email", "pesho@example.com").
        param("firstName", "Pesho").
        param("lastName", "Petrov").
        param("password", "topsecret").
        param("confirmPassword", "topsecret").
        with(csrf())
    ).
        andExpect(status().is3xxRedirection()).
        andExpect(redirectedUrl("/users/login"));

    MimeMessage[] receivedMessages = greenMail.getReceivedMessages();
    Assertions.assertEquals(1, receivedMessages.length);

    MimeMessage welcomeMessage = receivedMessages[0];
    Assertions.assertTrue(
        welcomeMessage.getContent().toString().contains("Pesho Petrov"));
  }

}
