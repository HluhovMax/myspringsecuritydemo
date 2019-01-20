package com.example.myspringsecuritydemo.controller;

import com.example.myspringsecuritydemo.model.User;
import com.example.myspringsecuritydemo.service.SecurityService;
import com.example.myspringsecuritydemo.service.UserService;
import com.example.myspringsecuritydemo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Autowired
    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute User userForm, BindingResult bindingResult, Model model) {
        model.addAttribute("userForm", userForm);
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "welcome";
    }

    @GetMapping("/login")
    public String login(Model model , String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

//    @PostMapping("/login")
//    public String loggedIn(Model model) {
//        return "welcome";
//    }

    @GetMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/403")
    public String denied(Model model) {
        return "403";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "logout";
    }
}
