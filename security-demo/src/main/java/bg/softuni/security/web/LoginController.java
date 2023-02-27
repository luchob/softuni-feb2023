package bg.softuni.security.web;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

  @GetMapping("/users/login")
  public String login() {
    return "auth-login";
  }

  // POST (username: admin@example.com, password: bad) -> 301 (Location: /users/login)

  @PostMapping("/users/login-error")
  public String onFailedLogin(
      @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
      RedirectAttributes redirectAttributes) {

    redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
    redirectAttributes.addFlashAttribute("bad_credentials", true);

    return "redirect:/users/login";
  }

}
