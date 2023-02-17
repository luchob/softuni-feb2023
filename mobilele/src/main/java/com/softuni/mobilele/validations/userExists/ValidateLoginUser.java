package com.softuni.mobilele.validations.userExists;

import com.softuni.mobilele.validations.matchingPasswords.PasswordMather;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = LoginUserValidator.class)
public @interface ValidateLoginUser {

    String message() default "Username Or Password doesn't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
