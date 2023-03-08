package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.UserRegistrationFormDTO;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

  @ModelAttribute("registrationFormDTO")
  public UserRegistrationFormDTO registrationFormDTO() {
    return new UserRegistrationFormDTO();
  }

  @GetMapping("/users/register")
  public String register() {
    return "auth-register";
  }

  @PostMapping("/users/register")
  public String createAndRegisterUser(
      @Valid UserRegistrationFormDTO registrationFormDTO,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("registrationFormDTO", registrationFormDTO);
      redirectAttributes.addFlashAttribute(
          "org.springframework.validation.BindingResult.registrationFormDTO",
          bindingResult);
      return "redirect:/users/register";
    }

    return "redirect:/";
  }

}
