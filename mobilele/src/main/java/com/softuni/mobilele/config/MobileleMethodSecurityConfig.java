package com.softuni.mobilele.config;

import com.softuni.mobilele.services.OfferService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableMethodSecurity
public class MobileleMethodSecurityConfig {

  private final OfferService offerService;

  public MobileleMethodSecurityConfig(OfferService offerService) {
    this.offerService = offerService;
  }

  @Bean
  protected MethodSecurityExpressionHandler createExpressionHandler() {
    return new MobileleSecurityExpressionHandler(offerService);
  }
}
