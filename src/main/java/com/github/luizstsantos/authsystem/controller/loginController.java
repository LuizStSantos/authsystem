package com.github.luizstsantos.authsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.luizstsantos.authsystem.repository.UserRepository;

import org.springframework.ui.Model;

import com.github.luizstsantos.authsystem.model.user;

import com.github.luizstsantos.authsystem.service.CookieService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @Autowired
    private UserRepository ur;

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
        String name = CookieService.getCookie(request, "name");
        if (name != null) {
            model.addAttribute("user", new user() {{
                setName(name);
            }});
        }
        return "home";
    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(user user, Model model, HttpServletResponse response) {
        user authenticatedUser = this.ur.login(user.getEmail(), user.getPassword());
        if (authenticatedUser != null) {
            try {
                CookieService.setCookie(response, "userId", String.valueOf(authenticatedUser.getId()), 3600);
                CookieService.setCookie(response, "name", authenticatedUser.getName(), 3600);
            } catch (Exception e) {
                model.addAttribute("error", "Failed to set cookie");
                return "login";
            }
            return "redirect:/home";
        }
        model.addAttribute("error", "Invalid user credentials");
        return "login";
    }
    
    @GetMapping("/register")
    public String regsiter() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@Valid user user, BindingResult result) {
        if (result.hasErrors()) {
            return "/register";
        }

        ur.save(user);

        return "/login";
    }
}
