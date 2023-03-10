package bg.softuni.blacklist.config;

import bg.softuni.blacklist.web.IpBlackListInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfiguration implements WebMvcConfigurer {

  private IpBlackListInterceptor ipBlacklistInterceptor;

  public ApplicationConfiguration(IpBlackListInterceptor ipBlacklistInterceptor) {
    this.ipBlacklistInterceptor = ipBlacklistInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(ipBlacklistInterceptor);
    WebMvcConfigurer.super.addInterceptors(registry);
  }
}
