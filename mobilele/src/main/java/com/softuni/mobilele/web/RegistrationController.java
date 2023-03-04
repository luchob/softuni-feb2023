package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

  @GetMapping("/users/register")
  public String register() {
    return "auth-register";
  }

}
