package com.example.crudspringboot.service;

import com.example.crudspringboot.dao.RoleDao;
import com.example.crudspringboot.model.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    @Transactional
    @Override
    public Collection<Role> allRoles() {
        return roleDao.findAll();
    }
}
