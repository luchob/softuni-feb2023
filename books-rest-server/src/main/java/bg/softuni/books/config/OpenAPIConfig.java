package bg.softuni.books.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI().info(
        new Info().
            title("Our SoftUni book API").
            contact(
                new Contact().
                    email("students@softuni.bg").name("The Students")

            ).
            description("Small API for books/authors description.")
    );
  }

}
