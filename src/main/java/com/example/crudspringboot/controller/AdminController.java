package com.example.crudspringboot.controller;

import com.example.crudspringboot.model.User;
import com.example.crudspringboot.service.RoleService;
import com.example.crudspringboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    @GetMapping
    public String index(ModelMap model) {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", roleService.allRoles());
        model.addAttribute("thisUser", user);
        model.addAttribute("users", userService.allUsers());
        model.addAttribute("flag", user.getUserRolesForUI().contains("ADMIN"));
        return "mainPageBS";
    }


    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/admin";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("User") User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.remove(userService.getById(id));
        return "redirect:/admin";
    }
}
