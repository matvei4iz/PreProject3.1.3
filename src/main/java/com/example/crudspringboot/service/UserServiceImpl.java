package com.example.crudspringboot.service;

import com.example.crudspringboot.dao.UserDao;
import com.example.crudspringboot.model.Role;
import com.example.crudspringboot.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final RoleService roleService;

    @Transactional
    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
        user.setRoles(user.getRoles().stream()
                .map(r -> roleService.findByName(r.getName()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));
        userDao.add(user);
    }

    @Transactional
    @Override
    public void remove(long id) {
        userDao.remove(userDao.getById(id));
    }

    @Transactional
    @Override
    public void edit(User user) {
        user.setRoles(user.getRoles().stream()
                .map(r -> roleService.findByName(r.getName()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));
        userDao.edit(user);
    }

    @Transactional
    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Transactional
    @Override
    public User findByUsername(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
