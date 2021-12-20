package com.example.crudspringboot.service;

import com.example.crudspringboot.model.Role;

import java.util.Collection;
import java.util.Optional;

public interface RoleService {
    Collection<Role> allRoles();
    Optional<Role> findByName(String name);
}
