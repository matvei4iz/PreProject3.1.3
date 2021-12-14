package com.example.crudspringboot.controller;

import com.example.crudspringboot.model.User;
import com.example.crudspringboot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller
//@RequestMapping("/login")
//@AllArgsConstructor
//public class LoginController {
//
//    private final UserService userService;
//
//    @RequestMapping
//    public String login(@RequestParam(value = "error", required = false) String error,
//                        @RequestParam(value = "logout", required = false) String logout,
//                        ModelMap model) {
//        model.addAttribute("error", error != null);
//        model.addAttribute("logout", logout != null);
//        return "loginBS";
//    }
//
//    @PostMapping("/suc")
//    public String sucLogin(@ModelAttribute("user") User user) {
//        userService.loadUserByUsername(user.getUsername());
//        return
//    }
//}
