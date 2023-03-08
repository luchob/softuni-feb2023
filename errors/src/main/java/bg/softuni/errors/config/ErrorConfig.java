package bg.softuni.errors.config;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

@Configuration
public class ErrorConfig {

  @Bean
  public HandlerExceptionResolver simpleMappingExceptionResolver() {
    SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();

    Properties properties = new Properties();

    properties.setProperty(NullPointerException.class.getSimpleName(), "npe");

    smer.setExceptionMappings(properties);

    return smer;
  }
}
