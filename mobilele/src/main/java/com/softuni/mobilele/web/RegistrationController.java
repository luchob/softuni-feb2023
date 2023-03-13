package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegistrationController {

  public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
  @GetMapping("/register") // post method localhost:8080/users/register
  public String getRegister(Model model) {
    return "auth-register";
  }

  @PostMapping("/register")
  public String postRegister(@Valid @ModelAttribute(name = "userRegisterForm") UserRegisterFormDto userRegisterInfo,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterInfo)
          .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

      return "redirect:register";
    }
    //todo

    return "redirect:login";
  }



  // Model attributes

  @ModelAttribute(name = "userRegisterForm")
  public UserRegisterFormDto initUserRegisterFormDto() {
    return new UserRegisterFormDto();
  }

}
