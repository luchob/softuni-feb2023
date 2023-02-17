package com.softuni.mobilele.services.role;

import com.softuni.mobilele.domain.dtoS.model.UserRoleModel;
import com.softuni.mobilele.domain.dtoS.veiw.UserRoleViewDto;
import com.softuni.mobilele.services.init.DataBaseInitServiceService;

import java.util.List;

public interface UserRoleService extends DataBaseInitServiceService {
    List<UserRoleViewDto> getAll();

    List<UserRoleModel> findAllRoles();

    UserRoleModel findRoleByName(String name);
}
