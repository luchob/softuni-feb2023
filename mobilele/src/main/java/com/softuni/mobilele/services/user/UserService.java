package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.dtoS.banding.UserLoginFormDto;
import com.softuni.mobilele.domain.dtoS.banding.UserRegisterFormDto;
import com.softuni.mobilele.domain.dtoS.model.UserModel;

public interface UserService {

    UserModel registerUser(UserRegisterFormDto userRegister);

    void loginUser(UserLoginFormDto userLogin);

    void logout();
}
