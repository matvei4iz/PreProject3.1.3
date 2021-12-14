package com.example.crudspringboot.dao;

import com.example.crudspringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

}
