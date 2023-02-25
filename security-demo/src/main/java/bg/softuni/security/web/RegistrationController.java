package bg.softuni.security.web;

import bg.softuni.security.model.dto.UserRegistrationDTO;
import bg.softuni.security.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

  private final UserService userService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/register")
  public String register() {
    return "auth-register";
  }

  @PostMapping("/users/register")
  public String register(
      @RequestBody UserRegistrationDTO body) {

    userService.register(body);

    return "redirect:/";
  }
}