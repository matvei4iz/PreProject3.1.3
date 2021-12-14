package com.example.crudspringboot.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    @RequestMapping
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        ModelMap model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "loginBS";
    }

}
