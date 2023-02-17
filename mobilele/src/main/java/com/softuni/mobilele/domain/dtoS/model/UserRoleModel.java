package com.softuni.mobilele.domain.dtoS.model;

public class UserRoleModel {
    private String id;
    private String role;

    public UserRoleModel() {
    }

    public String getId() {
        return id;
    }

    public UserRoleModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserRoleModel setRole(String role) {
        this.role = role;
        return this;
    }
}
