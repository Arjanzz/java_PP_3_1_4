package ru.nerobkov.spring.rest.service;

import ru.nerobkov.spring.rest.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();
    List<Role> findByName(List<String> name);
    void saveRole(Role role);
}
