package com.softuni.mobilele.config;

import com.softuni.mobilele.services.OfferService;
import com.softuni.mobilele.services.security.MobileleSecurityExpressionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity
public class MobileleMethodSecurityConfig {
  private final OfferService offerService;

  public MobileleMethodSecurityConfig(OfferService offerService) {
    this.offerService = offerService;
  }

  @Bean
  public MethodSecurityExpressionHandler createExpressionHandler() {
    return new MobileleSecurityExpressionHandler(offerService);
  }
}
