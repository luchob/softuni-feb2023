package com.softuni.mobilele.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.Locale;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

  private final JavaMailSender javaMailSender;
  private final TemplateEngine templateEngine;

  public EmailService(JavaMailSender javaMailSender,
      TemplateEngine templateEngine) {
    this.javaMailSender = javaMailSender;
    this.templateEngine = templateEngine;
  }

  public void sendRegistrationEmail(
      String userEmail,
      String userName
  ) {
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();

    MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);

    try {
      mimeMessageHelper.setFrom("mobilele@example.com");
      mimeMessageHelper.setTo(userEmail);
      //TODO: i18n
      mimeMessageHelper.setSubject("Welcome to Mobilele!");
      mimeMessageHelper.setText(generateEmailText(userName), true);

      javaMailSender.send(mimeMessageHelper.getMimeMessage());

    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }

  }

  private String generateEmailText(String userName) {
    Context ctx = new Context();
    ctx.setLocale(Locale.getDefault());
    ctx.setVariable("userName", userName);

    return templateEngine.process("email/registration", ctx);
  }

}
