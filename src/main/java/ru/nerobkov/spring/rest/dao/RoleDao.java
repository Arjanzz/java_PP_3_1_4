package ru.nerobkov.spring.rest.dao;

import ru.nerobkov.spring.rest.models.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAll();
    List<Role> findByName(List<String> name);
    void saveRole(Role role);
}
