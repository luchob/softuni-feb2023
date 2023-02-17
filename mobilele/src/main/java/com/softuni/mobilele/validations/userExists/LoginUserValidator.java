package com.softuni.mobilele.validations.userExists;

import com.softuni.mobilele.domain.dtoS.banding.UserLoginFormDto;
import com.softuni.mobilele.domain.enitities.User;
import com.softuni.mobilele.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public record LoginUserValidator(UserRepository userRepository,
                                 ModelMapper modelMapper)
        implements ConstraintValidator<ValidateLoginUser, UserLoginFormDto> {

    @Override
    public void initialize(ValidateLoginUser constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginFormDto userLogin, ConstraintValidatorContext constraintValidatorContext) {
        Optional<User> loginCandidate = this.userRepository.findByUsername(userLogin.getUsername());

        return loginCandidate.isPresent()
                && loginCandidate.get()
                .getPassword()
                .equals(userLogin.getPassword());
    }
}
